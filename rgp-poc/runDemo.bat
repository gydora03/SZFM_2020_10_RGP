echo "Starting demo application"
echo "Setting up in-memory H2 database"
start "mvn exec:java@console > mvn_h2_log.txt"
echo "Running rgp-poc"
java -jar target/rgp-poc*.jar

echo "Bye"
