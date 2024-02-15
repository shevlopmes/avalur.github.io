# Neapolis University Pafos, Programming Paradigms, Homework 1, assignment1.py
# (See also some example tests code in assignment1tests.py)

# A little language for 2D geometry objects.
# Each subclass of GeometryExpression, including subclasses of GeometryValue,
# needs to respond to messages `preprocess_prog` and `eval_prog`.
#
# Each subclass of GeometryValue additionally needs:
#   * shift
#   * intersect, which uses the double-dispatch pattern
#   * intersectPoint, intersectLine, and intersectVerticalLine for
#       being called by intersect of appropriate classes and doing
#       the correct intersection calculation
#   * (We would need intersectNoPoints and intersectLineSegment, but these
#      are provided by GeometryValue and should not be overridden.)
#   *  intersectWithSegmentAsLineResult, which is used by
#      intersectLineSegment as described in the assignment
#
# You can define other helper methods, but will not find much need to.

# Note: geometry objects should be immutable:
# assign to fields only during object construction

# Note: For `eval_prog`, represent environments as arrays of 2-element arrays
# as described in the assignment


class GeometryExpression():
    """
    Do *not* change this class definition
    """
    Epsilon = 0.00001


class GeometryValue(GeometryExpression):
    # do *not* change methods in this class definition
    # you can add methods if you wish

    # private
    # Some helper methods that may be generally useful
    def real_close(self, r1, r2):
        return abs(r1 - r2) < GeometryExpression.Epsilon

    def real_close_point(self, x1, y1, x2, y2):
        return self.real_close(x1, x2) and self.real_close(y1, y2)

    def two_points_to_line(self, x1, y1, x2, y2):
        """
        This function could return a Line or a VerticalLine. Draws a line between the two points.
        """
        if self.real_close(x1, x2):
            return VerticalLine(x1)
        else:
            m = (y2 - y1) / (x2 - x1)
            b = y1 - m * x1
            return Line(m, b)

    def inbetween(self, v, v1, v2):
        """
        Checks if a given point is inbetween two other points on a one-dimensional line.
        """
        eps = GeometryExpression.Epsilon
        return ((v1 - eps <= v <= v2 + eps) or
                (v2 - eps <= v <= v1 + eps))

    # public
    def intersect_no_points(self, np):
        """
        The intersection of self with a NoPoints is a NoPoints object
        We put this in here so all subclasses can inherit it
        """
        return np

    def intersect_line_segment(self, seg):
        """
        The intersection of self with a LineSegment is computed by
        first intersecting with the line containing the segment and calling
        the result's intersectWithSegmentAsLineResult with the segment
        We put this in here so all subclasses can inherit it
        """
        line_result = self.intersect(self.two_points_to_line(seg.x1, seg.y1, seg.x2, seg.y2))
        return line_result.intersect_with_segment_as_line_result(seg)


# Note: no initialize method only because there is nothing it needs to do
class NoPoints(GeometryValue):
    """
    Do *not* change this class definition: everything is done for you
    (although this is the easiest class, it shows what methods every subclass
    of geometry values needs)
    However, you *may* move methods from here to a superclass if you wish to
    """

    def eval_prog(self, env):
        """
        All values evaluate to self
        """
        return self

    def preprocess_prog(self):
        """
        No pre-processing to do here
        """
        return self

    def shift(self, dx, dy):
        """
        Shifting no-points is no-points
        """
        return self

    def intersect(self, other):
        """
        Will be NoPoints but follow double-dispatch
        """
        return other.intersect_no_points(self)

    def intersect_point(self, p):
        """
        Intersection with point and no-points is no-points
        """
        return self

    def intersect_line(self, line):
        """
        Intersection with line and no-points is no-points
        """
        return self

    def intersect_vertical_line(self, vline):
        """
        Intersection with vertical line and no-points is no-points
        """
        return self

    def intersect_with_segment_as_line_result(self, seg):
        """
        If self is the intersection of some shape s and
        the line containing seg, then we return the intersection of the
        shape s and the seg. Seg is an instance of LineSegment
        """
        return self


class Point(GeometryValue):
    """
    Add methods to this class -- do not change given code and do not
    override any methods
    """

    def __init__(self, x, y):
        self.x = x
        self.y = y

    def eval_prog(self, env):
        """
        All values evaluate to self
        """
        return self

    def preprocess_prog(self):
        """
        No pre-processing to do here
        """
        return self

    def shift(self, dx, dy):
        return Point(self.x + dx, self.y + dy)

    def intersect(self, other):
        return other.intersect_point(self)

    def intersect_point(self, p):
        if self.real_close_point(self.x, self.y, p.x, p.y):
            return Point(self.x, self.y)
        else:
            return NoPoints()

    def intersect_line(self, line):
        if self.real_close(self.y, line.m * self.x + line.b):
            return Point(self.x, self.y)
        else:
            return NoPoints()

    def intersect_vertical_line(self, vline):
        if self.real_close(self.x, vline.x):
            return Point(self.x, self.y)
        else:
            return NoPoints()

    # if self is the intersection of (1) some shape s and (2)
    # the line containing seg, then we return the intersection of the
    # shape s and the seg.  seg is an instance of LineSegment
    def intersect_with_segment_as_line_result(self, seg):
        if self.inbetween(self.x, seg.x1, seg.x2) and self.inbetween(self.y, seg.y1, seg.y2):
            return Point(self.x, self.y)
        else:
            return NoPoints()


class Line(GeometryValue):
    """
    Add methods to this class -- do not change given code and do not
    override any methods
    """

    def __init__(self, m, b):
        self.m = m
        self.b = b

    def eval_prog(self, env):
        """
        All values evaluate to self
        """
        return self

    def preprocess_prog(self):
        """
        No pre-processing to do here
        """
        return self

    def shift(self, dx, dy):
        return Line(self.m, self.b + dy - self.m * dx)

    def intersect(self, other):
        return other.intersect_line(self)

    def intersect_point(self, p):
        return p.intersect_line(self)

    def intersect_line(self, line):
        if self.real_close(self.m, line.m):
            if self.real_close(self.b, line.b):
                return Line(self.m, self.b)
            else:
                return NoPoints()
        else:
            x = (line.b - self.b) / (self.m - line.m)
            return Point(x, self.m * x + self.b)

    def intersect_vertical_line(self, vline):
        return Point(vline.x, self.m * vline.x + self.b)

    # if self is the intersection of (1) some shape s and (2)
    # the line containing seg, then we return the intersection of the
    # shape s and the seg.  seg is an instance of LineSegment
    def intersect_with_segment_as_line_result(self, seg):
        return LineSegment(seg.x1, seg.y1, seg.x2, seg.y2)


class VerticalLine(GeometryValue):
    """
    Add methods to this class -- do not change given code and do not
    override any methods
    """

    def __init__(self, x):
        self.x = x

    def eval_prog(self, env):
        """
        All values evaluate to self
        """
        return self

    def preprocess_prog(self):
        """
        No pre-processing to do here
        """
        return self

    def shift(self, dx, dy):
        return VerticalLine(self.x + dx)

    def intersect(self, other):
        return other.intersect_vertical_line(self)

    def intersect_point(self, p):
        return p.intersect_vertical_line(self)

    def intersect_line(self, line):
        return line.intersect_vertical_line(self)

    def intersect_vertical_line(self, vline):
        if self.real_close(self.x, vline.x):
            return VerticalLine(self.x)
        else:
            return NoPoints()

    # if self is the intersection of (1) some shape s and (2)
    # the line containing seg, then we return the intersection of the
    # shape s and the seg.  seg is an instance of LineSegment
    def intersect_with_segment_as_line_result(self, seg):
        return LineSegment(seg.x1, seg.y1, seg.x2, seg.y2)


class LineSegment(GeometryValue):
    """
    * Add methods to this class -- do not change given code and do not
      override any methods
    * preprocess_prog is about 15 lines long and
      intersect_with_segment_as_line_result is about 40 lines long
    """

    def __init__(self, x1, y1, x2, y2):
        self.x1 = x1
        self.y1 = y1
        self.x2 = x2
        self.y2 = y2

    def eval_prog(self, env):
        """
        All values evaluate to self
        """
        return self

    def preprocess_prog(self):
        if self.real_close_point(self.x1, self.y1, self.x2, self.y2):
            return Point(self.x1, self.y1)
        else:
            if (self.real_close(self.x1, self.x2) and self.y1 < self.y2) or (self.x1 < self.x2):
                return LineSegment(self.x1, self.y1, self.x2, self.y2)
            else:
                return LineSegment(self.x2, self.y2, self.x1, self.y1)

    def shift(self, dx, dy):
        return LineSegment(self.x1 + dx, self.y1 + dy, self.x2 + dx, self.y2 + dy)

    def intersect(self, other):
        return other.intersect_line_segment(self)

    def intersect_point(self, p):
        return p.intersect_line_segment(self)

    def intersect_line(self, line):
        return line.intersect_line_segment(self)

    def intersect_vertical_line(self, vline):
        return vline.intersect_line_segment(self)

    # if self is the intersection of (1) some shape s and (2)
    # the line containing seg, then we return the intersection of the
    # shape s and the seg.  seg is an instance of LineSegment
    # the hardest case: self and seg are segs on the same
    # line (or vertical line), but they could be
    # (1) disjoint or (2) overlapping or (3) one inside the other or (4) just touching.
    # And we treat vertical segments differently, so there are 4*2 cases.
    def intersect_with_segment_as_line_result(self, seg):
        if self.real_close(self.x1, self.x2):
            # the segments are on a vertical line
            # let segment a start at or below start of segment b
            a_x_start, a_y_start, a_x_end, a_y_end, b_x_start, b_y_start, b_x_end, b_y_end = \
                [self.x1, self.y1, self.x2, self.y2, seg.x1, seg.y1, seg.x2, seg.y2] if self.y1 < seg.y1 else \
                [seg.x1, seg.y1, seg.x2, seg.y2, self.x1, self.y1, self.x2, self.y2]
            if self.real_close(a_y_end, b_y_start):
                return Point(a_x_end, a_y_end)  # just touching
            else:
                if a_y_end < b_y_start:
                    return NoPoints()  # disjoint
                else:
                    if a_y_end > b_y_end:
                        return LineSegment(b_x_start, b_y_start, b_x_end, b_y_end)  # b inside a
                    else:
                        return LineSegment(b_x_start, b_y_start, a_x_end, a_y_end)  # overlapping
        else:
            # the segments are on a (non-vertical) line
            # let segment a start at or to the left of start of segment b
            a_x_start, a_y_start, a_x_end, a_y_end, b_x_start, b_y_start, b_x_end, b_y_end = \
                [self.x1, self.y1, self.x2, self.y2, seg.x1, seg.y1, seg.x2, seg.y2] if self.x1 < seg.x1 else \
                [seg.x1, seg.y1, seg.x2, seg.y2, self.x1, self.y1, self.x2, self.y2]
            if self.real_close(a_x_end, b_x_start):
                return Point(a_x_end, a_y_end)  # just touching
            else:
                if a_x_end < b_x_start:
                    return NoPoints()  # disjoint
                else:
                    if a_x_end > b_x_end:
                        return LineSegment(b_x_start, b_y_start, b_x_end, b_y_end)  # b inside a
                    else:
                        return LineSegment(b_x_start, b_y_start, a_x_end, a_y_end)  # overlapping


# Note: there is no need for getter methods for the non-value classes
class Intersect(GeometryExpression):
    """
    Add methods to this class -- do not change given code and do not override any methods
    """

    def __init__(self, e1, e2):
        self.e1 = e1
        self.e2 = e2

    def eval_prog(self, env):
        return self.e1.eval_prog(env).intersect(self.e2.eval_prog(env))

    def preprocess_prog(self):
        return Intersect(self.e1.preprocess_prog(), self.e2.preprocess_prog())


class Let(GeometryExpression):
    """
    Add methods to this class -- do not change given code and do not override any methods
    Let is a special kind of expression takes a string (which is a variable name),
    an expression (value to be assigned to that variable),
    and another expression (where that variable will be used).
    """

    def __init__(self, s, e1, e2):
        self.s = s
        self.e1 = e1
        self.e2 = e2

    def eval_prog(self, env):
        env_n = list(env)
        env_n.insert(0, [self.s, self.e1.eval_prog(env)])
        return self.e2.eval_prog(env_n)

    def preprocess_prog(self):
        return Let(self.s, self.e1.preprocess_prog(), self.e2.preprocess_prog())


class Var(GeometryExpression):
    """
    Add methods to this class -- do not change given code and do not
    override any methods
    """

    def __init__(self, s):
        self.s = s

    def eval_prog(self, env):
        pr = next((pair for pair in env if pair[0] == self.s), None)
        if pr is None:
            raise Exception("Undefined variable")
        return pr[1]

    def preprocess_prog(self):
        return self


class Shift(GeometryExpression):
    """
    Add methods to this class -- do not change given code and do not
    override any methods
    """

    def __init__(self, dx, dy, e):
        self.dx = dx
        self.dy = dy
        self.e = e

    def eval_prog(self, env):
        return self.e.eval_prog(env).shift(self.dx, self.dy)

    def preprocess_prog(self):
        return Shift(self.dx, self.dy, self.e.preprocess_prog())
