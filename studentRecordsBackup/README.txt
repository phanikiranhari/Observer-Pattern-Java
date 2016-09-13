[
  adopted from http://www.cs.rochester.edu/u/www/courses/171/Fall-03/files/readme.txt
  by Deger Cenk Erdil
  for CS654 Distributed Systems
  This is a template README file about how you should form your own README file.
  In general,
        you should remove anything in between square brackets (i.e. [..]), and
        you should replace anything in between <> with a value.
]

CS542 Design Patterns
Spring 2016
PROJECT <3> README FILE

Due Date: <PROJECT DUE DATE, IN FORMAT: Tuesday, March 22, 2016>
Submission Date: <DATE YOU SUBMIT, IN FORMAT: Tuesday, March 22, 2016>
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): PHANIKIRAN HARI
e-mail(s): phari2@binghamton.edu


PURPOSE:

[
  To learn Observer pattern in Java
]

PERCENT COMPLETE:

[
 100
]

PARTS THAT ARE NOT COMPLETE:

[
 NONE
]

BUGS:

[
 None
]

FILES:

[
  Input file has to be given as one of the command line arguments for the program to compile
]

SAMPLE OUTPUT:

[
Buildfile: /import/linux/home/phari2/CS542/Demo/phanikiran_hari_assign3/studentRecordsBackup/src/build.xml

jar:
    [mkdir] Created dir: /import/linux/home/phari2/CS542/Demo/phanikiran_hari_assign3/studentRecordsBackup/BUILD/jar
      [jar] Building jar: /import/linux/home/phari2/CS542/Demo/phanikiran_hari_assign3/studentRecordsBackup/BUILD/jar/studentRecordsBackup.jar

run:
     [java] ***************Inorder of all the trees before the update******************
     [java]
     [java] Inorder of Subject Tree
     [java] 9 16 17 20 23 25 28 30 35 42 54 65 74 95 98
     [java] Inorder of Observer1 Tree
     [java] 9 16 17 20 23 25 28 30 35 42 54 65 74 95 98
     [java] Inorder of Observer2 Tree
     [java] 9 16 17 20 23 25 28 30 35 42 54 65 74 95 98
     [java] Sum of BNumbers in Subject Tree
     [java] 631
     [java] Sum of BNumbers in Observer1 Tree
     [java] 631
     [java] Sum of BNumbers in Observer2 Tree
     [java] 631
     [java]
     [java] ***************Inorder of all the trees after the update*******************
     [java]
     [java] Inorder of Subject Tree
     [java] 11 18 19 22 25 27 30 32 37 44 56 67 76 97 102
     [java] Inorder of Observer1 Tree
     [java] 11 18 19 22 25 27 30 32 37 44 56 67 76 97 100
     [java] Inorder of Observer2 Tree
     [java] 9 16 17 20 23 25 28 30 35 42 54 65 74 95 98
     [java] Sum of BNumbers in Subject Tree
     [java] 663
     [java] Sum of BNumbers in Observer1 Tree
     [java] 661
     [java] Sum of BNumbers in Observer2 Tree
     [java] 631
     [java]

BUILD SUCCESSFUL
Total time: 1 second


]

TO COMPILE:

[
  Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

## To compile: 
ant -buildfile src/build.xml all

## To run by specifying arguments from command line [similarly for the 2nd argument and so on ...]
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=firstarg -Darg1=secondarg 

## To create tarball for submission
ant -buildfile src/build.xml tarzip

## To untar the tarball submitted
ant -buildfile src/build.xml untarzip

]

TO RUN:

[
## To run by specifying args in build.xml (just for debugging, not for submission)
ant -buildfile src/build.xml run
]

EXTRA CREDIT:

[
  N/A
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
<PHANIKIRAN HARI>

[
  
]

ACKNOWLEDGEMENT:

[
 
]

CHOICE OF DATA STRUCTURE[

ArrayList is the data structure I have used to store the Observers.
Space and Time complexity of ArrayList is O(1) and constant.


]