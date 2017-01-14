## api-proxy
api-proxy is a RESTful api that acts as a proxy 

## Install
```git clone https://github.com/joeystevens00/play-api-proxy
cd play-api-proxy
bin/activator run
```


## Example Usage
` curl -H "api-forward-url: https://google.com" localhost:9000/proxifyApi `

` curl -X POST -H "Content-Type: application/json" -H "api-forward-url: http://jsonplaceholder.typicode.com/posts" -d '{"title": "foo", "body": "bar", "userId": 1}' localhost:9000/proxifyApi `

## Support
Current support is GET and limited POST (json)


