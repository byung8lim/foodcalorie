# foodcalorie server
docker build -t kong-gw.bd.com:5000/fitness/foodcalorie:latest .

docker push kong-gw.bd.com:5000/fitness/foodcalorie:latest

docker run -d -p 8082:8080 --restart=always --name fitness-foodcalorie \
-e DB_URI=10.10.50.2:3306 \
-e DB_USER_NAME=byung8 \
-e DB_USER_PASSWORD=1q2w3e4r5t \
-v /etc/localtime:/etc/localtime \
-v /data/fitness/foodcalorie/logs:/data/fitness/foodcalorie/logs \
kong-gw.bd.com:5000/fitness/foodcalorie:latest
