echo "(Re)building application"
call mvn package
echo "Starting demo application"
echo "Setting up in-memory H2 database"
start mvn exec:java@console > mvn_h2_log.txt
start mvn exec:java@initdb > mvn_h2_init.txt
echo "Running rgp-poc"
call java -jar target/rgp-poc-1.0-SNAPSHOT.jar

echo "Bye"
