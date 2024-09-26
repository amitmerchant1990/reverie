---
layout: page
title: Resources for SEA
permalink: /resources/
---

Southeast Asia is home to more than 1,000 native languages. Nevertheless, Southeast Asian NLP, vision-language, and speech processing is underrepresented in the research community, and one of the reasons is the lack of access to public datasets ([Aji et al., 2022](https://aclanthology.org/2022.acl-long.500/)).
It is essential to greatly increase the accessibility of SEA datasets, promote research in SEA languages and cultures, as well as build more AI models that represent SEA.

We consolidate a comprehensive resource hub, [**SEACrowd Catalogue**](https://seacrowd.github.io/seacrowd-catalogue/) that fills the resource gap in nearly 1,000 Southeast Asian (SEA) languages across three modalities. Find their standardized dataloaders in the [**SEACrowd Data Hub**](https://github.com/SEACrowd/seacrowd-datahub).

Furthermore, we also build the [**SEACrowd Benchmarks**](https://github.com/SEACrowd/seacrowd-experiments) to assess the quality of AI models on 36 indigenous languages across 13 tasks, offering valuable insights into the current AI landscape in SEA. Furthermore, we propose strategies to facilitate greater AI advancements, maximizing potential utility and resource equity for the future of AI in SEA.

> Check out [our "SEACrowd: A Multilingual Multimodal Data Hub and Benchmark Suite for Southeast Asian Languages" paper](https://arxiv.org/pdf/2406.10118)!

## Quick Start

| URL | Description |
|------------------|---------------------|
| [Paper](https://arxiv.org/pdf/2406.10118) | Our "SEACrowd: A Multilingual Multimodal Data Hub and Benchmark Suite for Southeast Asian Languages" paper on Arxiv |
| [Landing Page](https://github.com/SEACrowd) | Introduction to SEACrowd |
| SEACrowd Catalogue ([web](https://seacrowd.github.io/seacrowd-catalogue/)/[csv](https://docs.google.com/spreadsheets/d/1ibbywsC1tQ_sLPX8bUAjC-vrTrUqZgZA46W_sxWw4Ss/edit?usp=sharing)) | Centralized publicly available datasheets |
| SEACrowd Data Hub ([github](https://github.com/SEACrowd/seacrowd-datahub/)/[pip](https://pypi.org/project/seacrowd/)) | Standardized dataloaders & schema library |
| [SEACrowd Experiments](https://github.com/SEACrowd/seacrowd-experiments) | Experiment repository for SEACrowd NLP, VL, & speech benchmarks, translationese vs. naturalness assessment, language equity, language prioritization, etc. |
| [HuggingFace Collection](https://huggingface.co/collections/SEACrowd/seacrowd-a-multilingual-multimodal-data-hub-and-benchmark-s-667127ad938266072cdc46be) | Our fine-tuned translationese classifier & train/test data |

## How do current LLMs, VLMs, & speech models perform in SEA languages?

More details in [SEACrowd Experiments](https://github.com/SEACrowd/seacrowd-experiments).

#### LLMs
<img width="900" alt="NLP Performance" src="https://github.com/SEACrowd/seacrowd-experiments/blob/main/assets/eval-nlp.png?raw=true">

#### Speech Models
<img width="500" alt="Speech Performance" src="https://github.com/SEACrowd/seacrowd-experiments/blob/main/assets/eval-speech.png?raw=true">

#### VLMs
<img width="500" alt="VL Performance" src="https://github.com/SEACrowd/seacrowd-experiments/blob/main/assets/eval-vl.png?raw=true">

## LLM Generation Quality in SEA Languages: Translationese vs. Natural

### Naturalness Result

<img width="500" alt="Naturalness Result" src="https://github.com/SEACrowd/seacrowd-experiments/blob/main/assets/naturalness-result.png?raw=true">

## Contributing to SEACrowd Catalogue & Data Hub

Everyone can join and contribute to this initiative.

### 🗃️ Task 1: Submitting Datasheet for Existing Public Datasets

You can submit detailed metadata for existing datasets through [this form](https://form.jotform.com/team/232952680898069/seacrowd-sea-datasets). You will provide important information such as data license, size, language and dialect, annotation method, and so on. The approved datasheets as well as under review datasheets will show up and indexed in SEACrowd Catalogue ([web](https://seacrowd.github.io/seacrowd-catalogue/)/[csv](https://docs.google.com/spreadsheets/d/1ibbywsC1tQ_sLPX8bUAjC-vrTrUqZgZA46W_sxWw4Ss/edit?usp=sharing)).

### 🖥️ Task 2: Building DataLoader

From the approved datasheets from the previous task, you can help us build HuggingFace’s dataset dataloader to ensure that all datasets in SEACrowd are standardized in terms of formatting. You can take a look at the [dataloader guide](https://github.com/SEACrowd/seacrowd-datahub/blob/master/DATALOADER.md) and [examples](https://github.com/SEACrowd/seacrowd-datahub/tree/master/seacrowd/sea_datasets) in [SEACrowd Data Hub](https://github.com/SEACrowd/seacrowd-datahub). We will also ping the taken dataloader issues after 2 weeks of inactivity in case there's any trouble.

#### Is there any other way to help?

For sure. You can [contact us](https://seacrowd.github.io/contact/) to learn about the details.

## Citation

If you are using any resources from SEACrowd, including datasheets, dataloaders, code, etc., please cite [the following publication](https://arxiv.org/pdf/2406.10118):

```
@article{lovenia2024seacrowd,
      title={SEACrowd: A Multilingual Multimodal Data Hub and Benchmark Suite for Southeast Asian Languages}, 
      author={Holy Lovenia and Rahmad Mahendra and Salsabil Maulana Akbar and Lester James V. Miranda and Jennifer Santoso and Elyanah Aco and Akhdan Fadhilah and Jonibek Mansurov and Joseph Marvin Imperial and Onno P. Kampman and Joel Ruben Antony Moniz and Muhammad Ravi Shulthan Habibi and Frederikus Hudi and Railey Montalan and Ryan Ignatius and Joanito Agili Lopo and William Nixon and Börje F. Karlsson and James Jaya and Ryandito Diandaru and Yuze Gao and Patrick Amadeus and Bin Wang and Jan Christian Blaise Cruz and Chenxi Whitehouse and Ivan Halim Parmonangan and Maria Khelli and Wenyu Zhang and Lucky Susanto and Reynard Adha Ryanda and Sonny Lazuardi Hermawan and Dan John Velasco and Muhammad Dehan Al Kautsar and Willy Fitra Hendria and Yasmin Moslem and Noah Flynn and Muhammad Farid Adilazuarda and Haochen Li and Johanes Lee and R. Damanhuri and Shuo Sun and Muhammad Reza Qorib and Amirbek Djanibekov and Wei Qi Leong and Quyet V. Do and Niklas Muennighoff and Tanrada Pansuwan and Ilham Firdausi Putra and Yan Xu and Ngee Chia Tai and Ayu Purwarianti and Sebastian Ruder and William Tjhi and Peerat Limkonchotiwat and Alham Fikri Aji and Sedrick Keh and Genta Indra Winata and Ruochen Zhang and Fajri Koto and Zheng-Xin Yong and Samuel Cahyawijaya},
      year={2024},
      eprint={2406.10118},
      journal={arXiv preprint arXiv: 2406.10118}
}
```
