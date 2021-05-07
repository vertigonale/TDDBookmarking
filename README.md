# TDDBookmarking

## UserStory
- [x] As a user I want to bookmark a URL (URLs must be valid)
### Test#1:
- [x] ensure that a Bookmark/Collection can be created
- [x] ensure that a Bookmark can be added to the BookmarkCollection
- [x] ensure that a given string can be parsed to a valid URL
- [x] ensure that a given string is an invalid URL and throws a MalformedURLException 
// https://docs.oracle.com/javase/7/docs/api/java/net/URL.html#URL(java.lang.String)

## UserStory
- [x] As a user I want to be able to Tag a URL with a keyword
### Test#1:
- [x] ensure that a bookmark can be tagged

## UserStory
- [ ] As a user when I add a duplicate bookmark, I want the system to increase the rating of that bookmark, because no exact duplicates should exist
### Test#1:
- [x] ensure that a browser can have multiple bookmarks
- [ ] ensure that a browser doesnt allow duplicate bookmarks
- [ ] ensure that a rating starts with zero
- [ ] ensure that a duplicated bookmark inside a browser raises its rating instead of inserting it again