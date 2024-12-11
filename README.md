<div align="center">
  <br>
  <img src="/images/reverie-text.png" alt="Reverie" width="200"/>
  <br>  
  <p align="center">
    <i>Support my work via <a href="https://paypal.me/AmitMerchant">Paypal</a> or <a href="https://buymeacoffee.com/amitmerchant">Buy me a coffee</a></i>
  </p>
</div>

---

Reverie is a [Jekyll](https://jekyllrb.com/)-powered theme which is simple and opinionated. It's actually a fork of [jekyll-now](https://github.com/barryclark/jekyll-now) with some additional features and personal touches which I've implemented to suit my needs for my blog.

> [Theme demo](https://reverie.pages.dev/)

This is a plug-and-play Jekyll theme best suited to use on [GitHub Pages](https://pages.github.com) (or [Cloudflare Pages](https://pages.cloudflare.com/) if you want to have your repository private) without even setting up a local environment.

![](/images/reverie-demo.png)

|  Responsiveness            |  Search | Categories |
|---------------------|----------------------|----------------------|
|![Responsiveness](/images/mobile-demo.png) | ![search](/images/search.png) | ![categories](/images/categories.png) |

# Table of Contents
  - [Features overview](#features-overview)
  - [Using Reverie on GitHub Pages](#using-reverie-on-github-pages)
    - [1. Fork Reverie to your User Repository](#1-fork-reverie-to-your-user-repository)
    - [2. Customize and view your site](#2-customize-and-view-your-site)
    - [3. Publish your first blog post](#3-publish-your-first-blog-post)
  - [Using Categories in Reverie](#using-categories-in-reverie)
  - [Pagination](#pagination)
  - [RSS](#rss)
  - [Sitemap](#sitemap)
  - [Troubleshooting](#troubleshooting)
  - [Emailware](#emailware)
  - [The name?](#the-name)
  - [License](#license)

{:toc}

## Features overview

- Clean and minimal design
- Single column post layout
- Command-line free fork-first workflow, using GitHub.com to create, customize and post to your blog
- Fully responsive and mobile optimized theme
- Sass/Coffeescript support using Jekyll 2.0
- Free hosting on your GitHub Pages user site
- All the SEO goodies come built-in
- Markdown blogging
- Supports [Pullquotes](https://reverie-jekyll.netlify.app/pullquotes/)
- Syntax highlighting using Pygments
    - [Dracula syntax theme](https://draculatheme.com/) included
- Disqus commenting
- Social media icons
- Google Analytics integration
- Supports [Google Analytics 4](https://support.google.com/analytics/answer/10089681?hl=en)
- Fuzzy search across blog posts
- Blog with pagination
- Categorize posts out-of-the box
- RSS Feed
- Built-in sitemap

> <p><i>Like this theme?</i> If so, consider donating a small amount that will help my maintaining this project further.<p>
> You can support me via <a href="https://paypal.me/AmitMerchant">Paypal</a>.

## Using Reverie on GitHub Pages

Setting up Reverie on GitHub Pages is as simple as it gets!

### 1. Fork Reverie to your User Repository

Fork this repository, then rename the repository to `yourgithubusername.github.io`.

Alternatively, you can click the [`Use this template`](https://github.com/amitmerchant1990/reverie/generate) button if you want to create a repository with a clean commit history which will use Reverie as a template.

Your Jekyll blog will often be viewable immediately at <https://yourgithubusername.github.io> (if it's not, you can often force it to build by completing step 2).

### 2. Customize and view your site

Enter your site name, description, avatar and many other options by editing the `_config.yml` file. You can easily turn on Google Analytics tracking, Disqus commenting and social icons here.

Making a change to `_config.yml` (or any file in your repository) will force GitHub Pages to rebuild your site with Jekyll. Your rebuilt site will be viewable a few seconds later at <https://yourgithubusername.github.io> - if not, give it ten minutes as GitHub suggests and it'll appear soon.

### 3. Publish your first blog post

Delete all files from `_posts`directory and create a new file called `/_posts/2019-2-13-Hello-World.md` to publish your first blog post. That's all you need to do to publish your first blog post! This [Markdown Cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet) might come in handy while writing the posts.

> You can add additional posts in the browser on GitHub.com too! Just hit the <kbd>Create new file</kbd> button in `/_posts/` to create new content. Just make sure to include the [front-matter](http://jekyllrb.com/docs/frontmatter/) block at the top of each new blog post and make sure the post's filename is in this format: year-month-day-title.md

## Using Categories in Reverie

You can categorize your content based on `categories` in Reverie. For this, you just need to add `categories` in front matter like below:

For adding single category:

```md
categories: JavaScript
```

For adding multiple categories:

```md
categories: [PHP, Laravel]
```

The categorized content can be shown over this URL: <https://yourgithubusername.github.io/categories/>

## Pagination

Pagination of posts in Reverie works out-of-the-box. You only need to specify the number of posts you want on a single page in `_config.yml` and Reverie will take care of the rest.

```yml
paginate: 6
```

## RSS

Reverie comes with a [RSS feed](https://en.wikipedia.org/wiki/RSS) in-built. The generated RSS Feed of your blog can be found at <https://yourgithubusername.github.io/feed>. You can see the example RSS feed over [here](https://reverie-jekyll.netlify.app/feed.xml).

## Sitemap

The generated sitemap of your blog can be found at <https://yourgithubusername.github.io/sitemap.xml>. You can see the example sitemap feed over [here](https://reverie-jekyll.netlify.app/sitemap.xml).

## Troubleshooting

There might be instances where your site based on Reverie won't have the styling working as expected. 

The common reason for this issue is the incorrect `baseurl` set in the `_config.yml` file. You need to use the `baseurl` according to where you're hosting it.

So, for instance, if you're hosting your site at a Project repository on GitHub pages (http://yourusername.github.io/repository-name) and NOT your user repository (http://yourusername.github.io) then the `baseurl` will be `/repository-name`.

Otherwise the `baseurl` will be `/`.

## Emailware
Reverie is an [emailware](https://en.wiktionary.org/wiki/emailware). Meaning, if you liked using this theme or it has helped you in any way, I'd like you send me an email at <bullredeyes@gmail.com> about anything you'd want to say about this software. I'd really appreciate it!

## The name?

reverie - _a state of being pleasantly lost in one's thoughts; a daydream._<br><sup>/ˈrɛv(ə)ri/</sup> 


## License

MIT
