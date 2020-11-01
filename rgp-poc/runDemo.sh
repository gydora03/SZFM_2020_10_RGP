echo "Starting demo application"
echo "Setting up in-memory H2 database"
mvn exec:java@console > mvn_h2_log.txt &
echo "Running rgp-poc"
java -jar target/rgp-poc*.jar

kill -9 `jobs -l | grep mvn | sed -r "s/\s\s+/ /g" | cut -d' ' -f 2`

echo "Bye"
