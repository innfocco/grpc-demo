echo "starting build..."

mvn clean package

docker build . -t innfocco/grpc-client:latest

docker login -uinnfocco

docker push innfocco/grpc-client:latest
