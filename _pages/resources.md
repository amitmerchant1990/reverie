---
layout: page
title: Resources for SEA
permalink: /resources/
---

Southeast Asia is home to more than 1,000 native languages. Nevertheless, Southeast Asian NLP, vision-language, and speech processing is underrepresented in the research community, and one of the reasons is the lack of access to public datasets ([Aji et al., 2022](https://aclanthology.org/2022.acl-long.500/)).
It is essential to greatly increase the accessibility of SEA datasets, promote research in SEA languages and cultures, as well as build more AI models that represent SEA.

We consolidate a [comprehensive resource hub](https://seacrowd.github.io/seacrowd-catalogue/) that fills the resource gap by [providing standardized corpora](https://github.com/SEACrowd/seacrowd-datahub) in nearly 1,000 Southeast Asian (SEA) languages across three modalities. Find their standardized dataloaders [here](https://github.com/SEACrowd/seacrowd-datahub).

Furthermore, we also build [SEACrowd benchmarks](https://github.com/SEACrowd/seacrowd-experiments) to assess the quality of AI models on 36 indigenous languages across 13 tasks, offering valuable insights into the current AI landscape in SEA. Furthermore, we propose strategies to facilitate greater AI advancements, maximizing potential utility and resource equity for the future of AI in SEA.

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

## Evaluation Results

More details in [SEACrowd Experiments](https://github.com/SEACrowd/seacrowd-experiments).

#### LLMs
<img width="900" alt="NLP Performance" src="https://github.com/SEACrowd/seacrowd-experiments/blob/main/assets/eval-nlp.png?raw=true">

#### Speech Models
<img width="500" alt="Speech Performance" src="https://github.com/SEACrowd/seacrowd-experiments/blob/main/assets/eval-speech.png?raw=true">

#### VLMs
<img width="500" alt="VL Performance" src="https://github.com/SEACrowd/seacrowd-experiments/blob/main/assets/eval-vl.png?raw=true">

## Generation Quality in SEA Languages: Translationese vs. Natural

### Naturalness Result

<img width="500" alt="Naturalness Result" src="https://github.com/SEACrowd/seacrowd-experiments/blob/main/assets/naturalness-result.png?raw=true">

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
