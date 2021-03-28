---
layout: page
title: Detecting seasons with React.js
usemathjax: true
categories: [software development, React.js]
---

Here's a proud moment - the first front-end I've built with React.js and JSX! It's very simple, but it taught me a lot on how React worked internally.

This app displays either two screens dependent on whether it’s summer or winter wherever the user is currently.

A user in New Zealand (i.e. me) is in the southern hemisphere where it’s currenty winter (May 2nd, when this blogpost was written). The app displays the winter screen in this case.

![Winter Screen](/assets/images/2020-04-05-react-first-project/winterscreen.png)

A user in San Francisco, on the other hand, is in the northern hemisphere where it’s currently summer. The app displays the summer screen for them.

![Summer Screen](/assets/images/2020-04-05-react-first-project/summerscreen.png)

How do we know where the user is? Well, we can detect user location with the [Mozilla Geolocation API](https://developer.mozilla.org/en-US/docs/Web/API/Geolocation_API). We can grab latitude and longitude information about the user from this service.

We can also force the Google Chrome browser to consider a location like San Francisco away from us by changing its geolocation in its ‘Sensors’ tab like so (mostly for testing the different views):

![Force location change](/assets/images/2020-04-05-react-first-project/forcelocationchange.png)

If the user has disabled location-sharing in any-way, the screen below encourages them to enable it

![Accept location screen](/assets/images/2020-04-05-react-first-project/acceptlocationscreen.png)

Semantic UI and some CSS was used to style the webpage.
	
This project taught me React's fundamentals - class based and functional components, the component life cycle methods, how to update component state, and how to pass information down from parent to children components using the props system.

I'm currently building and deploying a more complex full-stack web app, integrating node.js/express.js for the back-end and a mongodb database. I might write a tutorial on that when it's done, so if you're interested, please stay tuned for that post! :)



