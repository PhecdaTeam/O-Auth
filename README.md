<h1 align="center">O-Auth 🔒</h1>
<p align="center">
  <img alt="Version" src="https://img.shields.io/badge/version-1.1.2-blue.svg?cacheSeconds=2592000" />
  <img src="https://img.shields.io/badge/Java-%3E%3D8.0-blue.svg" />
  <img src="https://img.shields.io/badge/Spigot/Paper-%5E1.8.8%20%7C%7C%20%3E%3D1.8.0-blue.svg" />
  <a href="#" target="_blank">
    <img alt="License: MIT" src="https://img.shields.io/badge/License-BSD-yellow.svg" />
  </a>
</p>


## 🏠 [Homepage](https://github.com/PhecdaTeam/O-Auth)
Latest release: [Click This](https://github.com/PhecdaTeam/O-Auth/releases/tag/1.1.2)

### Blocked activities before logging in:
- Destroying blocks
- Sending commands
- Dealing damage to other players
- Dropping items
- Open your inventory
- Moving

### Encryption methods available
- MD5

### Commands:
- /login | /l
- /register | /reg
- /changepassword | /changepass

## Prerequisites

- Java >=8.0
- Spigot/Paper ^1.8.8 || >=1.8.0

## Install

1. Go to [releases page](https://github.com/PhecdaTeam/O-Auth/releases)
2. Download version of plugin that is compatible with your server version. (Assets section)
3. Move O-Auth.jar to your `/plugins` server directory.
4. Restart server
5. And voilà!

## Config
```yml
mysql:
    host: localhost
    user: root
    port: 3306
    base: oauth
    pass: ""

# Prefix
prefix: "&c&lYour&4&lIP&f&l.EU"

# Welcome messages
welcome_format: " &c&lA&4&lO &8[&2+&8] &a{PLAYER}"
quit_format: " &c&lA&4&lO &8[&4-&8] &c{PLAYER}"
welcome_message: " &f&lWelcome to my server!"

# Auth messages
login: " &c&lA&4&lO &7» &fLog in /login <password> <captcha>!"
register: " &c&lA&4&lO &7» &fRegister /register <password> <password> <captcha>"
changepass: " &c&lA&4&lO &7» &fChange your password : /changepass <old_password> <new_password>"
registered: " &c&lA&4&lO &7» &fYou have registered correctly!"
logged: " &c&lA&4&lO &7» &fYou have logged in correctly!"
passchange: " &c&lA&4&lO &7» &fYou have changed your password correctly!"
already_registered: " &c&lA&4&lO &7» &fYou are already registered!"
already_logged: " &c&lA&4&lO &7» &fYou are already logged!"
not_same_password: " &c&lA&4&lO &7» &fThe passwords given are not the same!"
invalid_password: " &c&lA&4&lO &7» &fInvalid password!"
not_logged: " &c&lA&4&lO &7» &fYou must be logged in to do this!"
changed_pass: " &c&lA&4&lO &7» &fPassword changed correctly!"

# Spawn Location
Location:
    X: 0
    Y: 0
    Z: 0

# Security setting
security:
    captcha: true
    captcha_message: " &c&lA&4&LO &7>> &9&lYour captcha : &1&l{CAPTCHA}"
    invalid_captcha: " &c&lA&4&lO &7>> &fInvalid captcha!"

```

## Author

👤 **Out69**

* Website: https://oucik.xyz/
* Github: [@Out69](https://github.com/Out69)

## 🤝 Contributing

Contributions, issues and feature requests are welcome!<br />Feel free to check [issues page](https://github.com/PhecdaTeam/O-Auth/issues). You can also take a look at the [contributing guide](@github.com:Out69/O-Auth/blob/master/CONTRIBUTING.md).

## Show your support

Give a ⭐️ if this project helped you!

***

*You need help? Feel free to dm me on discord Out#9999*
