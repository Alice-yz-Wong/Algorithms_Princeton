# Percolation
This program use union-find algorithm to calculate the value of the percolation threshold via Monte Carlo simulation.


Please note that this project is from Princeton University Algorithms Part I. Please see original assignment requirements from the following [link](https://coursera.cs.princeton.edu/algs4/assignments/percolation/specification.php).


## Environment

Please note that algs4.jar file will have to be added to the build path prior to running the program.

## Introduction to percolation problem

We need to model a NxN grid of sites. Each site is either open or blocked. A full site is an open site that can be connected to open site in the top row via a chain of neighboring (left, right, up, down) open sites. We say the system percolates if there is a full site in the bottom row.

This problem simulate the percolation problem by giving each sites probability p independently to be open(therefore the probability for being blocked is 1-p) and calculate the average, mean, 95% confidence hi and lo interval for the percolation threshold.

## Approach
There are two parts in the program:

- Percolation: Initiate a n by n grid. Use an unionfind class to store the relationship between the grid. And use byte to store the information of each site: 0 as blocked, 1 as open, and 2 as full. This approach has the time complexity of nlogn.

- PercolationStats: Calculate mean, standard deviation, confidenceLo and confidenceHi

## Applications
Given a composite system comprised of randomly distributed insulating and metallic material, simulate the fraction of the metallic material for the system to be an electrical conductor.


## Algorithm

The solution use the union-find algorithm. The sample code can be found under UnionFind API folder.

