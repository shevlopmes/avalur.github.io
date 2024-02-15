# Neapolis University Pafos, Programming Paradigms, Homework 1,
# assignment1tests.py

import unittest
from assignment1 import *

# Will not work completely until you implement all the classes and their methods
# Will print only if code has errors; prints nothing if all tests pass
# These tests do NOT cover all the various cases, especially for intersection

# Constants for testing
ZERO = 0.0
ONE = 1.0
TWO = 2.0
THREE = 3.0
FOUR = 4.0
FIVE = 5.0
SIX = 6.0
SEVEN = 7.0
NINE = 9.0
TEN = 10.0


class TestGeometry(unittest.TestCase):

    def test_point(self):
        a = Point(THREE, FIVE)

        self.assertTupleEqual((a.x, a.y), (THREE, FIVE), "Point is not initialized properly")

        self.assertEqual(a.eval_prog([]), a, "Point eval_prog should return self")

        self.assertEqual(a.preprocess_prog(), a, "Point preprocess_prog should return self")

        a1 = a.shift(THREE, FIVE)
        self.assertTupleEqual((a1.x, a1.y), (SIX, TEN), "Point shift is not working properly")

        a2 = a.intersect(Point(THREE, FIVE))
        self.assertEqual(a2.x, THREE, "Point intersect not working properly")
        self.assertEqual(a2.y, FIVE, "Point intersect not working properly")

        a3 = a.intersect(Point(FOUR, FIVE))
        self.assertIsInstance(a3, NoPoints, "Point intersect not working properly")

    def test_line(self):
        b = Line(THREE, FIVE)
        self.assertEqual(b.m, THREE, "Line not initialized properly")
        self.assertEqual(b.b, FIVE, "Line not initialized properly")

        self.assertEqual(b.eval_prog([]), b, "Line eval_prog should return self")

        self.assertEqual(b.preprocess_prog(), b, "Line preprocess_prog should return self")

        b1 = b.shift(THREE, FIVE)
        self.assertEqual(b1.m, THREE, "Line shift not working properly")
        self.assertEqual(b1.b, ONE, "Line shift not working properly")

        b2 = b.intersect(Line(THREE, FIVE))
        self.assertTrue(isinstance(b2, Line), "Line intersect not working properly")
        self.assertEqual(b2.m, THREE, "Line intersect not working properly")
        self.assertEqual(b2.b, FIVE, "Line intersect not working properly")

        b3 = b.intersect(Line(THREE, FOUR))
        self.assertIsInstance(b3, NoPoints, "Line intersect not working properly")

    def test_vertical_line(self):
        c = VerticalLine(THREE)
        self.assertEqual(c.x, THREE, "VerticalLine not initialized properly")

        self.assertEqual(c.eval_prog([]), c, "VerticalLine eval_prog should return self")

        self.assertEqual(c.preprocess_prog(), c, "VerticalLine preprocess_prog should return self")

        c1 = c.shift(THREE, FIVE)
        self.assertEqual(c1.x, SIX, "VerticalLine shift not working properly")

        c2 = c.intersect(VerticalLine(THREE))
        self.assertTrue(isinstance(c2, VerticalLine), "VerticalLine intersect not working properly")
        self.assertEqual(c2.x, THREE, "VerticalLine intersect not working properly")

        c3 = c.intersect(VerticalLine(FOUR))
        self.assertIsInstance(c3, NoPoints, "VerticalLine intersect not working properly")

    def test_line_segment(self):
        d = LineSegment(ONE, TWO, -THREE, -FOUR)
        self.assertEqual(d.eval_prog([]), d, "LineSegement eval_prog should return self")

        d1 = LineSegment(ONE, TWO, ONE, TWO)
        d2 = d1.preprocess_prog()
        self.assertIsInstance(d2, Point,
                              "LineSegment preprocess_prog should convert to a Point if ends of segment are real_close")
        self.assertEqual(d2.x, ONE,
                         "LineSegment preprocess_prog should convert to a Point if ends of segment are real_close")
        self.assertEqual(d2.y, TWO,
                         "LineSegment preprocess_prog should convert to a Point if ends of segment are real_close")

        d = d.preprocess_prog()
        self.assertEqual(d.x1, -THREE, "LineSegment preprocess_prog should make x1 and y1 on the left of x2 and y2")
        self.assertEqual(d.y1, -FOUR, "LineSegment preprocess_prog should make x1 and y1 on the left of x2 and y2")
        self.assertEqual(d.x2, ONE, "LineSegment preprocess_prog should make x1 and y1 on the left of x2 and y2")
        self.assertEqual(d.y2, TWO, "LineSegment preprocess_prog should make x1 and y1 on the left of x2 and y2")

        d3 = d.shift(THREE, FIVE)
        self.assertEqual(d3.x1, ZERO, "LineSegment shift not working properly")
        self.assertEqual(d3.y1, ONE, "LineSegment shift not working properly")
        self.assertEqual(d3.x2, FOUR, "LineSegment shift not working properly")
        self.assertEqual(d3.y2, SEVEN, "LineSegment shift not working properly")

        d4 = d.intersect(LineSegment(-THREE, -FOUR, ONE, TWO))
        self.assertIsInstance(d4, LineSegment, "LineSegment intersect not working properly")
        self.assertEqual(d4.x1, -THREE, "LineSegment intersect not working properly")
        self.assertEqual(d4.y1, -FOUR, "LineSegment intersect not working properly")
        self.assertEqual(d4.x2, ONE, "LineSegment intersect not working properly")
        self.assertEqual(d4.y2, TWO, "LineSegment intersect not working properly")

        d5 = d.intersect(LineSegment(TWO, THREE, FOUR, FIVE))
        self.assertIsInstance(d5, NoPoints, "LineSegment intersect not working properly")

    def test_intersect(self):
        i = Intersect(LineSegment(-ONE, -TWO, THREE, FOUR), LineSegment(THREE, FOUR, -ONE, -TWO))
        i1 = i.preprocess_prog().eval_prog([])
        self.assertEqual(i1.x1, -ONE, "Intersect eval_prog should return the intersect between e1 and e2")
        self.assertEqual(i1.y1, -TWO, "Intersect eval_prog should return the intersect between e1 and e2")
        self.assertEqual(i1.x2, THREE, "Intersect eval_prog should return the intersect between e1 and e2")
        self.assertEqual(i1.y2, FOUR, "Intersect eval_prog should return the intersect between e1 and e2")

        i = Intersect(Point(2.5, 1.5),
                      Intersect(LineSegment(2.0, 1.0, 3.0, 2.0),
                                Intersect(LineSegment(0.0, 0.0, 2.5, 1.5), Line(1.0, -1.0))))
        i1 = i.preprocess_prog().eval_prog([])
        self.assertEqual(i1.x, 2.5, "Intersect eval_prog should return the point")
        self.assertEqual(i1.y, 1.5, "Intersect eval_prog should return the point")

    def test_var(self):
        v = Var("a")
        v1 = v.eval_prog([["a", Point(THREE, FIVE)]])
        self.assertIsInstance(v1, Point, "Var eval_prog is not working properly")
        self.assertEqual(v1.x, THREE, "Var eval_prog is not working properly")
        self.assertEqual(v1.y, FIVE, "Var eval_prog is not working properly")
        self.assertEqual(v.preprocess_prog(), v, "Var preprocess_prog should return self")

    def test_let(self):
        l = Let("a", LineSegment(-ONE, -TWO, THREE, FOUR), Intersect(Var("a"), LineSegment(THREE, FOUR, -ONE, -TWO)))
        l1 = l.preprocess_prog().eval_prog([])
        self.assertEqual(l1.x1, -ONE, "Let eval_prog should evaluate e2 after adding [s, e1] to the environment")
        self.assertEqual(l1.y1, -TWO, "Let eval_prog should evaluate e2 after adding [s, e1] to the environment")
        self.assertEqual(l1.x2, THREE, "Let eval_prog should evaluate e2 after adding [s, e1] to the environment")
        self.assertEqual(l1.y2, FOUR, "Let eval_prog should evaluate e2 after adding [s, e1] to the environment")

        l2 = Let("a", LineSegment(-ONE, -TWO, THREE, FOUR),
                 Let("b", LineSegment(THREE, FOUR, -ONE, -TWO), Intersect(Var("a"), Var("b"))))
        l2 = l2.preprocess_prog().eval_prog([["a", Point(0, 0)]])
        self.assertEqual(l2.x1, -ONE, "Let eval_prog should evaluate e2 after adding [s, e1] to the environment")
        self.assertEqual(l2.y1, -TWO, "Let eval_prog should evaluate e2 after adding [s, e1] to the environment")
        self.assertEqual(l2.x2, THREE, "Let eval_prog should evaluate e2 after adding [s, e1] to the environment")
        self.assertEqual(l2.y2, FOUR, "Let eval_prog should evaluate e2 after adding [s, e1] to the environment")

    def test_shift(self):
        s = Shift(THREE, FIVE, LineSegment(-ONE, -TWO, THREE, FOUR))
        s1 = s.preprocess_prog().eval_prog([])
        self.assertEqual(s1.x1, TWO, "Shift should shift e by dx and dy")
        self.assertEqual(s1.y1, THREE, "Shift should shift e by dx and dy")
        self.assertEqual(s1.x2, SIX, "Shift should shift e by dx and dy")
        self.assertEqual(s1.y2, NINE, "Shift should shift e by dx and dy")


if __name__ == '__main__':
    unittest.main()
