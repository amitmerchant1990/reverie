---
layout: page
title: "FAQ For Reviewers and Action Editors"
permalink: /reviewerfaq
---

This FAQ is intended to help reviewers and action editors navigate OpenReview and the review process. Please direct inquiries to: `support@aclrollingreview.org`

## Timeline

### What is the timeline?
- Days 1-7: AEs are assigned end AEs assign reviewers/desk reject, no notifications go out
- Day 7: Notifications to reviewers go out (automatically)
- Day 30: Reviews are submitted
- Day 35: Meta-Review submitted
- Day 35: Reviews released to authors

## Communication

### How do I modify reviewer assignments?

See [this guide](https://docs.google.com/document/d/e/2PACX-1vR8HCF9siBpZsQms0cIv0weK7CXAf7AE3Cxwq3wYIJYuRioRf0SaZcl93oQZXsqoA_aEwZNMzu-cYr5/pub) from NeurIPS 2021.

### Who contacts reviewers to kick off reviewing?
The editor-in-chief email all reviewers to kick off reviewing. 

### How can I communicate with reviewers?
You may communicate with reviewers using the discussion forum. In OpenReview, you should see a button labeled "Official Comment"
at the top of the paper forum. Click on it to open a message form. You can also select to exclusively message certain sub-groups, e.g. only reviewer 2.  

### How can I communicate with the action editor?
In OpenReview, you should see a button labeled "Official Comment" at the top of the paper forum. Click on it to open a message form. 
For messaging exclusively the action editors, please select only "area chairs" in the "Readers" field of the form.

### How do I communicate to the editors in chief that I am unavailable in a given month?
We hope that in Q3 2021 OpenReview will roll out their v2 API, and we hope that API will allow us to create a button or other functionality whereby
you can move yourself from "reviewers unavailable" to "action editor available" and back. For now, if you are unavailable in a month, email editors@aclrollingreview.org.

## Desk Rejects

### One of my assigned submissions uses a workshop / conference template rather than the ARR template. What should I do? 
Please inform the action editors. After the trial period for ARR is over this will be a desk reject.

### One of my assigned submissions is more than four pages but less than eight pages in length. What should I do?
Treat it as a long paper submission.

### Can the ethics statement extend into a 5th/9th page?
Yes. 

### What is the compliance checklist?
- Is the content of this paper appropriate to a *ACL venue?
- Is the paper in English?
- Does this paper use the ARR template?
- Does this paper adhere to length constraints for the paper type (long: 8, short: 4, in both cases exclusive of references and appendices)?
- Is the submission (including paper and any supplemental materials) anonymized?
- Is this paper already published elsewhere?


### How do I actually desk reject a submission?
In OpenReview, you should see a button labeled "Desk Reject".

## Reviewer Assignments

### In what order are alternative reviewers for a submission displayed (eg alphabetical, by match score, random)?
We are working on this.

### Can we see the number of submissions a reviewer is already assigned?
We are working on this.

### Can we see author information?
No, we are managing a two-way anonymized process up through action editors. It is not possible for you to assign a reviewer who has a COI that is automatically identifiable.


### Meta-Reviewing

### How do I enter a meta-review?
Click on the button in the system.

### Why can I not press the "meta-review" button?
The meta-review button may not be clickable if not all reviews are submitted yet. In this case, please try to encourage the reviewers to submit their reviews, or recruit a new emergency reviewer.

### How do I flag a submission for ethics review?
Please email the action editors.

### How do I view/reassign reviewers?
Go to the area chair console (e.g. the following for [September](https://openreview.net/group?id=aclweb.org/ACL/ARR/2021/September/Area_Chairs)) and click the link "Modify Reviewer Assignments" at the top of the page. From there you should be able to click on the "assignments" button for each of your papers, and get an ordered list of reviewers who you can assign.

### Why was I assigned to be a reviewer for a paper where I'm an action editor?	
This was a bug in our assignment in the September iteration. Apologies, and we'll fix this in October. For the time being, please unassign yourself and assign someone else.

## Other Questions

### Does automatic review assignment check if the reviewer is an action editor?	
We hope that action editors will also be able to serve as reviewers in some cases, as action editors are often the most experienced members of our community who can provide high-quality reviews on some topics. However, when we assign papers we will attempt to balance your load so the overall load of action-edited and reviewed papers is manageable.

### Is the list of ARR action editors published somewhere?	
Yes, see [here](https://aclrollingreview.org/about/people).

### Should I assign and invite someone else to review a declined paper?	
Yes, and you can do this by clicking through to "Modify Reviewer Assignments" from the Area Chair Console.

### I got 4 papers. Should I expect this load in the future?
The average monthly load for reviewers should be much closer to 2, but in certain periods (close to large conferences),
it's possible that the load is higher.

### Am I expected to accept all invitations? or should I select a subset that I am most interested in?	
You are free to decline to review papers, but keep in mind that ARR will be the sole reviewing process for ACL/NAACL in 2022, so a) you won't get separate review requests from conference organizers, and b) the volume should come down in the following months.

### Why did I get an invitation to review something when the deadline is already past?
It is possible that an AE may send as an emergency review request for one of the prior month submissions that we're running late with. There is no strict deadline, but the sooner you could provide the review, the better.

### If I submit a paper before the 10/15 deadline and submit the revised version before the 12/15 deadline, does the revised version influence the ACL decision, and if so, how? 	
The important thing to notice is that ARR doesn't provide accept/reject decisions. You only get the reviews. If you get your reviews by the time of the commitment date of a venue, you can then commit to that venue if you'd like. If you submit a revision to ARR at Dec 15, 2021, it is highly unlikely that you'll get the reviews for the revision by Jan 7, 2022, which is the ACL 22 commitment deadline -- so in that case you'll only have the option of committing your first version (presumably submitted to ARR in October) with the first set of reviews.

### I got a review invitation that I’d like to decline, but when I click the decline button, I get the following error message on Openreview: "Wrong key, please refer back to the recruitment email." What do I have to do to be able to accept/decline invitations? Is this a known problem?"	
This is a known issue as the link (as opposed to the link *text*) uses %-encoding for umlauts (or even any non-ASCII characters). Openreview currently send emails in plain text and they are planning to send them in HTML format with all the links already translated, We hope that will solve the problem.
