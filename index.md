---
layout: default
title: Home
---

<img width="100%" alt="SEACrowd Logo" src="https://github.com/SEACrowd/.github/blob/main/profile/assets/seacrowd-email-banner-without-logo.png?raw=true">

# Welcome to SEACrowd! 👋

We are a community dedicated to bridging the gap between multilingual AI and Southeast Asian AI and enhancing the quality of AI research and researchers in the region.

> See what indigenous and non-indigenous languages are under our study [here](https://github.com/SEACrowd/seacrowd-datahub/blob/master/LANGUAGES.md).

<div align="center">
  <div class="btn-group" role="group" aria-label="Button group">
      <a href="#" class="btn btn-primary">
          <i class="fas fa-info-circle"></i> Learn More
      </a>
      <a href="#" class="btn btn-primary">
          <i class="fab fa-x-twitter"></i> Social Media
      </a>
      <a href="#" class="btn btn-primary">
          <img src="https://huggingface.co/front/assets/huggingface_logo-noborder.svg" alt="Hugging Face" style="height: 20px; margin-right: 8px;"> HuggingFace
      </a>
  </div>
</div>

<hr/>

## ✔️ Past Projects

- 11/2023 to 06/2024. [**SEACrowd: A Multilingual Multimodal Data Hub and Benchmark Suite for Southeast Asian Languages**](https://arxiv.org/pdf/2406.10118). Accepted in EMNLP 2024. [[Announcement]](https://seacrowd.github.io/seacrowd-emnlp-2024/)

<hr/>

## 🤔 What's Next?

### 🖼️ SEA Visual Instruction

We will launch our new project in early Nov 2024 (11/2024). [Stay tuned!](https://seacrowd.github.io/contact/)

### 🌏 Special Interest Group in Southeast Asian NLP (SIGSEA)

SIGSEA aims to change that by promoting research, collaboration, and sharing updates on Southeast Asian NLP. This way, in the future, we also can hold our own SEA workshops & events in ACL conferences! 💪

We're collecting expressions of interest for membership. As a member, you'll receive regular updates on research, events, and opportunities in the region.

Everyone can join (no need for ACL membership). **Sign up today to join SIGSEA via [this form](https://docs.google.com/forms/d/e/1FAIpQLSfNiQ6xSq3yMDMITKbmRvkvjQkznpgO3BFfOHa0957sGnmsbw/viewform)! 🫶**

### 🧑‍🎓 SEACrowd Apprentice (Pilot) Program

On-going since 08/2024.

This program targets early-career AI enthusiasts from underserved Southeast Asian communities, who are looking to gain their first substantial research experience. Many face challenges such as limited access to research tools, mentorship, and AI developments.

Our program addresses these gaps by providing research problems for participants to solve in small teams, guided by experienced mentors. Through hands-on projects and learning key concepts, participants work toward writing a publication for top AI conferences like ACL. The program also emphasizes critical thinking, collaboration, and academic writing to prepare participants for success in AI research.

<hr/>

# News and Updates

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


{{ site.total_pages }}
{{ site.page }}


{% if site.total_pages > 1 %}
  <div class="pagination">
    <!-- Previous Page Link -->
    {% if site.page > 1 %}
      <a href="{{ site.paginate_path | prepend: site.baseurl | replace: ':num', site.page | minus: 1 | replace: '//', '/' }}">&laquo; Prev</a>
    {% else %}
      <span>&laquo; Prev</span>
    {% endif %}    
    <!-- Page Numbers -->
    {% for page in (1..site.total_pages) %}
      {% if page == site.page %}
        <span class="current-page">{{ page }}</span>
      {% elsif page == 1 %}
        <a href="{{ site.baseurl }}/">{{ page }}</a>
      {% else %}
        <a href="{{ site.paginate_path | prepend: site.baseurl | replace: ':num', page | replace: '//', '/' }}">{{ page }}</a>
      {% endif %}
    {% endfor %}    
    <!-- Next Page Link -->
    {% if site.page < site.total_pages %}
      <a href="{{ site.paginate_path | prepend: site.baseurl | replace: ':num', site.page | plus: 1 | replace: '//', '/' }}">Next &raquo;</a>
    {% else %}
      <span>Next &raquo;</span>
    {% endif %}
  </div>
{% endif %}





