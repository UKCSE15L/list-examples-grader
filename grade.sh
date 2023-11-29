CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'


file=`(find ./student-submission -name "*.java")`

if ! [[( -e $file )]]
then   
echo "File does not exist"
exit
fi

echo $file
cp -r $file grading-area
cp TestListExamples.java grading-area
cp -r lib grading-area
cd grading-area

echo 'Finished copying'

javac -cp $CPATH *.java

if [[( $? -ne 0 )]]
then   
echo "Compile Error - please see error message and fix."
exit
fi

java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > tests.txt

echo "Tests ran"

allPassed=`(grep "OK" tests.txt | wc -l)`

grep ") t" tests.txt > failedtests.txt

failurecount=$(wc -l < failedtests.txt)
failurecount=$((9-failurecount))

if [[ $allPassed -ne 0 ]]
then
echo "9/9 Tests Passed! Congratulations!"
else
echo "Failed Tests:"
cat failedtests.txt
echo "You passed $failurecount/9 tests"
fi