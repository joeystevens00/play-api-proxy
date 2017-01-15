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

GET using url param

` curl https://play-api-proxy.herokuapp.com?api-forward-url=http://ipecho.net/plain `

POST with json using header

` curl -X POST -H "Content-Type: application/json" -H "api-forward-url: http://jsonplaceholder.typicode.com/posts" -d '{"title": "foo", "body": "bar", "userId": 1}' https://play-api-proxy.herokuapp.com/ `

POST with json using url param

` curl -X POST -H "Content-Type: application/json" -d '{"title": "foo", "body": "bar", "userId": 1}' https://play-api-proxy.herokuapp.com?api-forward-url=http://jsonplaceholder.typicode.com/posts `

Custom Headers are forwarded too
`  curl -H "MyCustomHeader: Test1" -H "MyCustomerHeader2: Test2" -H "MyCustomHeader3: Test3" -H "api-forward-url: https://wtfismyip.com/headers" https://play-api-proxy.herokuapp.com/ `

## Support
Current support is GET and limited POST  (json)


