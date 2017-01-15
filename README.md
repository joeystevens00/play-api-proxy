## api-proxy
api-proxy is a RESTful api that acts as a proxy 
https://play-api-proxy.herokuapp.com/

## Install

```
git clone https://github.com/joeystevens00/play-api-proxy
cd play-api-proxy
bin/activator run
```


## Example Usage

GET using header
` curl -H "api-forward-url: http://ipecho.net/plain" https://play-api-proxy.herokuapp.com/ `

GET using URL Param
` curl https://play-api-proxy.herokuapp.com?api-forward-url=http://ipecho.net/plain `

POST with Json using header
` curl -X POST -H "Content-Type: application/json" -H "api-forward-url: http://jsonplaceholder.typicode.com/posts" -d '{"title": "foo", "body": "bar", "userId": 1}' https://play-api-proxy.herokuapp.com/ `

POST with Json using URL Param
` curl -X POST -H "Content-Type: application/json" -d '{"title": "foo", "body": "bar", "userId": }' https://play-api-proxy.herokuapp.com?api-forward-url=http://jsonplaceholder.typicode.com/posts `

## Support
Current support is GET and limited POST  (json)


