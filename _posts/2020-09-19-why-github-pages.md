---
layout: post
title: Why I chose GitHub Pages for blog hosting
categories: [Hosting, GitHub, GitHub Pages]
---

## Introduction

Every technical decision is always based on the context in which the decision was made in.
In my case I was initially looking to explore React hooks and was looking for a small project to build.
After a while I thought that building a blog with React hooks would both teach me about hooks and
on the other hand give me something to write about.

This blog however is not built with React hooks. I'll try to walk you through how I ended up using GitHub Pages and Jekyll.
Following chapters are divided into different problems I was looking to solve.

### Hosting

Before I started to code I was wondering what the infrastructure would look like.
Obviously renting a server seemed a bit old-fashioned so I was looking into serverless hosting solutions.

AWS S3 could host my static files like HTML, JS, CSS, images, videos etc etc.
One of my other projects is already hosted there so I could get it setup quickly and it would not cost me much.
Still the URLs from AWS S3 buckets are pretty ugly so I should buy my own domain and route the traffic through it.

If I would save blog posts to a database or enable commenting it would require a database and some way of accessing it.
DynamoDB is rather affordable serverless database solution and a simple API should get built quickly with AWS Lambdas.
In case I'm going to need more complex API I should also use API Gateway to manage the Lambdas.

Now this all is starting to sound like a tons of work before I even get started with the front end implementation.
*Why* do I need all this infrastructure to simply get some data to the end users?

### Front-end implementation

What are the user requirements for a blog?

- End user
  - Can see blog posts
  - Can search blog posts
  - Can browse by tags
  - Can comment or can communicate some other way
- Blogger
  - Can create / update / delete posts
  - Can add tags to posts
  - Can moderate comments

All of these requirements also include lots of UX requirements.
Most end users are using mobile devices so the page should be responsive and the loaded assets should be as small as possible.
Blogger wants a secure and easy way to create / update / delete posts.

The more I thought about the ways to implement a universal blogging solution with secure access for the blogger,
the more I felt like creating a *Single Page Application* (**SPA**) with React was the wrong way to get started.
After all, blog is a collection of static content with maybe a bit of JavaScript for comments.
Serving a huge JavaScript bundle of assets started to feel like an overkill if I only wanted to display some static sites.

Should I spend countless hours trying to create something which I feel is inherently wrong?
I would probably learn plenty about the React hooks and with one more project under my belt my
understanding of good React architecture would also improve.

At this point I was still commited to the idea of building my own blogging solution,
but a seed of doubt was also growing in my mind.

### Styling the blog

I might be a front end developer, but at the same time I'm color blind and own very little eye for stylish sites.
With React I would simply use a Material UI or a similar library for the styling.

I wanted a bit more personal look than the traditional Bootstrap so I started to
dig around for some stylish looking blogs.
Somehow I ended up on a a site with [Jekyll themes](https://jekyllthemes.io/).

[Jekyll](https://jekyllrb.com/) sounded familiar.
I must have stumbled upon it when I was previously looking around at
[GitHub Pages](https://pages.github.com/).

Maybe this was the solution I had been looking for!

## GitHub Pages & Jekyll

I knew that hosting on GitHub Pages was free so that's always a big plus.
After some digging around I found out that you'll also get a pretty url like
[mikkoluhtasaari.github.io](https://mikkoluhtasaari.github.io/) from the GitHub Pages.

At this point I thought that maybe setting up the blog is extremely difficult.
Most likely it requires at least configuring some GitHub actions to get the Markdown to HTML.

I opened the most minimalistic of the themes called [Reverie](https://jekyllthemes.io/theme/reverie).
First feature listed in the site was
"Command-line free fork-first workflow, using GitHub.com to create, customize and post to your blog".

Could it really be that simple?
Just Fork-n-Go?
And yes it was almost that simple!
All I needed to do was fork the project, change a few configuration options and
my blog was up-and-running.

In my next blog post I'll do a step-by-step guide to setting up your very own
blog in GitHub Pages with Reverie.
