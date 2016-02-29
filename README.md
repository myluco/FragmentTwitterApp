# Extended Twitter Client using Fragments

# Pre-work - Extended Twitter Client using Fragments

 Extend our Twitter client from previous project to use a tabbed interface and fragments.

Submitted by: Luiza Carneiro

## User Stories

The following user stories must be completed:

### (User Stories from Week 3)
* [x]  User can sign in to Twitter using OAuth login (2 points)
* [x]  User can view the tweets from their home timeline
* [x]  User should be displayed the username, name, and body for each tweet (2 points)
* [x] User should be displayed the relative timestamp for each tweet "8m", "7h" (1 point)
* [x] User can view more tweets as they scroll with infinite pagination (1 point)
* User can compose a new tweet
* [x] User can click a “Compose” icon in the Action Bar on the top right (1 point)
* [x] User can then enter a new tweet and post this to twitter (2 points)
* [x] User is taken back to home timeline with new tweet visible in timeline (1 point)

### (New User Stories)
User can switch between Timeline and Mention views using tabs. (4 points)
* [x] User can view their home timeline tweets.
* [x] User can view the recent mentions of their username.

User can navigate to view their own profile (3 points)
* [x] User can see picture, tagline, # of followers, # of following, and tweets on their profile.

User can click on the profile image in any tweet to see another user's profile. (4 points total)
* [] User can see picture, tagline, # of followers, # of following, and tweets of clicked user. (1 point)
* [] Profile view should include that user's timeline (1 point)
* [] Optional: User can view following / followers list through the profile (2 points)

* [x] User can infinitely paginate any of these timelines (home, mentions, user) by scrolling to the bottom (1 point)


## The following advanced user stories are optional but recommended:

* [] Advanced: Robust error handling, check if internet is available, handle error cases, network failures (1 point)
* [] Advanced: When a network request is sent, user sees an indeterminate progress indicator (1 point)

Advanced: User can "reply" to any tweet on their home timeline (1 point)
* [] The user that wrote the original tweet is automatically "@" replied in compose (1 point)

Advanced: User can click on a tweet to be taken to a "detail view" of that tweet (1 point)
* [] Advanced: User can take favorite (and unfavorite) or retweet actions on a tweet (1 point)

* [] Advanced: Improve the user interface and theme the app to feel "twitter branded" (1 to 5 points)
* [] Advanced: User can search for tweets matching a particular query and see results (2 points)
* [] Bonus: Use Parcelable instead of Serializable using the popular Parceler library. (1 point)
* [] Bonus: Apply the popular Butterknife annotation library to reduce view boilerplate. (1 point)
* [] Bonus: User can view their Twitter direct messages (and/or send new ones) (2 points)

## Additional User Stories

* []  

## Video Walkthrough 

Here's a walkthrough of implemented user stories:

<a href="http://i.imgur.com/DrlYEOC.gifv" target="_blank">Video Walkthrough</a>

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes
* I did the pagination using my previous code and while following the video. That is, I followed the idea that the video was doing but changed my own code.
.

## License

    Copyright [2016] [Luiza Carneiro]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
