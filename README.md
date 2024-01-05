# Data Validator
____

This library is developed to validate different objects against establishe restrictions using isValid() method having the argument of integer, String or Map types. 

Validator creates schemas using the methods listed below which contain restrictions for every of the listed above object types

  * **string()** - create schema for String validation and add restrictions by the methods below:
    - *required()* - restrict null and empty strings;
    - *minLength()* - restrict strings with the length less than established by argument;
    - *contains()* - require the string to contain the string pointed in agrument.

**Example:**

            Validator v = new Validator();

            StringSchema schema = v.string();

            // Пока не вызван метод required(), null и пустая строка считаются валидным
            schema.isValid(""); // true
            schema.isValid(null); // true
            
            schema.required();
            
            schema.isValid(null); // false
            schema.isValid(""); // false
            schema.isValid(5); // false
            schema.isValid(<p>"what does the fox say"</p>); // true
            schema.isValid("hexlet"); // true
            
            schema.contains("wh").isValid("what does the fox say"); // true
            schema.contains("what").isValid("what does the fox say"); // true
            schema.contains("whatthe").isValid("what does the fox say"); // false
            
            schema.isValid("what does the fox say"); // false
            // Здесь уже false, так как добавлена еще одна проверка contains("whatthe")

  * **number()** - create schema for int validation and add restrictions by the methods below:
    - *required()* - restrict null value;
    - *positive()* - restrict numbers less or equal zero;
    - *range()* - require the number to be in the range defined by two agruments.

**Example:** 

            Validator v = new Validator();
            
            NumberSchema schema = v.number();
            
            // Пока не вызван метод required(), null считается валидным
            schema.isValid(null); // true
            schema.positive().isValid(null); // true
            
            schema.required();
            
            schema.isValid(null); // false
            schema.isValid("5"); // false
            schema.isValid(10); // true
            
            // Потому что ранее мы вызвали метод positive()
            schema.isValid(-10); // false
            //  Ноль — не положительное число
            schema.isValid(0); // false
            
            schema.range(5, 10);
            
            schema.isValid(5); // true
            schema.isValid(10); // true
            schema.isValid(4); // false
            schema.isValid(11); // false

  * **map()** - create schema for Map validation and add restrictions by the methods below:
    - *required()* - restrict null map;
    - *sizeof()* - restrict map of the size established by the argument;
    - *shape()* - except the Map containing restrictions as the values of the elements.

**Example:**

            Validator v = new Validator();
            
            MapSchema schema = v.map();
            
            schema.isValid(null); // true
            
            schema.required();
            
            schema.isValid(null) // false
            schema.isValid(new HashMap()); // true
            Map<String, String> data = new HashMap<>();
            data.put("key1", "value1");
            schema.isValid(data); // true
            
            schema.sizeof(2);
            
            schema.isValid(data);  // false
            data.put("key2", "value2");
            schema.isValid(data); // true 

----
### Hexlet tests and linter status:
[![Actions Status](https://github.com/nuuska-muikkunen/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/nuuska-muikkunen/java-project-78/actions)
### My Action badge
[![Actions Status](https://github.com/nuuska-muikkunen/java-project-78/actions/workflows/my-java-CI.yml/badge.svg)](https://github.com/nuuska-muikkunen/java-project-78/actions)
### Code Climate Badges
[![Maintainability](https://api.codeclimate.com/v1/badges/5e086b81013b248fc035/maintainability)](https://codeclimate.com/github/nuuska-muikkunen/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/5e086b81013b248fc035/test_coverage)](https://codeclimate.com/github/nuuska-muikkunen/java-project-78/test_coverage)
### asciinema
[![asciicast](https://asciinema.org/a/614478.svg)](https://asciinema.org/a/614478)
