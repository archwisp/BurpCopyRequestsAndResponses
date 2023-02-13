# BurpCopyRequestsAndResponses
This is a documentation helper that copies request and response content from Burp history items into your copy-paste buffer, in markdown format.

## Installation
### Compilation 
#### Windows & Unix
1. Install gradle (<https://gradle.org/>)
2. Download the repository.
```shell
$ git clone https://github.com/archwisp/BurpCopyRequestsAndResponses
$ cd BurpCopyRequestsAndResponses
```
3. Create the standalone jar:
```shell
$ gradle fatJar
```

### Burp Suite import
In Burp Suite, under the `Extender/Options` tab, click on the `Add` button and load the `BurpCopyRequestsAndResponses-all.jar` file located in the `build/libs` folder.

## Credits
I used the `copy as curl command` plugin as a starting point for developing this one.
- [PortSwigger's copy as curl command function](http://releases.portswigger.net/2013/09/v1517.html).
- https://github.com/AresS31/copy-as-powershell-requests

## License
Copyright 2020 Bryan C. Geraghty
Licensed for use under the MIT license
