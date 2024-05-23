-- Task:
-- Implement functions `mean` and `std` to compute the mean and standard deviation 
-- of a list of floating-point numbers.

-- TODO: implement you solution here


-- Test the functions
main :: IO ()
main = do
    let numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    let avg = mean numbers
    let stddev = standardDeviation numbers
    putStrLn ("Mean: " ++ show avg)                -- Expected output: Mean: 5.5
    putStrLn ("Standard Deviation: " ++ show stddev)  -- Expected output: Standard Deviation: 2.8722813232690143
