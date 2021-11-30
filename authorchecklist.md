---
layout: page
title: "Author Checklist"
permalink: /authorchecklist
---

## OpenReview Profiles

All authors must have complete OpenReview profiles. Please ensure profiles are complete before submission. You may refer to [this tutorial](https://docs.google.com/presentation/d/1kJeoAfwbnFapUN0ySLSoOm11-2odz48DGS1DEzNs03k/edit?usp=sharing).

## Paper Format

The template both exemplifies and contains paper format guidelines. These are also available [here](https://acl-org.github.io/ACLPUB/formatting.html).

For ARR submissions, references and appendices should be included in the pdf for the paper, but do not count towards the page limit.

Some key items for first time authors:
- Use the template
- Respect the page limit for the paper type
- Ensure the submission is anonymized

## Anonymization and Citation

Please refer to [this page](https://www.aclweb.org/adminwiki/index.php?title=ACL_Policies_for_Submission,_Review_and_Citation) for the ACL policies for submission, review and citation. Most of this information is also covered in the template and format guidelines linked above.

## Reproducibility

The below reproducibility checklist is provided to help authors improve the reproducibility of their work; submissions are not required to meet all criteria listed and the list of criteria is not exhaustive. This checklist is based on the one from ACL-IJCNLP 2021, which in turn is based on previous versions from NAACL-HLT 2021 and previous versions from [Dodge and Smith](https://2020.emnlp.org/blog/2020-05-20-reproducibility) and [Pineau](https://www.cs.mcgill.ca/~jpineau/ReproducibilityChecklist.pdf).

The paper should include:
- For all reported experimental results:
  - A clear description of the mathematical setting, algorithm, and/or model
  - A link to (anonymized, for submission) downloadable source code, with specification of all dependencies, including external libraries
  - A description of the computing infrastructure used
  - The average runtime for each model or algorithm, or estimated energy cost
  - The number of parameters in each model
  - Corresponding validation performance for each reported test result
  - A clear definition of the specific evaluation measure or statistics used to report results

- For all results involving multiple experiments, such as hyperparameter search:
  - The exact number of training and evaluation runs
  - The bounds for each hyperparameter
  - The hyperparameter configurations for best-performing models
  - The method of choosing hyperparameter values (e.g., manual tuning, uniform sampling, etc.) and the criterion used to select among them (e.g., accuracy)
  - Summary statistics of the results (e.g., mean, variance, error bars, etc.)

- For all datasets used:
  - Relevant statistics such as number of examples and label distributions
  - Details of train/validation/test splits
  - An explanation of any data that were excluded, and all pre-processing steps
  - For natural language data, the name of the language(s)
  - A link to a downloadable version of the dataset or simulation environment
  - For new data collected, a complete description of the data collection process, such as ownership / licensing, informed consent, instructions to annotators and methods for quality control

Authors are encouraged to include [data sheets](https://www.microsoft.com/en-us/research/uploads/prod/2019/01/1803.09010.pdf) and [model cards](https://dl.acm.org/doi/abs/10.1145/3287560.3287596) in supplemental material, as appropriate.

## Ethics

Authors are encouraged to include in the paper a statement of [ethical considerations](https://www.aclweb.org/adminwiki/index.php?title=ACL_Resolutions#March_5.2C_2020), including those related to collection and annotation of data and considerations of bias, potential for misuse or harm to vulnerable populations relating to any research results.


We encourage authors to consult the following checklist, taken from the [NAACL 2021 ethical review questions](https://2021.naacl.org/ethics/review-questions/)


For papers presenting new datasets:

- Does the paper describe how intellectual property (copyright, etc) was respected in the data collection process?
- Does the paper describe how participants’ privacy rights were respected in the data collection process?
- Does the paper describe how crowd workers or other annotators were fairly compensated and how the compensation was determined to be fair?
- Does the paper indicate that the data collection process was subjected to any necessary review by an appropriate review board?

For papers presenting new datasets AND papers presenting experiments on existing datasets:

- Does the paper describe the characteristics of the dataset in enough detail for a reader to understand which speaker populations the technology could be expected to work for?
- Do the claims in the paper match the experimental results, in terms of how far the results can be expected to generalize?
- Does the paper describe the steps taken to evaluate the quality of the dataset?

For papers concerning tasks beyond language-internal matters:

- Does the paper describe how the technology would be deployed in actual use cases?
- Does the task carried out by the computer match how it would be deployed?
- Does the paper address possible harms when the technology is being used as intended and functioning correctly?
- Does the paper address possible harms when the technology is being used as intended but giving incorrect results?
- Does the paper address possible harms following from potential misuse of the technology?

If the system learns from user input once deployed, does the paper describe checks and limitations to the learning?

- Are any of the possible harms you’ve identified likely to fall disproportionately on populations that already experience marginalization or are otherwise vulnerable?
- For papers using identity characteristics (e.g. gender, race, ethnicity) as variables:
- Does the paper use self-identifications (rather than attributing identity characteristics to participants)?
- Does the paper motivate the range of values used for identity characteristics in terms of how they relate to the research question?
- Does the paper discuss the ethical implications of categorizing people, either in training datasets or in the deployment of the technology?
