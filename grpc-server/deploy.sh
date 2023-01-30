echo "starting build..."

mvn clean package

docker build . -t innfocco/grpc-server:latest

docker login -uinnfocco

docker push innfocco/grpc-server:latest
