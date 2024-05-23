-- Task:
-- Write a Haskell function `quickSort` that sorts 
-- a list of integers using the quicksort algorithm.

-- TODO: implement you solution here    


-- Test the function
main :: IO ()
main = do
    let unsortedList = [38, 27, 43, 3, 9, 82, 10]
    let sortedList = quickSort unsortedList
    print sortedList  -- Expected output: [3, 9, 10, 27, 38, 43, 82]
