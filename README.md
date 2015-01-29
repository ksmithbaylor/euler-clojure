# Project Euler in Clojure

This is my set of solutions to Project Euler, in Clojure. I included an answer
key that I found somewhere on the internet, for checking purposes only. Since
the object of Project Euler is not to "win" but to learn, I don't see a problem
with this.

# Instructions

Clone the repository, make sure leiningen is installed, and run `lein deps`.

### To run and check all solutions:

    $ ./run all
    001 - "Elapsed time: 0.51 msecs"        PASS - 233168
    002 - "Elapsed time: 0.314 msecs"       PASS - 4613732
    003 - "Elapsed time: 0.505 msecs"       PASS - 6857
    004 - "Elapsed time: 228.564 msecs"     PASS - 906609
    005 - "Elapsed time: 0.186 msecs"       PASS - 232792560
    006 - "Elapsed time: 0.113 msecs"       PASS - 25164150
    007 - "Elapsed time: 343.403 msecs"     PASS - 104743
    008 - "Elapsed time: 7.804 msecs"       PASS - 23514624000
    009 - "Elapsed time: 11.4 msecs"        PASS - 31875000
    010 - "Elapsed time: 384.299 msecs"     PASS - 142913828922
    011 - "Elapsed time: 4.877 msecs"       PASS - 70600674
    012 - "Elapsed time: 618.832 msecs"     PASS - 76576500
    013 - "Elapsed time: 1.749 msecs"       PASS - 5537376230
    014 - "Elapsed time: 329.337 msecs"     PASS - 837799
    015 - "Elapsed time: 0.255 msecs"       PASS - 137846528820
    016 - "Elapsed time: 2.634 msecs"       PASS - 1366
    017 - "Elapsed time: 4.128 msecs"       PASS - 21124
    018 - "Elapsed time: 1.195 msecs"       PASS - 1074
    019 - "Elapsed time: 30.257 msecs"      PASS - 171
    020 - "Elapsed time: 1.605 msecs"       PASS - 648
    021 - "Elapsed time: 170.629 msecs"     PASS - 31626
    022 - "Elapsed time: 7.798 msecs"       PASS - 871198282
    023 - "Elapsed time: 681.613 msecs"     PASS - 4179871


### To run and check the solution for Problem 5:

    $ ./run 5
    005 - "Elapsed time: 0.186 msecs"       PASS - 232792560


### To generate a Clojure file for a new problem:

    $ ./gen 42
