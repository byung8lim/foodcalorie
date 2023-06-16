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

# access log format
"%{X-Forwarded-For}i %h %l %u %t \"%m %U %H\" %s %b %D"
192.168.29.188, 10.10.50.101 10.244.168.207 - - [[16/Jun/2023:15:02:05 +0900]] "GET /foodcalorie/calorie/%EC%86%8C%EC%A3%BC/name HTTP/1.1" 200 409 21

%a : Remote IP
%A : Local IP
%b : byte size sent, except Header
%B : byte size sent, except Header
%h : Remote hostname
%H : Request protocol
%l : Remote user name of identd
%m : Request method(GET, POST)
%p : Local port
%q : Query string
%r : First line of request(Method & URI)
%s : HTTP status
%S : User session ID
%t : Day and Time
%u : Remote User authenticated
%U : Request URL Path
%v : Local hostname
%D : Ellapsed Time(ms)
%T : Ellapsed Time(s)
%I : Current thread name
