# TDDBookmarking

## UserStory
````
As a user I want to bookmark a URL (URLs must be valid)
````
### Tests:
- [x] ensure that a Bookmark/Collection can be created
- [x] ensure that a Bookmark can be added to the BookmarkCollection
- [x] ensure that a given string can be parsed to a valid URL
- [x] ensure that a given string is an invalid URL and throws a MalformedURLException 
// https://docs.oracle.com/javase/7/docs/api/java/net/URL.html#URL(java.lang.String)

## UserStory
````
As a user I want to be able to Tag a URL with a keyword
````
### Tests:
- [x] ensure that a bookmark can be tagged

## UserStory
````
As a user when I add a duplicate bookmark, I want the system to increase the rating of that bookmark, because no exact duplicates should exist
````
### Tests:
- [x] ensure that a browser can have multiple bookmarks
- [x] ensure that a browser doesnt allow duplicate bookmarks
- [x] ensure that a rating starts with zero
- [x] ensure that a duplicated bookmark inside a browser raises its rating instead of inserting it again

## UserStory
````
As a user I want to be able to filter bookmarks by one keyword
````
### Tests:
- [x] ensure that a browser can find bookmarks based on its tag
- [x] ensure that a browser can find bookmarks based on its URLs

## User Story
````
As a user I want to add a current date/time when I add a bookmark
````
### Tests:
- [x] ensure that the time in Bookmark is not null
- [ ] ensure that the time in Bookmark is from today when its getting added