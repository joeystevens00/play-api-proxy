## api-proxy
api-proxy is a RESTful api that acts as a proxy 


## Examples
` curl -H "api-forward-url: https://google.com" localhost:9000/proxifyApi `

` curl -X POST -H "Content-Type: application/json" -H "api-forward-url: http://jsonplaceholder.typicode.com/posts" -d '{"title": "foo", "body": "bar", "userId": 1}' localhost:9000/proxifyApi `
