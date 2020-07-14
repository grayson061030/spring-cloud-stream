# spring cloud stream tutorial

## Run

* docker-compose up -d
* run consumer
* run publisher
* call rest api
```$xslt
curl -X POST \
  http://localhost:8080/direct \
  -H 'content-type: application/json' \
  -d '{
	"code":"test",
	"type":"type",
	"price": 300.0
}'
```
## Reference

- [spring cloud stream with rabbitmq](https://medium.com/@odysseymoon/spring-cloud-stream-with-rabbitmq-c273ed9a79b)