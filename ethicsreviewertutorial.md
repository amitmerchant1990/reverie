---
layout: page
title: "Guidelines for Ethics Reviewing"
permalink: /ethicsreviewertutorial
---

Section 1. Scope
-----------------

An ethics review is not a complete technical review. Your focus should be on addressing:
1. Are there any *substantial ethical issues* with the research presented in this submission? 
   1. A "substantial ethical issue" means the work exhibits an increased risk of harm outside the current norms of NLP or CL research. Of course, norms evolve. 
   2. Consider the paper, supplemental materials, and the ethics and reproducibility checklist completed by the authors; however, the paper should stand on its own. 
   3. Please keep in mind this is not a scientific review. Your focus is only on the ethical issues and their presentation. You do not need to check any equations, thoroughness of citations (except as they pertain to ethical issues), or provide any feedback on experimental design or grammar/typos/writing style.
2. If there are one or more ethical issues, describe each in terms of the [ACL code of ethics](https://www.aclweb.org/portal/content/acl-code-ethics). If you cannot describe the issue in terms of the ACL code of ethics, please consider whether this is something the community agrees is an issue. Please refrain from relying on regional or national laws, regulations or practices in your ethics review, since the submission may be from another country or region. What governs acceptable practice in *ACL venues is the ACL code of ethics. Bear in mind that notions of ethical behavior and practice vary over time and across cultures. If you have questions, please contact the ACL ethics committee.
3. For each ethical issue you identify, describe how you would suggest the authors address it.

Section 2. Examples
-----------------

For purposes of illustration, ethical issues that may arise in submissions to ARR include (but are not limited to; please refer to https://aclrollingreview.org/responsibleNLPresearch/): 
* Issues with the intended or potential __applications__ of the research (i.e., dual use), for example: 
  * Sections 1.1 (“Contribute to society and to human well-being, acknowledging that all people are stakeholders in computing”) and 1.2 (“Avoid harm”) - failure to consider how applications of the research may harm individuals, groups or society at large; failure to discuss ways to mitigate such harms.
  * Section 2.5 (“Give comprehensive and thorough evaluations of computer systems and their impacts, including analysis of possible risks”) - failure to consider other possible risks of applications of the research; failure to discuss ways to mitigate such risks.
* Issues with the __method__ or approach, for example:
  * Section 1.1 (“Contribute to society and to human well-being, acknowledging that all people are stakeholders in computing”) - failure to consider and ameliorate the negative impacts of the approach on the political, social, or natural environment.
  * Section 1.4 (“Be fair and take action not to discriminate“) - failure to consider and ameliorate biases that the approach may perpetuate
  * Section 2.5 (“Give comprehensive and thorough evaluations of computer systems and their impacts, including analysis of possible risks”) - failure to consider possible risks and impacts of the approach.
  * Section 2.9 (“Design and implement systems that are robustly and usably secure”) - failure to consider robustness and security, especially in papers about the development of systems close to or in production deployment.
* Issues with the use of __code__, __data__ and use of __people__, for example:
  * Section 1.6 (“Respect privacy”) - failure to obtain informed consent where required, or to protect personally identifiable information as required by relevant institutional ethics boards.
  * Section 1.5 (“Respect the work required to produce new ideas, inventions, creative works, and computing artifacts”) and 2.8 (“Access computing and communication resources only when authorized or when compelled by the public good”) - failure to respect intellectual property and data/code ownership; failure to cite the creators of artifacts used, or to use these artifacts in the ways intended (for example, violations of licenses).
  * Section 1.4 (“Be fair and take action not to discriminate“)  - failure to consider and ameliorate biases in the data, or biased code/model outputs.
  * Section 1.2 (“Avoid harm”) - failure to consider how the data, the code or other outcomes of the research may cause harm.
  * Section 3.3 (“Manage personnel and resources to enhance the quality of working life”) - failure to consider how the participation of people (e.g. annotators) in the research may cause benefits or harms to those individuals.
* Other issues, including __academic dishonesty__:
  * Sections 1.3 (“Be honest and trustworthy”), 1.7 (“Honor confidentiality”) and 2.1 (“Strive to achieve high quality in both the processes and products of professional work”) - dishonesty in the execution or presentation of the research, including plagiarism, deliberate violation of anonymity, citation, review, or duplicate submission policies, falsifying results, or misrepresentation (for example, claiming someone is a co-author when they are not).

Here are some example ethics reviews that adhere to the above guidelines:
* *The paper considers the analysis of data from a website that hosts user contributed posts. The authors obtain access to private data by using an account that  falsified information to deceive site moderators. The authors scrape the content of the site and release the resulting data, without removing personally identifiable information (including usernames). They do not obtain approval from the site owners or obtain informed consent from the site users. These practices violate the ACL code of ethics’ guidance to “Access computing and communication resources only when authorized or when compelled by the public good” and to “Respect privacy”. The authors are encouraged to (a) document whether and how they obtained permission to scrape and reshare the data; and (b) document how they will remove personally identifiable information from their dataset before releasing it.*
* *The authors fail to discuss ways in which their solution may cause harm to individuals or groups; specifically, in this case, ways in which their solution, if applied, would “out” people who are LGBTQIA, including potentially people who are not out, and potentially falsely “out” people who are not LGBTQIA. This has significant potential to cause harm, rather than contributing to society and to human well-being, as outlined in the ACL code of ethics. I don’t see any way for the authors to avoid these potential harms as their solution currently stands; the best they can do is to promise not to release their model, data and code.* (There are cultures and societies where being a member of one of these groups is against the law or considered to be immoral; however, an ethics reviewer in this case might refer the authors to the Universal Declaration of Human Rights).
* *The authors of this paper claim that their solution beats the performance of previous methods on a common benchmark dataset. To demonstrate the improvement, the authors reproduce a figure showing accuracy numbers of several methods from a previous paper. However, the authors include the figure without attribution and modify it to remove another method that obtains better results than their proposed method. Knowingly misrepresenting the work of others is a violation of the code of ethics (“Strive to achieve high quality in both the processes and products of professional work”). The authors should include all the relevant results with attribution.*

Here are some examples that do not adhere to the above guidelines:
* *The authors didn’t pay their annotators at least  £8.91 / hour, which is the minimum wage in the UK. This means they didn’t “Manage personnel and resources to enhance the quality of working life”.* (The minimum wage in the UK is not a global minimum wage. An ethics reviewer could inquire if the authors paid the annotators at least “a local living minimum wage”.)
* *There is no documentation of IRB approval for this research.* (The specific term “IRB” applies to research conducted by USA-based researchers or in the USA that has federal funding and involves human participants only. It is not a universal regulation. An ethics reviewer could ask, if the research involves human participants - particularly in a high stakes setting such as medical care - whether the authors had worked with an ethics review board.)
* *This work will lead to biases in how medical diagnoses are made.* (Good problem statement, but incomplete: what part of the ACL code of ethics is violated, and how might the authors address or correct this?)
* *This model achieves only 60% accuracy on this data set, even though the authors have deployed it in the educational system in their country. That means that they haven’t followed the ethical rule to “take special care of systems that become integrated into the infrastructure of society”. They should withdraw the model from use, or insist on a human in the loop at all times.* (Depending on the nature of the model, 60% accuracy may very well be state of the art, and the model may have documented utility even at that level of accuracy. If there is an issue of ethical practice here - and contemporary NLP researchers may disagree - the authors should perhaps discuss how they are going to mitigate the weaknesses of the model; a human in the loop is one possibility, but not the only one.)

__Acknowledgements:__ This document was drafted for ARR by Amanda Stent and reviewed and edited by the ARR Editors in Chief, Tim Baldwin, Anna Rogers, the NAACL 2022 ethics chairs Kai-Wei Chang and Diyi Yang, and members of the [ACL Ethics Committee](https://www.aclweb.org/adminwiki/index.php?title=Formation_of_the_ACL_Ethics_Committee). 
