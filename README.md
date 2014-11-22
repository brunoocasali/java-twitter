Twitter On Java
============

This app will be used to write an article to university.


- Run in Terminal: **Database codes.**

1° `~$ sudo -u postgres psql` then type your password!

2° `postgres=# CREATE DATABASE twitter_on_java;` so you will created the database.

3° `postgres=# \c twitter_on_java;` enter on the database!

4° Create the table for tweets:

```
CREATE TABLE tweets(
	tweet_id BIGINT DEFAULT 0 NOT NULL PRIMARY KEY,
	screen_name VARCHAR(20) DEFAULT 'Person Name!' NOT NULL,
	user_id BIGINT DEFAULT 0 NOT NULL,
	created_at TIMESTAMP DEFAULT NOW(),
	text_tweet VARCHAR(140) DEFAULT 'Tweeet Teeextt!' NOT NULL,
	user_image VARCHAR(200) DEFAULT 'http://c.dryicons.com/images/icon_sets/symbolize_icons_set/png/64x64/user.png'
);
```

5° `postgres=# \q` You could exit!
