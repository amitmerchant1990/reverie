---
layout: default
title: Home
---

<img width="100%" alt="SEACrowd Logo" src="https://github.com/SEACrowd/.github/blob/main/profile/assets/seacrowd-email-banner-without-logo.png?raw=true">

We are a community dedicated to bridging the gap between multilingual AI and Southeast Asian AI and enhancing the quality of AI research and researchers in the region.

> See what indigenous and non-indigenous languages are under our study [here](https://github.com/SEACrowd/seacrowd-datahub/blob/master/LANGUAGES.md).

## Some of Our Work

 - SEACrowd Catalogue
 - IndoBERT

[See More of our Projects](https://github.com/SEACrowd/seacrowd-datahub/blob/master/LANGUAGES.md)

## Ongoing Work

- SEAVL

## News and Updates

<div class="posts">
  {% for post in site.posts %}
    <article class="post">
      <a href="{{ site.baseurl }}{{ post.url }}">
        <h1>{{ post.title }}</h1>
        <div>
          <p class="post_date">{{ post.date | date: "%B %e, %Y" }}</p>
        </div>
      </a>
      <div class="entry">
        {{ post.excerpt }}
      </div>
      <a href="{{ site.baseurl }}{{ post.url }}" class="read-more">Read More</a>
    </article>
  {% endfor %}
</div>

{% if paginator.total_pages > 1 %}
  <div class="pagination">
    {% if paginator.previous_page %}
      <a href="{{ paginator.previous_page_path | prepend: site.baseurl | replace: '//', '/' }}">&laquo; Prev</a>
    {% else %}
      <span>&laquo; Prev</span>
    {% endif %}
    {% for page in (1..paginator.total_pages) %}
      {% if page == paginator.page %}
        <span class="webjeda">{{ page }}</span>
      {% elsif page == 1 %}
        <a href="{{ '/' | prepend: site.baseurl | replace: '//', '/' }}">{{ page }}</a>
      {% else %}
        <a href="{{ site.paginate_path | prepend: site.baseurl | replace: '//', '/' | replace: ':num', page }}">{{ page }}</a>
      {% endif %}
    {% endfor %}
    {% if paginator.next_page %}
      <a href="{{ paginator.next_page_path | prepend: site.baseurl | replace: '//', '/' }}">Next &raquo;</a>
    {% else %}
      <span>Next &raquo;</span>
    {% endif %}
  </div>
  {% endif %}




