# KBP
This is the custom plugin which will be used in
the KelsonCraft server.
# Commands:
Most of these commands work from the console besides /enderchest.

Some of the features in the /playerinfo command are going to be used
in the future once I can figure out how to store all that data into yml or a database.

Anything in the [] is needed for the command, anything within <> is optional values.


* /enderchest - shows the players enderchest.
* /fly [on/off] <`playername`> - Enables flying for the player or others.
* /god [on/off] <`playername`> - Makes the player invincible.
* /kheal <`playername`> - Heals the player or others.
* /kmotd - Shows the server motd from the config.yml.
* /lightning <`playername`> - Strikes lightning at the block you are looking 
at or at the specified player.
* /lightningstick <`playername`> - Gives you or the specified player a lightning stick
* /location <`playername`> - Shows the players world, and coordinates.
* /nightvision <`playername`> - Gives you or the specified player night vision.
* /playerinfo <`playername`> - Shows these stats for you or others, gamemode
location, is op, is banned, is online, ip address, name, and health.
* /setkmotd [message] - This command sets the kmotd, use %s for player name, %w for world, and regular color codes

# Custom features:
This plugin has a localchat feature that works like this: "@ message"

So if you write "@ hello world" without the quotes it'll only
send that message to players within 50 blocks of you, I should
probably set this as a config option instead of hard-coding the value.

##### Localchat formatting with minecraft color codes (gold, light blue, green):

&6 [LocalChat] &b playername: &a