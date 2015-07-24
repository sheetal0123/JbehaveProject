Narrative:
In order to find Jim Morris role in Star War I
As a automation engineer
I want to check IMDb site
					 
Scenario:  Special thanks crew in movie Star War I 

Given user is on url <url>
When user searched for <searchString> on page
And user click on <link1> on the search page
And user select see full cast link on the product page
Then user sees <message1> and <message2> on the page

Examples:
|url				|searchString			|link1										|message1	|message2		|
|http://www.imdb.com|Star Wars: Episode I	|Star Wars: Episode I - The Phantom Menace	|Jim Morris |special thanks	|