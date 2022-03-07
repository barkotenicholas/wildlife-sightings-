# Wildlife Tracker
- This application allows rangers to track sightings of wild animal in the park
----
**Version1.0.0**

---
![APM](https://img.shields.io/apm/l/vim-mode)
---


## Authors
- Nicholas Barkote <nicholas.kebut@student.moringaschool.com>
---

## Requirements
- ubuntu or any os with jdk
- IntelliJ


## Setup Instructions

* clone it to your desktop
```bash
 git clone  https://github.com/barkotenicholas/wildlife-sightings-.git
   ```
* Open the project with intellij
##  database setup
* run this commands in psql
```bash
    CREATE DATABASE wildlife_tracker;
    \c wildlife_tracker;
     CREATE TABLE animals (id serial PRIMARY KEY, name varchar, health varchar, age varchar, type varchar);
     CREATE TABLE ranger (name VARCHAR,badgeno int);
     CREATE TABLE sighting (animal_id int,zone VARCHAR,timestamp Date,ranger_id int);
   ```
# Tech Stack

- java
- gradle
- html
- bootstrap


## Contact Information

<a href="mailto:barkotenicholas@gmail.com">barkotenicholas@gmail.com</a>



## License & copyright

© Nicholas k Barkote , Moringa school student

Licensed under the [MIT License](LICENSE)