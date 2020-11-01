echo "(Re)building application"
mvn clean package
echo "Starting demo application"
echo "Setting up in-memory H2 database"
mvn exec:java@console > mvn_h2_log.txt &
mvn exec:java@initdb > mvn_h2_init.txt &
echo "Running rgp-poc"
java -jar target/rgp-poc*.jar

kill -9 `jobs -l | grep mvn | sed -r "s/\s\s+/ /g" | cut -d' ' -f 2` 2> /dev/null

echo "Bye"
