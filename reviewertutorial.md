---
layout: page
title: "How to review for ACL Rolling Review"
permalink: /reviewertutorial
---

# How to review for ACL Rolling Review

_Anna Rogers, Isabelle Augenstein_

Version 0.1, 02.11.2021

The ARR peer review tutorial is a work-in-progress, and will be updated as ARR evolves. Before starting an assignment, the reviewers should always check whether the version they are familiar with is still the current one; if not, please see the [changelog](#changelog) for what sections you should revisit.

## Why is peer review so inconsistent?

You may have heard of the 2014 [NeurIPS experiment](https://arxiv.org/abs/2109.09774) with assigning the same papers to two sets of reviewers. Its results suggested that nearly 50% of the accepted NeurIPS papers would have been rejected, had they simply been assigned to different reviewers. This is obviously a frustrating situation for the authors, going through rounds of arbitrary rejections. 

Why does this happen? There are many factors, but here are some of the most prominent ones:

* Variance in the **experience of reviewers**. Some reviews are by experienced reviewers and some are by novices; yet, to date there has been little effort to provide systematic training. 
* Differences in understanding the **key evaluation criteria**. What counts as a "weakness" - a fundamental flaw or a lack of clarification experiment? What exactly does "overall recommendation" mean - the personal interest in the topic or how solid the research is?
* Implicit **biases** that we all have due to our social and academic backgrounds. The same approach may receive different evaluation if it is tested on a popular or a niche task, on English or any other language, with focus on engineering or linguistic aspects, and if it had been preprinted by a well-known lab and received much attention.

This tutorial is part of an effort to improve the overall quality of reviews at *ACL conferences, aiming to address the above issues. It discusses the overall structure and philosophy of the process for first-time reviewers, clarifies the ARR principles and the review form, and addresses some of the cognitive and social biases that undermine peer review. 

In this tutorial:

> [Why is peer review so inconsistent?](#why-is-peer-review-so-inconsistent-)
> 
> [How to write a good review?](#how-to-write-a-good-review-)
> - [1. Before the paper assignment](#1-before-the-paper-assignment)
> - [2. Check that you can perform the assignment](#2-check-that-you-can-perform-the-assignment) 
> - [3. Plan your time](#3-plan-your-time) 
> - [4. How to read for review](#4-how-to-read-for-review) 
> - [5. ARR review form](#5-arr-review-form) 
>   * [Summary](#summary)
>   * [Strengths of the paper](#strengths-of-the-paper)
>   * [Weaknesses of the paper](#weaknesses-of-the-paper)
>   * [Comments/Suggestions/Typos](#comments-suggestions-typos)
>   * [Overall assessment](#overall-assessment)
>   * [Reviewer confidence](#reviewer-confidence)
>   * [Knowledge of/educated guess at author identity](#knowledge-of-educated-guess-at-author-identity)
>   * [Ethics review](#ethics-review)
> - [6. Check for lazy thinking](#6-check-for-lazy-thinking)
> - [7. Check for (lack of) enthusiasm](#7-check-for--lack-of--enthusiasm)
> - [8. Check the framing](#8-check-the-framing)
> 
> [Discussion period](#discussion-period)
> 
> [Resubmissions](#resubmissions)
> 
> [Changelog](#changelog)
> 
> [Acknowledgements](#acknowledgements)
> 
> [Resources](#resources)

  
## How to write a good review? 

### 1. Before the paper assignment 

Before starting any review work, please read:

* this tutorial
* [ACL Code of Ethics](https://www.aclweb.org/portal/content/acl-code-ethics)
* ARR [call for papers](https://aclrollingreview.org/cfp), which describes the scope of the invited submissions and instructions for the authors
* the post describing the [ARR review form](https://aclrollingreview.org/reviewform)
* the [tutorial](https://docs.google.com/presentation/d/1CkfR94WxEPEZEyCN--ydC7K3wY4g-5ZiFd2HM8LRSXg/edit#slide=id.gf84c08a109_0_55) for performing common actions on OpenReview: viewing your current tasks, adding reviews, participating in discussion, contacting action editors

All the information about submissions and reviews that you receive as part of your assignment is **confidential**. If you participate in discussions of peer review on social media, please make sure that your comments/examples are general enough that no submissions can be identified, and the authors cannot identify you. Do not refer to individual papers.

When you accept the invitation to review for ARR, please make sure that your Semantic Scholar is accurate and up-to-date. This information is used in the automatic reviewer suggestions, so the more accurate it is, the more likely you are to get papers in your area.

### 2. Check that you can perform the assignment 

As soon as you get an assignment, skim the paper to check whether this is **something that you are qualified to review**. The assignments are made based on a semi-automatic process, and, even with careful checks by the action editor, you may feel like you are not qualified to review a given submission.  

Yet, even in the best-case scenario the matches will not always be perfect. For very novel work or atypical papers, it is inherently difficult to find available qualified reviewers.  The possibility of a very close match also depends on the set of people in the reviewing pool, therefore increasing the chances of a good match for the large, popular subfields. And even large subfields may experience a lack of well-matching reviewers when they are actively growing. Moreover, sometimes a less obvious match may also be a conscious decision on the part of the action editor, e.g., to collect reviewers from different perspectives when the paper is interdisciplinary, or when it focuses on less popular topics and languages. 

So, the bad news is that realistically, you will sometimes be asked to review papers that are a bit outside of your own subfield. That is ok as long as you are sufficiently familiar with the core methodology. If your expertise does not cover certain aspects of the submission, your review should specify that, and you will also be able to indicate your confidence score in the ARR form. 

The good news is that the less-than-perfect matches also have upsides: you get to expand your repertoire, the authors get feedback on what needs more clarification/explanation, and NLP in general gets more intellectual exchange between subfields.

The second thing to check is whether **you know or can guess who the authors are.** Ideally, ARR peer review should be fully anonymous. The problem with implicit social biases is that they are unconscious; we may be 100% sure that we do not think worse of a paper just because it is written by someone from a group minoritized in computing research, and that we are not pre-disposed to like papers coming from famous labs, but we cannot really trust our conscious selves.

Thus, when you get the assignment, do check that [anonymity is preserved](https://www.aclweb.org/adminwiki/index.php?title=ACL_Policies_for_Submission,_Review_and_Citation). If it is not, the paper should be **desk-rejected**: contact your action editor about this. You can also indicate that the paper should be desk-rejected if it does not follow the style guides or goes over the page limit (which does _not_ include the ethical considerations section). 

If anonymity is preserved, but you happen to know who the authors are from personal communication, social media or talks, ask for re-assignment if possible, especially if you have a conflict of interest (because you know the authors personally, have or will work with them etc.). For the papers where it is impossible to maintain anonymity (e.g., because they are [too famous](https://medium.com/@ryancotterell/we-should-anonymize-model-names-during-peer-review-bcab0cc78946), or the authors are easy to guess for anyone who works in the same narrow subfield), the ARR policy is to indicate your awareness of the authors' identity in the review form (more on that later).

The third check is on **academic conflicts of interest**. If the submission looks like something that is very close to your own work about to be submitted, it is best to recuse yourself.

_You can contact your action editor either directly or through OpenReview (see the OpenReview [tutorial](https://docs.google.com/presentation/d/1CkfR94WxEPEZEyCN--ydC7K3wY4g-5ZiFd2HM8LRSXg/edit#slide=id.gf84c08a109_0_55)):_

* _To communicate through OpenReview, you should see a button labeled “Official Comment” at the top of the paper forum. Click on it to open a message form. For messaging exclusively the action editors, please select only “area chairs” in the “Readers” field of the form._
* _To communicate through email, you can find the name of the action editor on the “Paper Assignments” page in OpenReview, and click on their name. Their email will be anonymized on the OpenReview page itself (for privacy reasons), but you can often find it by clicking on the “Homepage” link or otherwise searching for their contact information by following the links in the profile._

### 3. Plan your time 

Normally, ARR reviewers commit for at least a year, but the actual reviewing load may vary from month to month. When you accept an assignment, please **block the time in your calendar for working on that review and submitting it on time**. A delay means not only extra work for the action editor and other volunteer reviewers, but given the tight deadlines for submission to conferences, it may also have grave consequences for the authors. Especially for the student authors and junior academics, it is very important that the reviews be available on time for the commitment deadlines for conferences. Moreover, the more people submit their reviews late, the more the community sees it as the norm, and so the higher the chances that your own papers will also get “stuck” in ARR later.

How much time will you need? That varies by reviewer, paper, and experience. A way of estimating it would be to calculate what your average time for (a) an in-depth reading of a paper is that is as close to your area as the submission, (b) writing and editing about half a page of an article. You may also need to participate in the forum discussion with other reviewers before the reviews are sent to the authors.

If at all possible, reviewing should **not** be done in a single session. When you first read a paper, you may have a knee-jerk reaction to it that would make it harder to write a useful review. For example, you may fundamentally dislike the topic, or the method that was chosen, or [the conclusions are at odds with what you already believe](https://www.acpjournals.org/doi/abs/10.7326/0003-4819-116-11-958_2). It is best to read the paper and let it sink in for a few days, and then work on the review. If you write a first-impression draft at once, make sure to revisit it later.

### 4. How to read for review 

Everybody's process is different, but one strategy that seems to be often used, but **not** very well suited for peer review is commenting _during_ the very first read. You do need to first at least skim the paper and understand the overall type of contribution and the framework in which the authors are working. If you do not do that, you are likely to start critiquing the paper from the perspective of a “prototypical” NLP paper in your area (e.g., an experimental paper proposing a SOTA system for English). That mental model might bias you against other types of contributions (e.g., resource papers, model or linguistic analysis, data processing/annotation strategies, reproduction studies, surveys, position pieces, negative results). Any study should be judged for what it is, and not for what you think it should be.

For experimental papers, a useful trick is to avoid looking at the results when first skimming the paper. When you start actually reading, carefully read the introduction and the methodology sections. After that, pause and ask yourself: is it clear what the research question is and what was done? Do you believe this would answer that question? Do you want to know the answer? Will the answer advance the field? Only then you should look at the results. This way you will be better able to focus on the _knowledge_ gained in the paper: the result may be negative, but if you believe that the experiments are sound and the question worth asking, something that could save time to many others - this is also a valid contribution, as per the [ARR call for papers](https://aclrollingreview.org/cfp).

Note whether the paper is long or short, and adjust your expectations accordingly. Long papers are supposed to describe completed work, with thorough evaluation and analysis. A short paper may present proof of concept, an interesting finding, a convincing point, but it is **not** expected to have extensive evaluation and analysis: only the minimal (but sufficiently convincing) evidence for the claim.

While you read, you may want to look up some references or concurrent work. This should be done cautiously: many papers have non-anonymous preprints, and you may accidentally discover the identity of authors, which would open you up to social biases. 

The paper should be readable by itself, and any details important for understanding the key aspects of the work should be in the paper rather than in appendices. The authors may also provide supplementary material with extra experiments, implementation details, examples, code, or data. You are **not** required to consider such material. At the same time, if you happen to have questions to the authors that are answered in the supplementary material (e.g., if the authors mention an issue in the paper and refer the reader to the appendix for it), looking it up could save everybody’s time.


### 5. ARR review form 

If you have not done so yet, read the post describing the [ARR review form](https://aclrollingreview.org/reviewform). 

Your review will be seen by three different audiences: (a) the authors, (b) the other reviewers and the action editor, and (c) the senior area chairs and the program chairs of the venue(s) that will consider this submission. Not all parts of the form are addressed to all of them.


#### Summary 

The "**summary**" of the paper should be just that: a neutral, dispassionate summary of the research question and findings/contributions. We would help the program chairs the most by not tainting these summaries with, e.g., suggestions that the topic is exciting or a waste of time.

Make sure you acknowledge **all** the contributions that you believe the paper is making: experimental evidence, replication, framing of a new question, artifacts that can be used in future work (models, resources, code), literature review, establishing new cross-disciplinary connections, conceptual developments, theoretical arguments. A paper may make several contributions, and not all of them need to be equally strong. You should state in your own words what you see as contributions of the paper, rather than copy/paste it from the abstract. This helps the authors and the chairs to see that you understood the gist of the paper. 


#### Strengths of the paper 

For the “**strengths**”, even if you fundamentally disagree with the paper, it is important for the program chairs (and the mental health of the authors) that you accurately state all the best aspects of it. Once again, the strengths may come in many different forms: an engineering solution, framing an important issue, a literature review, a useful artifact (a model or a resource), a conceptual development, a reproduction). Performance improvements or complex math are by themselves neither necessary nor sufficient. It should be clear in what way the study advances the field: what did we learn from it that we did not know before? What can we do that we could not do before?

If one of the strengths is the performance of the proposed system, do check that the baseline is sufficiently strong and well-tuned, and that the [result is robust](https://aclanthology.org/D17-1035.pdf) (e.g., not just the best of an unknown number of runs). Ideally, the [computation budget](https://aclanthology.org/D19-1224/) should be reported, and the paper should score high on reproducibility.

#### Weaknesses of the paper 

For “**weaknesses**”, there are many things that could go wrong in a study. The NeurIPS experiment showed also that a significant subset of submissions are consistently identified as low-quality. There may be claims that are not actually supported by the evidence or by the arguments, but that are presented as conclusions rather than as hypotheses/discussion. The framing may be misleading. There may be obvious methodological flaws (e.g., only the best run results are reported), errors in the proofs, in the implementation, or in the analysis. There may be insufficient detail to understand what was done or how to reproduce the method and the results. There may be a lack of clarity about what the research question is (even if it is “Does system A work better than system B”?), what was done, why, and what was the conclusion. The paper should also make it clear in what way the findings and/or the released artifacts advance the field.

At the same time, there are many complaints about reviews at previous conferences that cite as weaknesses things that are not in fact weaknesses. Once you have the first draft of your review, you will need to revisit it to check for these errors (see below). 

A common reviewer mistake is confusing “must-haves” with “nice-to-haves.” Any project has limited time and pages, and it is always possible to think of more follow-up experiments. As long as enough work was done to prove the claims that the authors are making, any extra experiments are in the “nice-to-have” category, and not a weakness as such. This mistake might explain the systematically low acceptance rates for short papers: because they are short, it is very easy to think of more things that could have been done. Consider that in 2020 there were 24.6% accepted long papers vs. 16.7% short at EMNLP, 25.4% vs. 17.6% at ACL, and 35.5% vs. 27.7% at COLING.

If you have serious concerns, but you see how the paper could be improved, please be specific about what the authors could do to address your concerns. Please also **number all the points to which you would like the authors to respond** in order to change your view of this work. 

#### Comments/Suggestions/Typos 

While the other fields are written for the chairs, this field is a message to the authors. This is the place for general comments, suggestions, clarifications, pointing out (a reasonable amount of) typos or language errors: the small things that you do not consider “weaknesses” and should not distract the chairs from your overall assessment. Of course, if you find the paper completely illegible or unclear, such issues can escalate to the “weakness” list for the chairs.

Your feedback can be incredibly valuable for the authors. A sad fact of academia is that [many published papers go uncited](https://www.insidehighered.com/news/2018/04/19/study-examines-research-never-receives-citation), and one part of that problem is that it is not easy to communicate clearly and effectively with a wide audience. Reviewers can often help the authors to significantly improve their papers. If you see something that they could do to increase the potential impact of their work, it is professional courtesy to let them know. Some examples include figures that are hard to read or interpret, the points that require extra background reading, ambiguity, and non-obvious connections between sections. If you have comments or questions that you would like the authors to respond to (beyond “thanks, we'll fix this”), please number them.

Be careful in suggesting citations of your own papers. When you have truly relevant related work, this is appropriate, but it is also potentially de-anonymizing (especially when the paper in question is not very well-known). One workaround is to suggest several citations, including yours. 

#### Overall assessment 

In the current version of the ARR review form the “**overall assessment**” (on a scale of 1 to 5) is in fact the ranking of the paper by the recommended venue tiers, from the main *ACL conferences (ACL, EMNLP, NAACL, EACL, AACL) to their satellite workshops[^1]. The ranking is _not_ supposed to reflect on the topics or methods of the papers: only the thoroughness of research and its potential impact on the target subfield. That subfield does _not_ have to be large and popular.

In our experience, very few papers ever get top scores from reviewers, or recommendations for best paper awards. It is true that no research project is ever perfect, but do try to set your baseline at an average *ACL main track paper, rather than a Nobel prize-winning paper.


#### Reviewer confidence 

The **reviewer confidence** rank lets you provide the action editor with an indicator of how sure you are about your evaluation. If your confidence is lower, you are probably going to be requesting clarifications and additional details. In that situation, it would be very helpful for the authors to know how your opinion would change, should they provide satisfactory revisions.


#### Knowledge of/educated guess at author identity 

As mentioned above, if you know who the authors are you should have tried to have this paper reassigned. If this was not possible, this is the place to indicate that your review should be taken with a grain of salt. 


#### Ethics review 

If you believe there may be an ethics issue with the paper, you can flag it for a separate review process by the ACL ethics committee. See the [ARR submission checklist](https://aclrollingreview.org/authorchecklist) for a list of things to look out for.


### 6. Check for lazy thinking 

Judging whether a research paper is “good” is an objectively hard task. To avoid dealing with this problem, reviewers often develop “shortcuts”, quick heuristics that serve as reasons to dismiss papers, such as the famous “[reject if not SOTA](https://hackingsemantics.xyz/2020/reviewing-models/).”

Here is a list of such heuristics derived from author complaints in recent NLP conferences, and why they are not always “weaknesses.” Many of them have even been studied in psychology and bibliometric research. 


<table>
  <tr>
   <td><strong>Heuristic</strong>
   </td>
   <td><strong>Why this is problematic</strong>
   </td>
  </tr>
  <tr>
   <td>The results are not surprising
   </td>
   <td>Many findings seem obvious in retrospect, but this does not mean that the community is already aware of them and can use them as building blocks for future work. 
   </td>
  </tr>
  <tr>
   <td>The results contradict what I would expect
   </td>
   <td>You may be a victim of confirmation bias, and be unwilling to accept data contradicting your prior beliefs.
   </td>
  </tr>
  <tr>
   <td>The results are not novel
   </td>
   <td>Such broad claims need to be backed up with references.
   </td>
  </tr>
  <tr>
   <td>This has no precedent in existing literature
   </td>
   <td>Believe it or not: papers that are more novel tend to be harder to publish. Reviewers may be unnecessarily conservative.
   </td>
  </tr>
  <tr>
   <td>The results do not surpass the latest SOTA
   </td>
   <td>SOTA results are neither necessary nor sufficient for a <em>scientific</em> contribution. An engineering paper could also offer improvements on other dimensions (efficiency, generalizability, interpretability, fairness, etc.)
   </td>
  </tr>
  <tr>
   <td>The results are negative
   </td>
   <td>The bias towards publishing only positive results is a known problem in many fields, and contributes to hype and overclaiming. If something systematically does not work where it could be expected to, the community does need to know about it.
   </td>
  </tr>
  <tr>
   <td>This method is too simple
   </td>
   <td>The goal is to solve the problem, not to solve it in a complex way. Simpler solutions are in fact preferable, as they are less brittle and easier to deploy in real-world settings.
   </td>
  </tr>
  <tr>
   <td>The paper doesn't use [my preferred methodology], e.g., deep learning 
   </td>
   <td>NLP is an interdisciplinary field, relying on many kinds of contributions: models, resource, survey, data/linguistic/social analysis, position, and theory.
   </td>
  </tr>
  <tr>
   <td>The topic is too niche
   </td>
   <td>A main track paper may well make a big contribution to a narrow subfield.
   </td>
  </tr>
  <tr>
   <td>The approach is tested only on [not English], so unclear if it will generalize to other languages
   </td>
   <td>The same is true of NLP research that tests only on English. Monolingual work on any language is important both practically (methods and resources for that language) and theoretically (potentially contributing to deeper understanding of language in general).
   </td>
  </tr>
  <tr>
   <td>The paper has language errors
   </td>
   <td>As long as the writing is clear enough, better scientific content should be more valuable than better journalistic skills.
   </td>
  </tr>
  <tr>
   <td>The paper is missing the comparison to the [latest X]
   </td>
   <td>Per <a href="https://www.aclweb.org/adminwiki/index.php?title=ACL_Policies_for_Submission,_Review_and_Citation">ACL policy</a>, the authors are not obliged to draw comparisons with contemporaneous work, i.e., work published within three months before the submission (or three months before a re-submission). 
   </td>
  </tr>
  <tr>
   <td>The authors could also do [extra experiment X]
   </td>
   <td>It is always possible to come up with extra experiments and follow-up work. This is fair if the experiments that are already presented are insufficient for the claim that the authors are making. But any other extra experiments are in the “nice-to-have” category, and belong in the “suggestions” section rather than “weaknesses.”
   </td>
  </tr>
  <tr>
   <td>The authors should have done [X] instead 
   </td>
   <td>A.k.a. “I would have written a different paper.” There are often several valid approaches to a problem. This criticism applies only if the authors’ choices prevent them from answering <em>their</em> research question, their framing is misleading, or the question is not worth asking. If not, then [X] is a comment or a suggestion, but not a “weakness.” 
   </td>
  </tr>
</table>


If you have something like the above listed as a “weakness” of the paper, do try to revisit the paper with an open mind. Both the authors and the action editors will be aware of these guidelines. You may be asked to revisit your review. 

If you do not have anything like that explicitly listed as a weakness for the paper, look at your “overall assessment” score and check that your list of weaknesses actually justifies that score. If you have not found any major faults, but the score is low, this is a fairly good indicator that your review is not a faithful explanation of your recommendation. You may have a prototype, an idea of a typical research paper (determined by your own type of research), and that prototype serves as a mental baseline. If an average paper of that type would get a score of “3” from you, the papers that are not conforming to that prototype might have to work _harder_ to also get a “3”.


### 7. Check for (lack of) enthusiasm 

Perhaps the trickiest source of bias is our own research agenda. Of course, we cannot be equally enthusiastic about everything, and are likely to be more excited and supportive of the papers that pursue the same direction as ourselves. Still, fundamentally, the editorial acceptance decisions are up to the program chairs, and our reviews should be as objective as possible. If this submission is not your favorite kind of research, ask yourself: are there other people who would be excited about it? Would _they_ like to see it at the conference?

This matters particularly to ARR, where the reviews made before the commitment deadline to one conference may end up in a different conference or in a workshop, possibly with very different editorial priorities and policies. As reviewers, we do not know beforehand what all the different program chairs will be looking for. Our job is only to provide them with an objective assessment of thoroughness and potential impact of research, as best as we can. As long as you believe that the direction of the paper is overall beneficial to NLP research, try to give it as much enthusiasm as you would like to receive from the authors as reviewers for _your_ papers.


### 8. Check the framing 

Above all, a good review should be professional and neutral, if not kind. Try **not **to think of it as a task of eliminating as many papers as possible, but as a task of identifying good research and helping authors improve their papers. As an anonymous reviewer, you are in the position of power, and the written medium makes it easier to be more dismissive and sarcastic than if you were communicating with the authors face-to-face. 

You may well be addressing someone who is only starting on the research path. And/or someone struggling with stress and other mental health issues. And/or someone who has been less lucky with their school and advisors. Academic lives are already stressful enough, and we do not need to inflict extra damage to the mental health of our colleagues with sarcastic or insulting reviews. [Write the review you would like to get yourself.](https://www.nature.com/articles/d41586-020-03394-y) 

The fact is, authors and reviewers _are_ actually the same people: the conference crowd lining up for coffee, happily chatting with each other about the grand problems of AI even if they do not always agree. Why can’t we do peer review in the same spirit of fun intellectual interaction with colleagues? 

Just like the conference coffee break chats, reviewing is in fact mutually beneficial: in exchange for feedback, the reviewers get to have the first look at cutting-edge research. Just like the coffee breaks, where you do not necessarily meet only the people working in your subsubfield, peer review may expose you to new techniques. Since there is careful written communication in the authors’ response, you may even find that you were wrong about something, which is a much faster way to learn than making the same mistake in your own research.

Not to mention, someone out there is reviewing your papers too. The more bad reviews there are, the more of a norm they become, and the higher the chances you will get one yourself in the future.


## Discussion period 

In ARR the reviewer discussion happens _before_ the reviews are sent to the authors. If your action editor initiates the forum discussion, please participate. The goal here is to catch any mistakes, misunderstandings, or violations of the reviewer guidelines. 

When you see the reviews by the other reviewers, be aware that they may affect your own judgment in several ways simply because of social psychology effects. If you pointed out a weakness and then saw it also pointed out by someone else, you may feel it is a more severe problem than you originally thought. You may “discard” your own opinion if you see the opinion of someone you believe to be more senior/experienced/famous. If your original opinion was very positive, in the face of a strongly negative review you may be tempted to “converge to the mean.” Ask yourself if this is really warranted. Strong disagreements may be an indication that the paper is doing something unusual and interesting.


## Resubmissions 

If after the review phase the authors decide to revise the manuscript rather than commit it to a publication venue, your action editor will ask you to reconsider the case. You will see the authors' response, typically listing the changes they made, and the new version of the paper. You will need to revise your review and scores.

It is because of this stage that it is of utmost importance that in the first review you are very clear about what kinds of improvements you want, and how much of a difference they would make. If the authors are asked to perform a lot of extra experiments, but you fundamentally dislike the paper to the extent that nothing they could do would considerably change your opinion, this is not a good use of everybody’s time and resources.

## Changelog 

Version 0.1, 02.11.2021: initial public release. 

## Acknowledgements 

v.0.1: comments and corrections by Aurélie Névéol, Amanda Stent, Sebastian Riedel, Preslav Nakov.

## Resources  

**General peer review process**

EACL 2021 tutorial on peer review, pt. II - The Actual Review (Karën Fort): [slideslive](https://slideslive.com/38955744), [slides](https://github.com/reviewingNLP/EACL2021T5/blob/main/EACL_2021_pt2_theActualReview.pdf)

**General advice and reviewing philosophy**

* Advice on peer review from Mirella Lapata, Marco Baroni, Yoav Artzi, Emily M.Bender, Joel Tetreault, Ani Nenkova, Tim Baldwin: [https://acl2017.wordpress.com/2017/02/23/last-minute-reviewing-advice/ ](https://aclrollingreview.org/mentorship/ACL%202017%20leaders%20view%20on%20reviewing)
* A podcast interview with Noah Smith: [https://soundcloud.com/nlp-highlights/77-on-writing-quality-peer-reviews-with-noah-a-smith](https://aclrollingreview.org/mentorship/A%20podcast%20by%20Noah%20Smith%20about%20peer%20reviews)
* Rebekah Baglini and Christine Parsons on how to avoid harsh language in peer review: [https://www.nature.com/articles/d41586-020-03394-y](https://www.nature.com/articles/d41586-020-03394-y) 

**Examples of good reviews**

* Two examples of peer review from NAACL 2018: [https://naacl2018.wordpress.com/2018/01/20/a-review-form-faq/ ](https://aclrollingreview.org/mentorship/Two%20example%20good%20reviews%20from%20NAACL%202018%20presented%20in%20their%20reviewing%20form)

**Reviewing specific aspects of papers**

* Jesse Dodge and Noah Smith on the reproducibility checklist: [https://2020.emnlp.org/blog/2020-05-20-reproducibility/](https://2020.emnlp.org/blog/2020-05-20-reproducibility/) 
* EACL 2021 tutorial on peer review, pt. III - Reviewing Results Section (Kevin Cohen): [slideslive](https://slideslive.com/38955745), [slides](https://github.com/reviewingNLP/EACL2021T5/blob/main/EACL_2021_pt3_resultsSection.pdf)
* EACL 2021 tutorial on peer review, pt. IV - Reviewing Conclusion Section (Kevin Cohen): [slideslive](https://slideslive.com/38955752/), [slides](https://github.com/reviewingNLP/EACL2021T5/blob/main/EACL_2021_pt4_conclusionSection.pdf)

**Reviewing different types of papers**

* COLING 2018 review form for different paper types has great questions to ask yourself when reviewing engineering, resource, reproduction, survey and computational linguistics papers: [http://coling2018.org/paper-types/](http://coling2018.org/paper-types/) 
* Anna Rogers. Peer review in NLP: reject-if-not-SOTA [https://hackingsemantics.xyz/2020/reviewing-models/](https://aclrollingreview.org/mentorship/Reject%20if%20not%20SOTA?)
* Anna Rogers. Peer review in NLP: resource papers [https://hackingsemantics.xyz/2020/reviewing-data/](https://hackingsemantics.xyz/2020/reviewing-data/) 

**Cognitive and social biases in peer review**

* Anna Rogers, Isabelle Augenstein. What can we do to improve peer review in NLP? [https://aclanthology.org/2020.findings-emnlp.112/](https://aclanthology.org/2020.findings-emnlp.112/) 
* EACL 2021 tutorial on peer review, pt. V: Reviewer Biases (Anna Rogers): [slideslive](https://slideslive.com/38955745), [slides](https://github.com/reviewingNLP/EACL2021T5/blob/main/EACL_2021_pt5_biases.pdf)
* EACL 2021 tutorial on peer review, pt. VI:  Anonymity in Peer Review (Anna Rogers): [slideslive](https://slideslive.com/38955746), [slides](https://github.com/reviewingNLP/EACL2021T5/blob/main/EACL_2021_pt6_anonymity.pdf)

**Ethics **

* NAACL 2021 Ethics FAQ: [https://2021.naacl.org/ethics/faq/](https://2021.naacl.org/ethics/faq/) 
* EACL 2021 tutorial on peer review, pt. VII - Ethics and Reviewing (Aurélie Névéol): [slideslive](https://slideslive.com/38955747), [slides](https://github.com/reviewingNLP/EACL2021T5/blob/main/EACL_2021_pt7_ethics.pdf)
* Just what do you think you're doing, Dave? A checklist for responsible data use in NLP. [https://arxiv.org/abs/2109.06598](https://arxiv.org/abs/2109.06598) 

## Notes

[^1]:
     The decision to also publish [Findings](https://2020.emnlp.org/blog/2020-04-19-findings-of-emnlp/) is currently taken by individual conferences.
