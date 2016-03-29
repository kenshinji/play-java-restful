API REST for JAVA Play Framework
================================

-----

This is an application which has one endpoint calling Yahoo's weather API


| Method | URI | Data | HTTP Code | Response (in JSON) |
| ------ | --- | ---- | --------- | ------------------ |
| GET | /weather/:city |  | 200 | {"query": {"count": 1,"created": "2016-03-28T14:34:14Z","lang": "en","results": {"channel": {"item": {"condition": {"code": "32","date": "Mon, 28 Mar 2016 08:00 AM CDT","temp": "42","text": "Sunny"}}}}}} |


CHANGELOG
=========

- Added SecuredAction for authentication. (Now given the token generated for user is "123456"), which means you will receive an unauthorized message without "X-AUTH-TOKEN" in HTTP header, and can't access the API endpoint.




