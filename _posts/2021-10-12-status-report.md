---
layout: post
title:  ARR Status Report
categories: [Admin]
---

The ACL Rolling Review (ARR) officially kicked off in early 2021, with the first call for papers in April, and the first deadline in May. This initiative was started with the [promise](https://www.aclweb.org/adminwiki/index.php?title=ACL_Rolling_Review_Proposal) of a unified reviewer pool, more consistent reviewing, lower average reviewer load, and faster submission to publication timelines.  

Now, 5 months and 5 deadlines into the new system, we wanted to give an update on the ARR process.

## ARR Statistics
Let’s start with some statistics.


### Submissions
The number of submissions each month is shown in the bar chart below. One third to one half of the submissions were opted in to be anonymous preprints hosted on OpenReview, with links tweeted by the [ARRPreprints](https://twitter.com/ARRPreprints) twitter bot. So far, this bot has 343 followers, significantly less than [similar](https://twitter.com/arxiv_cscl) [accounts](https://twitter.com/arXiv_Daily). Most tweets get about 100-200 impressions, although a few have reached up to 15K impressions. 

We expect there to be dramatically more submissions in the October and November deadlines.

![Number of Submissions](/images/arr_report/num-submissions.png)


### Reviewer Pool
The review process involves both reviewers and Action Editors (commonly called Area Chairs in most conferences). The number of reviewers in the pool (shown in the figure below) has hovered around 1200, with about 100 to 150 action editors. In contrast, [ACL 2021](https://aclanthology.org/2021.acl-long.pdf) had 60 SACs, 323 ACs, and 3,685 primary reviewers, to deal with 3,350 full paper submissions.

Our reviewer pool is dramatically smaller than the pool in ACL 2021. 

![Reviewer Pool](/images/arr_report/reviewer-pool.png)

### Timing

The original goal of ARR was to have all reviews and meta-reviews completed within 35 days. The process requires that each paper has 3 reviews, and once those are complete, a meta-review. This is a pretty tight turnaround. By comparison, in [ACL 2021](https://2021.aclweb.org/calls/papers/), the time from submission to discussion period (which does not include meta-reviews) was 51 days, almost twice the length of ARR review+meta-review period. The time from submission to notification amounted to 92 days, nearly 3 times what ARR is aiming for.

In the graph below, each data point is the time taken for an individual review after the submission deadline. A handful of rapid reviewers got their reviews in before 20 days (thank you!), many reviews are completed +/- 2 day from the deadline, and a non-trivial number (about 25%) are finished after the deadline, with one or two stretching even as far as 90+ days later. 

The graph also shows relevant deadlines from ACL 2021 as dashed vertical lines. While ARR is not yet hitting all promised reviewing target deadlines, notice that the timeline is compressed compared to ACL.

(This graph doesn’t include the 24 reviews that are not yet finished, most of which are from the August deadline.) 

![Days from Submission to Review](/images/arr_report/days-from-submission-to-review.png)

The following graph is analogous, but looking at time from submission to meta-review.

![Days from Submission to Meta-Review](/images/arr_report/days-from-submission-to-meta-review.png)


### Conference Submissions
ARR provides no decisions, only reviews, which can be submitted to a conference or workshop. As of writing, a total of 26 papers with ARR reviews have been submitted to conferences. The breakdown is shown in the bar chart below.

![Conference Submissions](/images/arr_report/conf-submissions.png)

## Major Challenges

### Review Time
The major challenge ARR has faced is getting reviews back in time. As of writing (Sept 2021), there is 1 paper from June that has still not received all 3 reviews, and there are a handful in each subsequent deadline as well. These delays have happened for several reasons, including technical issues with OpenReview, mistakes we made (e.g. failing to send reminders), but overall overwhelmingly because of unresponsive reviewers and meta-reviewers.

We are keenly aware of the issues with late reviews, and the ripple effects on conference submission deadlines. We are working to improve the process in several ways: 

- Improving the assignment of action editors and reviewers, and automating the process of reminding reviewers and action editors.
- Recruiting emergency reviewers and action editors who can step in when a reviewer/action editor doesn't complete their job.

_We cannot succeed unless reviewers and action editors complete their work on time_. ARR is a peer-reviewing process: authors depend on timely delivery of reviews, and reviewers and action editors are also authors.

### Reviewers Declining

One of the biggest challenges that action editors have faced is reviewers declining to review, leading to late reviews. This is happening for a variety of reasons, including reviewers being assigned papers that they don’t feel qualified to review, or papers assigned with very tight deadlines.

We are working on ways of addressing this. One partial remedy is to provide reviewers with no option to decline (especially not on a per-assignment basis). Instead, **reviewers will have to request** to be exempt prior to the submission deadline, and will be asked to acknowledge when they have received a review request. 

Other (smaller) remedies will be more technical in nature -- such as simple interface changes, for example, including the name of the action editor requesting the review in the email request (there is no action editor <> reviewer anonymity) to facilitate the communication between reviewers and action editors. 

### Technical Issues

Another hurdle has been in stretching the OpenReview system to a new use case. OpenReview has been successfully used for several years in a number of large conferences, including [NeurIPS](https://openreview.net/submissions?venue=NeurIPS.cc) and [ICML](https://openreview.net/group?id=ICML.cc). But in each of these cases, there is a single deadline with a single reviewer pool. ARR has a deadline every month, and OpenReview creates an entirely new conference each month. We have to copy over reviewers and action editors from the prior month. This makes many editorial duties significantly more difficult. For example, it is not possible to track all missing reviews and meta-reviews in one place; similarly, it is at the moment not possible to track and balance overall reviewing load across months. 

We are improving the process with each deadline, and also working closely with developers at OpenReview. We are hopeful that in time many of the problems will be ironed out, leading to a smoother and easier process.

## Looking Ahead
We are anticipating a heavier load in the following few months since both [ACL 2022](https://www.2022.aclweb.org/) and [NAACL 2022](https://2022.naacl.org/) will adopt ARR as their sole reviewing system. We ask for patience and understanding from authors, and strict adherence to timelines from reviewers and meta-reviewers. We are also working together with ACL and NAACL 2022 chairs to make sure that every manuscript submitted to the respective ARR deadlines is processed in time and can ultimately (if so desired by the authors) commit to those conferences.  

We are also excited about a number of new initiatives, including training for reviewers and action editors, [mentoring](/mentorship) for new reviewers, automated review quality assessment, and a new reviews corpus. In the prior conference reviewing system, many of these initiatives would have been organized on a conference-by-conference basis. Having a centralized reviewing system makes these tasks much simpler. 

As it becomes more widely adopted, and as the process becomes smoother with time, we hope that ARR will prove to be a valuable reviewing system that ensures reviews of consistently high quality with a sustainable amount of effort from the *ACL community.






