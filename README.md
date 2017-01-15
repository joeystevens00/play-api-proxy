## api-proxy
api-proxy is a RESTful api that acts as a proxy.
 
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

Custom headers are forwarded too

` curl -H "MyCustomHeader: Test1" -H "MyCustomerHeader2: Test2" -H "MyCustomHeader3: Test3" -H "api-forward-url: https://play-api-proxy.herokuapp.com/getHeaders" https://play-api-proxy.herokuapp.com/ `

## Support
Current support is GET and POST

Not supported: File transfer

## Endpoints
POST            /                     controllers.Application.proxifyApi

GET             /                     controllers.Application.proxifyApi

GET             /getHeaders             controllers.Application.getHeaders

proxifyApi - Forwards requests to api-forward-url and returns response

getHeaders - Returns request headers as json
