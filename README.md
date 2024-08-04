# Basic Auth with Spring Security

Minimal setup needed to protect a resource with username / password combo.

## About

The simplest for of access protection is basic authentication.
When a protected resource is accessed, the server verifies if the client is athenticated. If not, the request is intercepted and client is forwarded to a login page instead.
Upon correct entry of credentials, the client is then again realyed to the original protected resource.

This respository contains a spring-boot/spring-security for just that:
 * Protected resource at [http://127.0.0.1:8081/dummyresource](http://127.0.0.1:8081/dummyresource)
 * Exactly one user:
   * Username: `user`
   * Password: `password`
   

## How to start

* Use sdkman to install java 22:  
`sdk install java 22.0.2-oracle`
* Start the server:  
`mvn clean package spring-boot:run`

## How to test

Various ways, but in essence you always first access the protected resource, to trigger the login dance.

### Browser

* Access  [http://127.0.0.1:8081/dummyresource](http://127.0.0.1:8081/dummyresource)
  * You'll be forwarded to [http://127.0.0.1:8081/login](http://127.0.0.1:8081/login)
* Enter credentials, hit enter
  * You'll be forwarded to the [protected resource](http://127.0.0.1:8081/dummyresource)

### Curl

 * Just access the protected resource and add the credentials to the request parameter with the `-u` option:  
`curl -u user:password http://127.0.0.1:8081/dummyresource`

### JavaScript

Logic to be called by a "login" button, to trigger authentication dance. See: [https://stackoverflow.com/q/43842793](https://stackoverflow.com/q/43842793)

```javascript
    const url = 'http://127.0.0.1:8081/dummyresource';
    const username = 'user';
    const password = 'password';

    // Store credentials in header:
    let headers = new Headers();
    headers.set('Authorization', 'Basic ' + btoa(username + ":" + password));
    // Access test resource, using header:
    fetch(url, {
        method: 'GET', headers: headers,
    })
        .then(response => {
            if (response.status == 200) {
                acceptCredentials()
            } else {
                rejectCredentials()
            }
        })
        .catch(rejectConnection)
```

## References

 * Based on [this tutorial](https://sabljakovich.medium.com/minimalistic-basic-auth-configuration-with-spring-boot-security-8a31a5d958d2).
 * Changes by  [m5c](https://github.com/m5c)
    * An actual code repo + documentation
    * CORS support, to enable testing from JS / Browsers