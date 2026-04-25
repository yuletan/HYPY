# Model Test Report

- Generated at: `2026-04-25 10:04:33`
- Output file: `C:\Users\Lenovo\Downloads\Han Yu Pin Yin\modeltest.md`
- Images: `1730196408827jp.png`, `The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp`, `o08000924109524428441jp.jpg`, `weibo_6_toutiao_comparison.jpg`, `weibo_kol_1.jpg`
- Vision models: `baidu/qianfan-ocr-fast:free`, `qwen/qwen3-vl-30b-a3b-instruct`, `nvidia/nemotron-nano-12b-v2-vl:free`
- Text models: `inclusionai/ling-2.6-flash:free`, `nvidia/nemotron-3-nano-30b-a3b:free`
- Input-language scenarios per image: `auto` plus the matching explicit hint (`zh` or `ja`)
- Output language: `en`

## Summary

| Vision | Text | Runs | Analyze % | Explain % | Auto Lang % | Sentence % | Glossary % | Avg analyze s | Avg stage tokens | Avg t/s |
| --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| `baidu/qianfan-ocr-fast:free` | `inclusionai/ling-2.6-flash:free` | 10 | 80.00 | 80.00 | 20.00 | 100.00 | 87.50 | 164.57 | 36932.88 | 183.87 |
| `baidu/qianfan-ocr-fast:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 10 | 50.00 | 40.00 | 20.00 | 100.00 | 100.00 | 257.08 | 56333.80 | 194.87 |
| `nvidia/nemotron-nano-12b-v2-vl:free` | `inclusionai/ling-2.6-flash:free` | 10 | 40.00 | 40.00 | 40.00 | 100.00 | 75.00 | 198.20 | 23483.00 | 102.37 |
| `nvidia/nemotron-nano-12b-v2-vl:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 10 | 30.00 | 30.00 | 20.00 | 100.00 | 100.00 | 482.16 | 44373.67 | 77.02 |
| `qwen/qwen3-vl-30b-a3b-instruct` | `inclusionai/ling-2.6-flash:free` | 10 | 0.00 | 0.00 | 0.00 | 0.00 | 0.00 | n/a | n/a | n/a |
| `qwen/qwen3-vl-30b-a3b-instruct` | `nvidia/nemotron-3-nano-30b-a3b:free` | 10 | 0.00 | 0.00 | 0.00 | 0.00 | 0.00 | n/a | n/a | n/a |

## Scenario Table

| Image | Expected | Toggle | Vision | Text | Analyze | Explain | Detected | Sentences | Glossary | Analyze s | Explain s | Stage tokens | t/s |
| --- | --- | --- | --- | --- | --- | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: |
| 1730196408827jp.png | ja | `auto` | `baidu/qianfan-ocr-fast:free` | `inclusionai/ling-2.6-flash:free` | 200 | 200 | `ja` | 32 | 28 | 181.29 | 1.44 | 40449 | 194.10 |
| 1730196408827jp.png | ja | `ja` | `baidu/qianfan-ocr-fast:free` | `inclusionai/ling-2.6-flash:free` | 200 | 200 | `ja` | 14 | 25 | 165.87 | 1.43 | 37767 | 204.87 |
| o08000924109524428441jp.jpg | ja | `auto` | `baidu/qianfan-ocr-fast:free` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 283.85 | n/a | 32768 | 100.91 |
| o08000924109524428441jp.jpg | ja | `ja` | `baidu/qianfan-ocr-fast:free` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 679.72 | n/a | 83664 | 104.42 |
| The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | `auto` | `baidu/qianfan-ocr-fast:free` | `inclusionai/ling-2.6-flash:free` | 200 | 200 | `zh-Hant` | 78 | 97 | 176.62 | 1.56 | 44069 | 205.56 |
| The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | `zh` | `baidu/qianfan-ocr-fast:free` | `inclusionai/ling-2.6-flash:free` | 200 | 200 | `zh-Hant` | 22 | 97 | 339.57 | 1.86 | 62099 | 160.04 |
| weibo_6_toutiao_comparison.jpg | zh | `auto` | `baidu/qianfan-ocr-fast:free` | `inclusionai/ling-2.6-flash:free` | 200 | 200 | `zh-Hans` | 2 | 36 | 176.95 | 1.39 | 42193 | 196.06 |
| weibo_6_toutiao_comparison.jpg | zh | `zh` | `baidu/qianfan-ocr-fast:free` | `inclusionai/ling-2.6-flash:free` | 200 | 200 | `zh-Hans` | 27 | 2 | 199.61 | 1.13 | 42894 | 183.01 |
| weibo_kol_1.jpg | zh | `auto` | `baidu/qianfan-ocr-fast:free` | `inclusionai/ling-2.6-flash:free` | 200 | 200 | `zh-Hans` | 10 | 0 | 39.54 | 2.12 | 12967 | 123.52 |
| weibo_kol_1.jpg | zh | `zh` | `baidu/qianfan-ocr-fast:free` | `inclusionai/ling-2.6-flash:free` | 200 | 200 | `zh-Hans` | 26 | 47 | 37.15 | 1.77 | 13025 | 167.41 |
| 1730196408827jp.png | ja | `auto` | `baidu/qianfan-ocr-fast:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 200 | 502 | `ja` | 32 | 28 | 387.98 | 198.31 | 58415 | 134.72 |
| 1730196408827jp.png | ja | `ja` | `baidu/qianfan-ocr-fast:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 200 | 200 | `ja` | 14 | 25 | 317.76 | 8.60 | 76065 | 227.67 |
| o08000924109524428441jp.jpg | ja | `auto` | `baidu/qianfan-ocr-fast:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 563.82 | n/a | 50899 | 75.45 |
| o08000924109524428441jp.jpg | ja | `ja` | `baidu/qianfan-ocr-fast:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 0.69 | n/a | n/a | n/a |
| The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | `auto` | `baidu/qianfan-ocr-fast:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 0.76 | n/a | n/a | n/a |
| The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | `zh` | `baidu/qianfan-ocr-fast:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 0.62 | n/a | n/a | n/a |
| weibo_6_toutiao_comparison.jpg | zh | `auto` | `baidu/qianfan-ocr-fast:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 1.82 | n/a | n/a | n/a |
| weibo_6_toutiao_comparison.jpg | zh | `zh` | `baidu/qianfan-ocr-fast:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 200 | 200 | `zh-Hans` | 10 | 29 | 429.05 | 7.21 | 98262 | 213.18 |
| weibo_kol_1.jpg | zh | `auto` | `baidu/qianfan-ocr-fast:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 200 | 200 | `zh-Hans` | 8 | 49 | 84.88 | 315.62 | 26178 | 222.44 |
| weibo_kol_1.jpg | zh | `zh` | `baidu/qianfan-ocr-fast:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 200 | 200 | `zh-Hans` | 10 | 38 | 65.73 | 7.16 | 22749 | 236.53 |
| 1730196408827jp.png | ja | `auto` | `qwen/qwen3-vl-30b-a3b-instruct` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 0.63 | n/a | n/a | n/a |
| 1730196408827jp.png | ja | `ja` | `qwen/qwen3-vl-30b-a3b-instruct` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 0.69 | n/a | n/a | n/a |
| o08000924109524428441jp.jpg | ja | `auto` | `qwen/qwen3-vl-30b-a3b-instruct` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 0.39 | n/a | n/a | n/a |
| o08000924109524428441jp.jpg | ja | `ja` | `qwen/qwen3-vl-30b-a3b-instruct` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 0.31 | n/a | n/a | n/a |
| The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | `auto` | `qwen/qwen3-vl-30b-a3b-instruct` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 0.49 | n/a | n/a | n/a |
| The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | `zh` | `qwen/qwen3-vl-30b-a3b-instruct` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 0.39 | n/a | n/a | n/a |
| weibo_6_toutiao_comparison.jpg | zh | `auto` | `qwen/qwen3-vl-30b-a3b-instruct` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 0.46 | n/a | n/a | n/a |
| weibo_6_toutiao_comparison.jpg | zh | `zh` | `qwen/qwen3-vl-30b-a3b-instruct` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 0.45 | n/a | n/a | n/a |
| weibo_kol_1.jpg | zh | `auto` | `qwen/qwen3-vl-30b-a3b-instruct` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 0.35 | n/a | n/a | n/a |
| weibo_kol_1.jpg | zh | `zh` | `qwen/qwen3-vl-30b-a3b-instruct` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 0.29 | n/a | n/a | n/a |
| 1730196408827jp.png | ja | `auto` | `qwen/qwen3-vl-30b-a3b-instruct` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 0.59 | n/a | n/a | n/a |
| 1730196408827jp.png | ja | `ja` | `qwen/qwen3-vl-30b-a3b-instruct` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 0.50 | n/a | n/a | n/a |
| o08000924109524428441jp.jpg | ja | `auto` | `qwen/qwen3-vl-30b-a3b-instruct` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 0.51 | n/a | n/a | n/a |
| o08000924109524428441jp.jpg | ja | `ja` | `qwen/qwen3-vl-30b-a3b-instruct` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 0.30 | n/a | n/a | n/a |
| The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | `auto` | `qwen/qwen3-vl-30b-a3b-instruct` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 0.36 | n/a | n/a | n/a |
| The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | `zh` | `qwen/qwen3-vl-30b-a3b-instruct` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 0.48 | n/a | n/a | n/a |
| weibo_6_toutiao_comparison.jpg | zh | `auto` | `qwen/qwen3-vl-30b-a3b-instruct` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 0.43 | n/a | n/a | n/a |
| weibo_6_toutiao_comparison.jpg | zh | `zh` | `qwen/qwen3-vl-30b-a3b-instruct` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 0.39 | n/a | n/a | n/a |
| weibo_kol_1.jpg | zh | `auto` | `qwen/qwen3-vl-30b-a3b-instruct` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 0.43 | n/a | n/a | n/a |
| weibo_kol_1.jpg | zh | `zh` | `qwen/qwen3-vl-30b-a3b-instruct` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 0.42 | n/a | n/a | n/a |
| 1730196408827jp.png | ja | `auto` | `nvidia/nemotron-nano-12b-v2-vl:free` | `inclusionai/ling-2.6-flash:free` | 200 | 200 | `ja` | 11 | 24 | 242.68 | 1.31 | 41746 | 160.48 |
| 1730196408827jp.png | ja | `ja` | `nvidia/nemotron-nano-12b-v2-vl:free` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 405.90 | n/a | n/a | n/a |
| o08000924109524428441jp.jpg | ja | `auto` | `nvidia/nemotron-nano-12b-v2-vl:free` | `inclusionai/ling-2.6-flash:free` | 200 | 200 | `ja` | 1 | 14 | 255.04 | 1.50 | 3924 | 7.86 |
| o08000924109524428441jp.jpg | ja | `ja` | `nvidia/nemotron-nano-12b-v2-vl:free` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 162.13 | n/a | n/a | n/a |
| The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | `auto` | `nvidia/nemotron-nano-12b-v2-vl:free` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 146.06 | n/a | n/a | n/a |
| The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | `zh` | `nvidia/nemotron-nano-12b-v2-vl:free` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 112.76 | n/a | n/a | n/a |
| weibo_6_toutiao_comparison.jpg | zh | `auto` | `nvidia/nemotron-nano-12b-v2-vl:free` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 84.92 | n/a | n/a | n/a |
| weibo_6_toutiao_comparison.jpg | zh | `zh` | `nvidia/nemotron-nano-12b-v2-vl:free` | `inclusionai/ling-2.6-flash:free` | 200 | 200 | `zh-Hans` | 1 | 0 | 97.34 | 1.69 | 6206 | 39.90 |
| weibo_kol_1.jpg | zh | `auto` | `nvidia/nemotron-nano-12b-v2-vl:free` | `inclusionai/ling-2.6-flash:free` | 200 | 200 | `zh-Hans` | 14 | 32 | 197.74 | 1.78 | 42056 | 183.75 |
| weibo_kol_1.jpg | zh | `zh` | `nvidia/nemotron-nano-12b-v2-vl:free` | `inclusionai/ling-2.6-flash:free` | 502 | n/a | `n/a` | 0 | 0 | 256.10 | n/a | n/a | n/a |
| 1730196408827jp.png | ja | `auto` | `nvidia/nemotron-nano-12b-v2-vl:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 200 | 200 | `ja` | 5 | 21 | 94.47 | 6.24 | 17926 | 158.78 |
| 1730196408827jp.png | ja | `ja` | `nvidia/nemotron-nano-12b-v2-vl:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 200 | 200 | `ja` | 13 | 39 | 117.44 | 6.89 | 22260 | 161.43 |
| o08000924109524428441jp.jpg | ja | `auto` | `nvidia/nemotron-nano-12b-v2-vl:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 255.95 | n/a | n/a | n/a |
| o08000924109524428441jp.jpg | ja | `ja` | `nvidia/nemotron-nano-12b-v2-vl:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 255.90 | n/a | n/a | n/a |
| The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | `auto` | `nvidia/nemotron-nano-12b-v2-vl:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 254.96 | n/a | n/a | n/a |
| The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | `zh` | `nvidia/nemotron-nano-12b-v2-vl:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 156.56 | n/a | n/a | n/a |
| weibo_6_toutiao_comparison.jpg | zh | `auto` | `nvidia/nemotron-nano-12b-v2-vl:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 154.85 | n/a | n/a | n/a |
| weibo_6_toutiao_comparison.jpg | zh | `zh` | `nvidia/nemotron-nano-12b-v2-vl:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 131.29 | n/a | n/a | n/a |
| weibo_kol_1.jpg | zh | `auto` | `nvidia/nemotron-nano-12b-v2-vl:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 502 | n/a | `n/a` | 0 | 0 | 56.11 | n/a | n/a | n/a |
| weibo_kol_1.jpg | zh | `zh` | `nvidia/nemotron-nano-12b-v2-vl:free` | `nvidia/nemotron-3-nano-30b-a3b:free` | 200 | 200 | `zh-Hans` | 3 | 6 | 1234.56 | 327.94 | 92935 | 62.74 |

## Recommendation

Most consistent combo based on analyze success rate, auto-detect accuracy, sentence coverage, glossary coverage, and latency was `baidu/qianfan-ocr-fast:free` + `inclusionai/ling-2.6-flash:free`. It reached analyze success 80.00%, auto language accuracy 20.00%, and average analyze latency 164.57s.

## Detailed Runs

## 1. 1730196408827jp.png | auto | baidu/qianfan-ocr-fast:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `ja`
- Analyze endpoint: status=200, latency=181.29s
- Explain endpoint: status=200, latency=1.44s

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=True, attempts=1, latency=13.07s, prompt_tokens=2081, completion_tokens=1105, total_tokens=3186, t/s=84.57
- `text analysis` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=161.31s, prompt_tokens=2212, completion_tokens=32768, total_tokens=34980, t/s=203.14
- `glossary enrichment` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=6.89s, prompt_tokens=973, completion_tokens=1310, total_tokens=2283, t/s=190.27

### Vision Output
```json
{
  "documentText": "ヘブンバーンズレッド公式 @heavenburnsred · Follow\n公式4コマ漫画【ヘブン劇場】\n第108話「のろけ」\nシャロの撮影技術はすごい！\n今までのお話はこちら→x.com/heavenburnsred...\n作画:津留崎優 @hatori_niwatoriさん\n#ヘブン #ヘブン劇場\nのろけ\nシャロ\n撮影技術\nすごい！\n今までのお話はこちら→x.com/heavenburnsred...\n作画:津留崎優 @hatori_niwatoriさん\n#ヘブン #ヘブン劇場\nのろけ\nシャロ\n撮影技術\nすごい！\nガーディアンテイルズ公式 @GuardianTalesJP · Follow\n【かんたべりーでいず！】\nガーディアンテイルズの4コマ漫画\n#かんたべりーでいずの第140話「コンビニは今日も平和です」を公開！\n今後もさまざまな英雄たちの日常をお送りしていきます。\n作者：純粋な不純物(@parang9494)先生\n#ガーディアンテイルズ #ガデテイル\nかんたべりーでいず！\nコンビニは今日も平和です！\n今後もさまざまな英雄たちの日常をお送りしていきます。\n作者：純粋な不純物(@parang9494)先生\n#ガーディアンテイルズ #ガデテイル\nかんたべりーでいず！\nコンビニは今日も平和です！",
  "language": "ja",
  "readingLines": [],
  "pronunciationHints": [
    {
      "phrase": "ヘブンバーンズレッド公式",
      "preferredPinyin": "Hebunbansu Reddo Kiki",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "公式4コマ漫画【ヘブン劇場】",
      "preferredPinyin": "Kiki 4koma Manga [Hebun Kyōchō]",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "第108話「のろけ」",
      "preferredPinyin": "Dai 108wa 'Noroke'",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "シャロの撮影技術はすごい！",
      "preferredPinyin": "Sharo no Shōgyō Gijutsu wa Suii!",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "今までのお話はこちら→x.com/heavenburnsred...",
      "preferredPinyin": "Ima de no Owarai Koro → x.com/heavenburnsred...",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "作画:津留崎優 @hatori_niwatoriさん",
      "preferredPinyin": "Sakuhin: Nishirizaki Yuu @hatori_niwatori-san",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "#ヘブン #ヘブン劇場",
      "preferredPinyin": "#Hebun #Hebun Kyōchō",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "ガーディアンテイルズ公式 @GuardianTalesJP · Follow",
      "preferredPinyin": "Gaidian Tairuzu Kiki @GuardianTalesJP · Follow",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "【かんたべりーでいず！】",
      "preferredPinyin": "[Kantaberu deizu!]",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "ガーディアンテイルズの4コマ漫画",
      "preferredPinyin": "Gaidian Tairuzu no 4koma Manga",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "#かんたべりーでいずの第140話「コンビニは今日も平和です」を公開！",
      "preferredPinyin": "#Kantaberu deizu no Dai 140wa 'Konbini wa Kyou mo Heiwa desu' o Kōkō!",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "今後もさまざまな英雄たちの日常をお送りしていきます。",
      "preferredPinyin": "Ima kara mo Sazanai Kyōō-tachi no Kinō o Okusuri Shite Ikimasu.",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "作者：純粋な不純物(@parang9494)先生",
      "preferredPinyin": "Shosha: Junseiu na Fushuji (@parang9494) Seijin",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "#ガーディアンテイルズ #ガデテイル",
      "preferredPinyin": "#Gaidian Tairuzu #Gadetairuzu",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "かんたべりーでいず！",
      "preferredPinyin": "Kantaberu deizu!",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "コンビニは今日も平和です！",
      "preferredPinyin": "Konbini wa Kyou mo Heiwa desu!",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    }
  ],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [],
  "glossary": [],
  "pronunciationHints": []
}
```

### Glossary Enrichment Output
```json
{
  "entries": [
    {
      "text": "ヘブンバーンズレッド公式', 'literalMeaning': 'Heaven Burns Red Official', 'exampleSentence': 'ヘブンバーンズレッド公式 @heavenburnsred · Follow'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "公式', 'literalMeaning': 'Official', 'exampleSentence': '公式4コマ漫画【ヘブン劇場】'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "コマ漫画', 'literalMeaning': '4-panel manga', 'exampleSentence': '公式4コマ漫画【ヘブン劇場】'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ヘブン劇場', 'literalMeaning': 'Heaven Theater', 'exampleSentence': '公式4コマ漫画【ヘブン劇場】'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "第', 'literalMeaning': 'Number', 'exampleSentence': '第108話「のろけ」'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "話', 'literalMeaning': 'Episode', 'exampleSentence': '第108話「のろけ」'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "のろけ', 'literalMeaning': 'Romantic hesitation', 'exampleSentence': 'のろけ'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "シャロの撮影技術はすごい', 'literalMeaning': 'Sharo’s photography skills are amazing', 'exampleSentence': 'シャロの撮影技術はすごい！'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "今までのお話はこちら', 'literalMeaning': 'See the story here so far', 'exampleSentence': '今までのお話はこちら→x.com/heavenburnsred...'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "作画', 'literalMeaning': 'Artwork', 'exampleSentence': '作画:津留崎優 @hatori_niwatoriさん'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "津留崎優', 'literalMeaning': 'Tsurusaki Yū', 'exampleSentence': '作画:津留崎優 @hatori_niwatoriさん'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "さん', 'literalMeaning': 'Mr./Ms.', 'exampleSentence': '津留崎優 @hatori_niwatoriさん'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ヘブン', 'literalMeaning': 'Heaven', 'exampleSentence': '#ヘブン #ヘブン劇場'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "シャロ', 'literalMeaning': 'Sharo', 'exampleSentence': 'シャロ'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "撮影技術', 'literalMeaning': 'Photography skills', 'exampleSentence': '撮影技術'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "すごい', 'literalMeaning': 'Amazing', 'exampleSentence': 'すごい！'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ガーディアンテイルズ公式', 'literalMeaning': 'Guardian Tales Official', 'exampleSentence': 'ガーディアンテイルズ公式 @GuardianTalesJP · Follow'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "かんたべりーでいず', 'literalMeaning': 'Eat and Rest Easy', 'exampleSentence': 'かんたべりーでいず！'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ガーディアンテイルズの', 'literalMeaning': 'Of Guardian Tales', 'exampleSentence': 'ガーディアンテイルズの4コマ漫画'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "かんたべりーでいずの第', 'literalMeaning': 'The # of Eat and Rest Easy', 'exampleSentence': 'かんたべりーでいずの第140話「コンビニは今日も平和です」'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "コンビニは今日も平和です', 'literalMeaning': 'The convenience store is peaceful today too', 'exampleSentence': 'コンビニは今日も平和です！'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "を公開', 'literalMeaning': 'Release', 'exampleSentence': 'を公開'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "今後もさまざまな英雄たちの日常をお送りしていきます', 'literalMeaning': 'We will continue to send you the daily lives of various heroes', 'exampleSentence': '今後もさまざまな英雄たちの日常をお送りしていきます'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "作者', 'literalMeaning': 'Author', 'exampleSentence': '作者：純粋な不純物(@parang9494)先生'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "純粋な不純物', 'literalMeaning': 'Pure Impurity', 'exampleSentence': '作者：純粋な不純物(@parang9494)先生'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "先生', 'literalMeaning': 'Mr./Ms.', 'exampleSentence': '作者：純粋な不純物(@parang9494)先生'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ガーディアンテイルズ', 'literalMeaning': 'Guardian Tales', 'exampleSentence': 'ガーディアンテイルズ公式 @GuardianTalesJP · Follow'.",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ガデテイル', 'literalMeaning': 'Guarde Tail', 'exampleSentence': '#ガーデテイル'.",
      "literalMeaning": null,
      "exampleSentence": null
    }
  ]
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "ヘブンバーンズレッド公式 @heavenburnsred · Follow\n公式4コマ漫画【ヘブン劇場】\n第108話「のろけ」\nシャロの撮影技術はすごい！\n今までのお話はこちら→x.com/heavenburnsred...\n作画:津留崎優 @hatori_niwatoriさん\n#ヘブン #ヘブン劇場\nのろけ\nシャロ\n撮影技術\nすごい！\n今までのお話はこちら→x.com/heavenburnsred...\n作画:津留崎優 @hatori_niwatoriさん\n#ヘブン #ヘブン劇場\nのろけ\nシャロ\n撮影技術\nすごい！\nガーディアンテイルズ公式 @GuardianTalesJP · Follow\n【かんたべりーでいず！】\nガーディアンテイルズの4コマ漫画\n#かんたべりーでいずの第140話「コンビニは今日も平和です」を公開！\n今後もさまざまな英雄たちの日常をお送りしていきます。\n作者：純粋な不純物(@parang9494)先生\n#ガーディアンテイルズ #ガデテイル\nかんたべりーでいず！\nコンビニは今日も平和です！\n今後もさまざまな英雄たちの日常をお送りしていきます。\n作者：純粋な不純物(@parang9494)先生\n#ガーディアンテイルズ #ガデテイル\nかんたべりーでいず！\nコンビニは今日も平和です！",
  "language": "ja",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "ヘブンバーンズレッド公式heavenburnsred·Follow",
      "pinyin": "Hebunbansu Reddo Kiki heavenburnsred· Follow",
      "translation": null,
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "ヘブンバーンズレッド公式",
          "pinyin": "Hebunbansu Reddo Kiki",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t2",
          "hanzi": "heavenburnsred",
          "pinyin": "heavenburnsred",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t3",
          "hanzi": "·",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t4",
          "hanzi": "Follow",
          "pinyin": "Follow",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "公式4コマ漫画ヘブン劇場",
      "pinyin": "公式 4 koma漫画 hebun劇場",
      "translation": null,
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "公式",
          "pinyin": "公式",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t2",
          "hanzi": "4",
          "pinyin": "4",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t3",
          "hanzi": "コマ漫画",
          "pinyin": "koma漫画",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t4",
          "hanzi": "ヘブン劇場",
          "pinyin": "hebun劇場",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "第108話のろけ",
      "pinyin": "第 108 話 noroke",
      "translation": null,
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "第",
          "pinyin": "第",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t2",
          "hanzi": "108",
          "pinyin": "108",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t3",
          "hanzi": "話",
          "pinyin": "話",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t4",
          "hanzi": "のろけ",
          "pinyin": "noroke",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s4",
      "hanzi": "シャロの撮影技術はすごい！",
      "pinyin": "sharono撮影技術hasugoi！",
      "translation": null,
      "tokens": [
        {
          "id": "s4-t1",
          "hanzi": "シャロの撮影技術はすごい",
          "pinyin": "sharono撮影技術hasugoi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s5",
      "hanzi": "今までのお話はこちらxcom/heavenburnsred",
      "pinyin": "今madenoo話hakochira x com/ heavenburnsred",
      "translation": null,
      "tokens": [
        {
          "id": "s5-t1",
          "hanzi": "今までのお話はこちら",
          "pinyin": "今madenoo話hakochira",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t2",
          "hanzi": "x",
          "pinyin": "x",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t3",
          "hanzi": "com",
          "pinyin": "com",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t4",
          "hanzi": "/",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t5",
          "hanzi": "heavenburnsred",
          "pinyin": "heavenburnsred",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s6",
      "hanzi": "作画:津留崎優hatoriniwatoriさん",
      "pinyin": "作画: 津留崎優 hatori niwatori san",
      "translation": null,
      "tokens": [
        {
          "id": "s6-t1",
          "hanzi": "作画",
          "pinyin": "作画",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t2",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t3",
          "hanzi": "津留崎優",
          "pinyin": "津留崎優",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t4",
          "hanzi": "hatori",
          "pinyin": "hatori",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t5",
          "hanzi": "niwatori",
          "pinyin": "niwatori",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t6",
          "hanzi": "さん",
          "pinyin": "san",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s7",
      "hanzi": "ヘブンヘブン劇場",
      "pinyin": "hebun hebun劇場",
      "translation": null,
      "tokens": [
        {
          "id": "s7-t1",
          "hanzi": "ヘブン",
          "pinyin": "hebun",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t2",
          "hanzi": "ヘブン劇場",
          "pinyin": "hebun劇場",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s8",
      "hanzi": "のろけ",
      "pinyin": "noroke",
      "translation": null,
      "tokens": [
        {
          "id": "s8-t1",
          "hanzi": "のろけ",
          "pinyin": "noroke",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s9",
      "hanzi": "シャロ",
      "pinyin": "sharo",
      "translation": null,
      "tokens": [
        {
          "id": "s9-t1",
          "hanzi": "シャロ",
          "pinyin": "sharo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s10",
      "hanzi": "撮影技術",
      "pinyin": "撮影技術",
      "translation": null,
      "tokens": [
        {
          "id": "s10-t1",
          "hanzi": "撮影技術",
          "pinyin": "撮影技術",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s11",
      "hanzi": "すごい！",
      "pinyin": "sugoi！",
      "translation": null,
      "tokens": [
        {
          "id": "s11-t1",
          "hanzi": "すごい",
          "pinyin": "sugoi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s12",
      "hanzi": "今までのお話はこちらxcom/heavenburnsred",
      "pinyin": "今madenoo話hakochira x com/ heavenburnsred",
      "translation": null,
      "tokens": [
        {
          "id": "s12-t1",
          "hanzi": "今までのお話はこちら",
          "pinyin": "今madenoo話hakochira",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s12-t2",
          "hanzi": "x",
          "pinyin": "x",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s12-t3",
          "hanzi": "com",
          "pinyin": "com",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s12-t4",
          "hanzi": "/",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s12-t5",
          "hanzi": "heavenburnsred",
          "pinyin": "heavenburnsred",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s13",
      "hanzi": "作画:津留崎優hatoriniwatoriさん",
      "pinyin": "作画: 津留崎優 hatori niwatori san",
      "translation": null,
      "tokens": [
        {
          "id": "s13-t1",
          "hanzi": "作画",
          "pinyin": "作画",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t2",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t3",
          "hanzi": "津留崎優",
          "pinyin": "津留崎優",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t4",
          "hanzi": "hatori",
          "pinyin": "hatori",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t5",
          "hanzi": "niwatori",
          "pinyin": "niwatori",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t6",
          "hanzi": "さん",
          "pinyin": "san",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s14",
      "hanzi": "ヘブンヘブン劇場",
      "pinyin": "hebun hebun劇場",
      "translation": null,
      "tokens": [
        {
          "id": "s14-t1",
          "hanzi": "ヘブン",
          "pinyin": "hebun",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s14-t2",
          "hanzi": "ヘブン劇場",
          "pinyin": "hebun劇場",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s15",
      "hanzi": "のろけ",
      "pinyin": "noroke",
      "translation": null,
      "tokens": [
        {
          "id": "s15-t1",
          "hanzi": "のろけ",
          "pinyin": "noroke",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s16",
      "hanzi": "シャロ",
      "pinyin": "sharo",
      "translation": null,
      "tokens": [
        {
          "id": "s16-t1",
          "hanzi": "シャロ",
          "pinyin": "sharo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s17",
      "hanzi": "撮影技術",
      "pinyin": "撮影技術",
      "translation": null,
      "tokens": [
        {
          "id": "s17-t1",
          "hanzi": "撮影技術",
          "pinyin": "撮影技術",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s18",
      "hanzi": "すごい！",
      "pinyin": "sugoi！",
      "translation": null,
      "tokens": [
        {
          "id": "s18-t1",
          "hanzi": "すごい",
          "pinyin": "sugoi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s19",
      "hanzi": "ガーディアンテイルズ公式GuardianTalesJP·Follow",
      "pinyin": "gaadianteiruzu公式 GuardianTalesJP· Follow",
      "translation": null,
      "tokens": [
        {
          "id": "s19-t1",
          "hanzi": "ガーディアンテイルズ公式",
          "pinyin": "gaadianteiruzu公式",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t2",
          "hanzi": "GuardianTalesJP",
          "pinyin": "GuardianTalesJP",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t3",
          "hanzi": "·",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t4",
          "hanzi": "Follow",
          "pinyin": "Follow",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s20",
      "hanzi": "かんたべりーでいず！",
      "pinyin": "kantaberiideizu！",
      "translation": null,
      "tokens": [
        {
          "id": "s20-t1",
          "hanzi": "かんたべりーでいず",
          "pinyin": "kantaberiideizu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s20-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s21",
      "hanzi": "ガーディアンテイルズの4コマ漫画",
      "pinyin": "gaadianteiruzuno 4 koma漫画",
      "translation": null,
      "tokens": [
        {
          "id": "s21-t1",
          "hanzi": "ガーディアンテイルズの",
          "pinyin": "gaadianteiruzuno",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t2",
          "hanzi": "4",
          "pinyin": "4",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t3",
          "hanzi": "コマ漫画",
          "pinyin": "koma漫画",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s22",
      "hanzi": "かんたべりーでいずの第140話コンビニは今日も平和ですを公開！",
      "pinyin": "kantaberiideizuno第 140 話 konbiniha今日mo平和desu wo公開！",
      "translation": null,
      "tokens": [
        {
          "id": "s22-t1",
          "hanzi": "かんたべりーでいずの第",
          "pinyin": "kantaberiideizuno第",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t2",
          "hanzi": "140",
          "pinyin": "140",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t3",
          "hanzi": "話",
          "pinyin": "話",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t4",
          "hanzi": "コンビニは今日も平和です",
          "pinyin": "konbiniha今日mo平和desu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t5",
          "hanzi": "を公開",
          "pinyin": "wo公開",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t6",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s23",
      "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます。",
      "pinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu。",
      "translation": null,
      "tokens": [
        {
          "id": "s23-t1",
          "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます",
          "pinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s23-t2",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s24",
      "hanzi": "作者：純粋な不純物(parang9494)先生",
      "pinyin": "作者： 純粋na不純物( parang9494) 先生",
      "translation": null,
      "tokens": [
        {
          "id": "s24-t1",
          "hanzi": "作者",
          "pinyin": "作者",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s24-t2",
          "hanzi": "：",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s24-t3",
          "hanzi": "純粋な不純物",
          "pinyin": "純粋na不純物",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s24-t4",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s24-t5",
          "hanzi": "parang9494",
          "pinyin": "parang9494",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s24-t6",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s24-t7",
          "hanzi": "先生",
          "pinyin": "先生",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s25",
      "hanzi": "ガーディアンテイルズガデテイル",
      "pinyin": "gaadianteiruzu gadeteiru",
      "translation": null,
      "tokens": [
        {
          "id": "s25-t1",
          "hanzi": "ガーディアンテイルズ",
          "pinyin": "gaadianteiruzu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s25-t2",
          "hanzi": "ガデテイル",
          "pinyin": "gadeteiru",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s26",
      "hanzi": "かんたべりーでいず！",
      "pinyin": "kantaberiideizu！",
      "translation": null,
      "tokens": [
        {
          "id": "s26-t1",
          "hanzi": "かんたべりーでいず",
          "pinyin": "kantaberiideizu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s26-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s27",
      "hanzi": "コンビニは今日も平和です！",
      "pinyin": "konbiniha今日mo平和desu！",
      "translation": null,
      "tokens": [
        {
          "id": "s27-t1",
          "hanzi": "コンビニは今日も平和です",
          "pinyin": "konbiniha今日mo平和desu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s27-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s28",
      "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます。",
      "pinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu。",
      "translation": null,
      "tokens": [
        {
          "id": "s28-t1",
          "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます",
          "pinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s28-t2",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s29",
      "hanzi": "作者：純粋な不純物(parang9494)先生",
      "pinyin": "作者： 純粋na不純物( parang9494) 先生",
      "translation": null,
      "tokens": [
        {
          "id": "s29-t1",
          "hanzi": "作者",
          "pinyin": "作者",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s29-t2",
          "hanzi": "：",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s29-t3",
          "hanzi": "純粋な不純物",
          "pinyin": "純粋na不純物",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s29-t4",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s29-t5",
          "hanzi": "parang9494",
          "pinyin": "parang9494",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s29-t6",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s29-t7",
          "hanzi": "先生",
          "pinyin": "先生",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s30",
      "hanzi": "ガーディアンテイルズガデテイル",
      "pinyin": "gaadianteiruzu gadeteiru",
      "translation": null,
      "tokens": [
        {
          "id": "s30-t1",
          "hanzi": "ガーディアンテイルズ",
          "pinyin": "gaadianteiruzu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s30-t2",
          "hanzi": "ガデテイル",
          "pinyin": "gadeteiru",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s31",
      "hanzi": "かんたべりーでいず！",
      "pinyin": "kantaberiideizu！",
      "translation": null,
      "tokens": [
        {
          "id": "s31-t1",
          "hanzi": "かんたべりーでいず",
          "pinyin": "kantaberiideizu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s31-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s32",
      "hanzi": "コンビニは今日も平和です！",
      "pinyin": "konbiniha今日mo平和desu！",
      "translation": null,
      "tokens": [
        {
          "id": "s32-t1",
          "hanzi": "コンビニは今日も平和です",
          "pinyin": "konbiniha今日mo平和desu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s32-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "ヘブンバーンズレッド公式",
      "pinyin": "Hebunbansu Reddo Kiki",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "公式",
      "pinyin": "公式",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "コマ漫画",
      "pinyin": "koma漫画",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ヘブン劇場",
      "pinyin": "hebun劇場",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "第",
      "pinyin": "第",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "話",
      "pinyin": "話",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "のろけ",
      "pinyin": "noroke",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "シャロの撮影技術はすごい",
      "pinyin": "sharono撮影技術hasugoi",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "今までのお話はこちら",
      "pinyin": "今madenoo話hakochira",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "作画",
      "pinyin": "作画",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "津留崎優",
      "pinyin": "津留崎優",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "さん",
      "pinyin": "san",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ヘブン",
      "pinyin": "hebun",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "シャロ",
      "pinyin": "sharo",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "撮影技術",
      "pinyin": "撮影技術",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "すごい",
      "pinyin": "sugoi",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーディアンテイルズ公式",
      "pinyin": "gaadianteiruzu公式",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "かんたべりーでいず",
      "pinyin": "kantaberiideizu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーディアンテイルズの",
      "pinyin": "gaadianteiruzuno",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "かんたべりーでいずの第",
      "pinyin": "kantaberiideizuno第",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "コンビニは今日も平和です",
      "pinyin": "konbiniha今日mo平和desu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "を公開",
      "pinyin": "wo公開",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます",
      "pinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "作者",
      "pinyin": "作者",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "純粋な不純物",
      "pinyin": "純粋na不純物",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "先生",
      "pinyin": "先生",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーディアンテイルズ",
      "pinyin": "gaadianteiruzu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガデテイル",
      "pinyin": "gadeteiru",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "ヘブンバーンズレッド公式",
  "pinyin": "he bun ba-nzu re-dō kou-shi",
  "meaning": "Heaven Burns Red official",
  "notes": "A direct Japanese phrase meaning 'official content/account of Heaven Burns Red,' a game title.",
  "examples": [],
  "pinyinSource": "text_model_hint"
}
```

## 2. 1730196408827jp.png | ja | baidu/qianfan-ocr-fast:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `ja`
- Analyze endpoint: status=200, latency=165.87s
- Explain endpoint: status=200, latency=1.43s

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=True, attempts=1, latency=7.01s, prompt_tokens=2079, completion_tokens=310, total_tokens=2389, t/s=44.21
- `text analysis` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=153.46s, prompt_tokens=875, completion_tokens=32768, total_tokens=33643, t/s=213.52
- `glossary enrichment` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=5.35s, prompt_tokens=840, completion_tokens=895, total_tokens=1735, t/s=167.16

### Vision Output
```json
{
  "documentText": "ヘブンバーンズレッド公式 @heavenburnsred · Follow\n公式4コマ漫画【ヘブン劇場】\n第108話「のろけ」\nシャロの撮影技術はすごい！\n今までのお話はこちら→x.com/heavenburnsred...\n作画:津留崎優 @hatori_niwatoriさん\n#ヘブン #ヘブン劇場\n\nガーディアンテイルズ公式 @GuardianTalesJP · Follow\n【かんたべりーでいず！】\nガーディアンテイルズの4コマ漫画\n#かんたべりーでいずの第140話「コンビニは今日も平和です」を公開！\n今後もさまざまな英雄たちの日常をお送りしていきます。\n作者：純粋な不純物(@parang9494)先生\n#ガーディアンテイルズ #ガデテイル\n\n1:00 PM · Sep 15, 2024\n4.1K\nReply\nCopy link\nRead 29 replies\n\n5:00 PM · Sep 6, 2024\n1K\nReply\nCopy link\nRead 5 replies",
  "language": "ja",
  "readingLines": [],
  "pronunciationHints": [],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [],
  "glossary": [],
  "pronunciationHints": []
}
```

### Glossary Enrichment Output
```json
{
  "entries": [
    {
      "text": "ヘブンバーンズレッド公式', 'literalMeaning': 'Heaven Burns Red Official', 'exampleSentence': 'ヘブンバーンズレッド公式 @heavenburnsred · Follow'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "公式', 'literalMeaning': 'Official', 'exampleSentence': '公式4コマ漫画【ヘブン劇場】'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "コマ漫画', 'literalMeaning': '4-panel manga', 'exampleSentence': '公式4コマ漫画【ヘブン劇場】'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ヘブン劇場', 'literalMeaning': 'Heaven Theater', 'exampleSentence': '公式4コマ漫画【ヘブン劇場】'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "第', 'literalMeaning': 'Number', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "話', 'literalMeaning': 'Story / Episode', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "のろけ', 'literalMeaning': 'Lovelorn', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "シャロの撮影技術はすごい', 'literalMeaning': 'Sharo’s photography skills are amazing', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "今までのお話はこちら', 'literalMeaning': 'See the story so far here', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "作画', 'literalMeaning': 'Artwork', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "津留崎優', 'literalMeaning': 'Yutaka Tsuruzaki', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "さん', 'literalMeaning': 'Mr. / Ms.', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ヘブン', 'literalMeaning': 'Heaven', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ガーディアンテイルズ公式', 'literalMeaning': 'Guardian Tales Official', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "かんたべりーでいず', 'literalMeaning': 'Kan Taberi Iz', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ガーディアンテイルズの', 'literalMeaning': 'Of Guardian Tales', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "かんたべりーでいずの第', 'literalMeaning': 'The Number of Kan Taberi Iz', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "コンビニは今日も平和です', 'literalMeaning': 'The convenience store is peaceful today too', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "を公開', 'literalMeaning': 'Release', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "今後もさまざまな英雄たちの日常をお送りしていきます', 'literalMeaning': 'We will continue to send you the daily lives of various heroes', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "作者', 'literalMeaning': 'Author', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "純粋な不純物', 'literalMeaning': 'Pure Impurity', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "先生', 'literalMeaning': 'Teacher', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ガーディアンテイルズ', 'literalMeaning': 'Guardian Tales', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ガデテイル', 'literalMeaning': 'Guard Tales', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    }
  ]
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "ヘブンバーンズレッド公式 @heavenburnsred · Follow\n公式4コマ漫画【ヘブン劇場】\n第108話「のろけ」\nシャロの撮影技術はすごい！\n今までのお話はこちら→x.com/heavenburnsred...\n作画:津留崎優 @hatori_niwatoriさん\n#ヘブン #ヘブン劇場\n\nガーディアンテイルズ公式 @GuardianTalesJP · Follow\n【かんたべりーでいず！】\nガーディアンテイルズの4コマ漫画\n#かんたべりーでいずの第140話「コンビニは今日も平和です」を公開！\n今後もさまざまな英雄たちの日常をお送りしていきます。\n作者：純粋な不純物(@parang9494)先生\n#ガーディアンテイルズ #ガデテイル\n\n1:00 PM · Sep 15, 2024\n4.1K\nReply\nCopy link\nRead 29 replies\n\n5:00 PM · Sep 6, 2024\n1K\nReply\nCopy link\nRead 5 replies",
  "language": "ja",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "ヘブンバーンズレッド公式",
      "pinyin": "hebunbaanzureddo公式",
      "translation": null,
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "ヘブンバーンズレッド公式",
          "pinyin": "hebunbaanzureddo公式",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "公式コマ漫画ヘブン劇場",
      "pinyin": "公式 koma漫画 hebun劇場",
      "translation": null,
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "公式",
          "pinyin": "公式",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t2",
          "hanzi": "コマ漫画",
          "pinyin": "koma漫画",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t3",
          "hanzi": "ヘブン劇場",
          "pinyin": "hebun劇場",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "第話のろけ",
      "pinyin": "第 話 noroke",
      "translation": null,
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "第",
          "pinyin": "第",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t2",
          "hanzi": "話",
          "pinyin": "話",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t3",
          "hanzi": "のろけ",
          "pinyin": "noroke",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s4",
      "hanzi": "シャロの撮影技術はすごい！",
      "pinyin": "sharono撮影技術hasugoi！",
      "translation": null,
      "tokens": [
        {
          "id": "s4-t1",
          "hanzi": "シャロの撮影技術はすごい",
          "pinyin": "sharono撮影技術hasugoi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s5",
      "hanzi": "今までのお話はこちら",
      "pinyin": "今madenoo話hakochira",
      "translation": null,
      "tokens": [
        {
          "id": "s5-t1",
          "hanzi": "今までのお話はこちら",
          "pinyin": "今madenoo話hakochira",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s6",
      "hanzi": "作画:津留崎優さん",
      "pinyin": "作画: 津留崎優 san",
      "translation": null,
      "tokens": [
        {
          "id": "s6-t1",
          "hanzi": "作画",
          "pinyin": "作画",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t2",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t3",
          "hanzi": "津留崎優",
          "pinyin": "津留崎優",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t4",
          "hanzi": "さん",
          "pinyin": "san",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s7",
      "hanzi": "ヘブンヘブン劇場",
      "pinyin": "hebun hebun劇場",
      "translation": null,
      "tokens": [
        {
          "id": "s7-t1",
          "hanzi": "ヘブン",
          "pinyin": "hebun",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t2",
          "hanzi": "ヘブン劇場",
          "pinyin": "hebun劇場",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s8",
      "hanzi": "ガーディアンテイルズ公式",
      "pinyin": "gaadianteiruzu公式",
      "translation": null,
      "tokens": [
        {
          "id": "s8-t1",
          "hanzi": "ガーディアンテイルズ公式",
          "pinyin": "gaadianteiruzu公式",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s9",
      "hanzi": "かんたべりーでいず！",
      "pinyin": "kantaberiideizu！",
      "translation": null,
      "tokens": [
        {
          "id": "s9-t1",
          "hanzi": "かんたべりーでいず",
          "pinyin": "kantaberiideizu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s10",
      "hanzi": "ガーディアンテイルズのコマ漫画",
      "pinyin": "gaadianteiruzuno koma漫画",
      "translation": null,
      "tokens": [
        {
          "id": "s10-t1",
          "hanzi": "ガーディアンテイルズの",
          "pinyin": "gaadianteiruzuno",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t2",
          "hanzi": "コマ漫画",
          "pinyin": "koma漫画",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s11",
      "hanzi": "かんたべりーでいずの第話コンビニは今日も平和ですを公開！",
      "pinyin": "kantaberiideizuno第 話 konbiniha今日mo平和desu wo公開！",
      "translation": null,
      "tokens": [
        {
          "id": "s11-t1",
          "hanzi": "かんたべりーでいずの第",
          "pinyin": "kantaberiideizuno第",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t2",
          "hanzi": "話",
          "pinyin": "話",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t3",
          "hanzi": "コンビニは今日も平和です",
          "pinyin": "konbiniha今日mo平和desu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t4",
          "hanzi": "を公開",
          "pinyin": "wo公開",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t5",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s12",
      "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます。",
      "pinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu。",
      "translation": null,
      "tokens": [
        {
          "id": "s12-t1",
          "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます",
          "pinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s12-t2",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s13",
      "hanzi": "作者：純粋な不純物()先生",
      "pinyin": "作者： 純粋na不純物() 先生",
      "translation": null,
      "tokens": [
        {
          "id": "s13-t1",
          "hanzi": "作者",
          "pinyin": "作者",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t2",
          "hanzi": "：",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t3",
          "hanzi": "純粋な不純物",
          "pinyin": "純粋na不純物",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t4",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t5",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t6",
          "hanzi": "先生",
          "pinyin": "先生",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s14",
      "hanzi": "ガーディアンテイルズガデテイル",
      "pinyin": "gaadianteiruzu gadeteiru",
      "translation": null,
      "tokens": [
        {
          "id": "s14-t1",
          "hanzi": "ガーディアンテイルズ",
          "pinyin": "gaadianteiruzu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s14-t2",
          "hanzi": "ガデテイル",
          "pinyin": "gadeteiru",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "ヘブンバーンズレッド公式",
      "pinyin": "hebunbaanzureddo公式",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "公式",
      "pinyin": "公式",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "コマ漫画",
      "pinyin": "koma漫画",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ヘブン劇場",
      "pinyin": "hebun劇場",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "第",
      "pinyin": "第",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "話",
      "pinyin": "話",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "のろけ",
      "pinyin": "noroke",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "シャロの撮影技術はすごい",
      "pinyin": "sharono撮影技術hasugoi",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "今までのお話はこちら",
      "pinyin": "今madenoo話hakochira",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "作画",
      "pinyin": "作画",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "津留崎優",
      "pinyin": "津留崎優",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "さん",
      "pinyin": "san",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ヘブン",
      "pinyin": "hebun",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーディアンテイルズ公式",
      "pinyin": "gaadianteiruzu公式",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "かんたべりーでいず",
      "pinyin": "kantaberiideizu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーディアンテイルズの",
      "pinyin": "gaadianteiruzuno",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "かんたべりーでいずの第",
      "pinyin": "kantaberiideizuno第",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "コンビニは今日も平和です",
      "pinyin": "konbiniha今日mo平和desu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "を公開",
      "pinyin": "wo公開",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます",
      "pinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "作者",
      "pinyin": "作者",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "純粋な不純物",
      "pinyin": "純粋na不純物",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "先生",
      "pinyin": "先生",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーディアンテイルズ",
      "pinyin": "gaadianteiruzu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガデテイル",
      "pinyin": "gadeteiru",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "ヘブンバーンズレッド公式",
  "pinyin": "he bun ba-nzu re-dou gong-shi",
  "meaning": "Heaven Burns Red official",
  "notes": "Japanese phrase; 'ヘブンバーンズレッド' is the katakana rendering of 'Heaven Burns Red', and '公式' means 'official'. Often used for the official website or materials of the game.",
  "examples": [],
  "pinyinSource": "text_model_hint"
}
```

## 3. o08000924109524428441jp.jpg | auto | baidu/qianfan-ocr-fast:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `ja`
- Analyze endpoint: status=502, latency=283.85s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=False, attempts=2, latency=283.81s, prompt_tokens=4129, completion_tokens=28639, total_tokens=32768, t/s=100.91
  error: OpenRouter returned an error response: {"error":{"message":"Provider returned error","code":429,"metadata":{"raw":"baidu/qianfan-ocr-fast:free is temporarily rate-limited upstream. Please retry shortly, or add your own key to accumulate your rate limits: https://openrouter.ai/settings/integrations","provider_name":"Baidu","is_byok":false}},"user_id":"user_33l3f2lCVirQHMjQT2ZEc5ZZQPg"}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 4. o08000924109524428441jp.jpg | ja | baidu/qianfan-ocr-fast:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `ja`
- Analyze endpoint: status=502, latency=679.72s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=False, attempts=3, latency=679.68s, prompt_tokens=12690, completion_tokens=70974, total_tokens=83664, t/s=104.42
  error: Vision extraction appears to contain hallucinated repeated text. Return each visible line only once unless it visibly repeats in the image.

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction returned an invalid structured response."
}
```

### Explain Endpoint Output
```json
null
```

## 5. The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | auto | baidu/qianfan-ocr-fast:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=200, latency=176.62s
- Explain endpoint: status=200, latency=1.56s

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=True, attempts=1, latency=10.17s, prompt_tokens=4129, completion_tokens=786, total_tokens=4915, t/s=77.29
- `text analysis` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=152.68s, prompt_tokens=1430, completion_tokens=32768, total_tokens=34198, t/s=214.61
- `glossary enrichment` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=13.69s, prompt_tokens=2220, completion_tokens=2736, total_tokens=4956, t/s=199.86

### Vision Output
```json
{
  "documentText": "西元二〇〇三年/中華民國九十二年四月九日星期三\n「解放伊拉克」見六版專頁\n人事傾軋國親決策機制叫停(台聞)\n浙億萬富翁周祖豹命案偵破(陸聞)\n陸羽案又一幕後指使人被捕(港聞)\n胡錦濤關切湖南團在美車禍(綜合)\n世界日報\nWorld Journal\n美軍巴城開火記者三死三傷\n西班牙批聯軍事先擇定巴勒斯坦大飯店為目標美稱屋頂有人偷襲\n本報綜合巴格達、華盛頓八訊報導一輛美軍坦克8外國記者群集的巴格達市巴組大飯店(Palestine Hotel)。為成兩名外國記者喪生。\n阿拉伯語吉拉電視台並\n美軍飛彈炸中該電視台的\n建築事處一名記者喪生。\n角大廈8日對記者喪生表示\n並向他們的家屬致哀但\n巴格達是戰區單方無法保\n衛人的安全。\n炸死的記者是現年35歲的\n攝影記者波茲克(Taras\nuk)、西班牙第五頻道現年\n的攝影記者庫索(Jose\n)以及實習吉拉電視台記者\n布(Tareq Ayub) 路透社有\n記者在美軍砲擊巴勒斯坦大\n事件中受傷。\n國中央軍區前進指揮部的說\n有人從該飯店的屋頂向\nC D C SARS非亞洲\n促勿歧視指美已\n【本報綜合八日電訊報導】\n到中國大陸調查嚴重急性呼吸\n道症候群(SARS)疫情的世界衛生組織(WHO)專家8\n日結束在SARS起源地廣東\n省的調查訪問他們此行並沒\n有突破性發現但表示一旦大\n陸提供病患標本未來數月或\n數月對此病的了解應會有很大\n進展。\n由於醫學專家普遍懷疑\nSARS源於大陸華盛頓加拿大\n人抱怨因此被歧視美國疾病\n防治中心(CDC)主管萊莉\n葛柏汀8日警告不應有此歧\n視因為此病不是亞洲人特有\n的疾病。\n她還表示美國迄今已控制\n此病可能擴散的威脅。\n時代雜誌(Time)網站8\n日報導北京醫師江延永(譯\n音)在給該雜誌的署名聲明\n中對大陸衛生部說的北京病\n患數目提出質疑認為實際人\n數應該高出官方數字很多因\n加拿大\n由於經濟\nSARS疫情\n少飛香港\n機飛香港\n飛到九龍\n據法新社\n日已達28\n亡大陸\n個53人\n病例928\n三是加拿\n10人死亡\n個美國\n都沒人死亡\nCDC 8日\n病例數布在\n38個結\n鎮州9個\n葛柏汀\n會員的選舉\n亞洲人的疾\n地區的民眾\n的疾病。",
  "language": "zh-Hant",
  "readingLines": [],
  "pronunciationHints": [],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [],
  "glossary": [],
  "pronunciationHints": []
}
```

### Glossary Enrichment Output
```json
{
  "entries": [
    {
      "text": "西元二〇〇三年/中華民國九十二年四月九日星期三/解放伊拉克/見六版專頁/人事傾軋國親決策機制叫停/台聞/浙億萬富翁周祖豹命案偵破/陸聞/陸羽案又一幕後指使人被捕/港聞/胡錦濤關切湖南團在美車禍/綜合/世界日報/美軍巴城開火記者三死三傷/西班牙批聯軍事先擇定巴勒斯坦大飯店為目標美稱屋頂有人偷襲/本報綜合巴格達/華盛頓八訊報導一輛美軍坦克/外國記者群集的巴格達市巴組大飯店/為成兩名外國記者喪生/阿拉伯語吉拉電視台並/美軍飛彈炸中該電視台的/建築事處一名記者喪生/角大廈/日對記者喪生表示/並向他們的家屬致哀但/巴格達是戰區單方無法保衛人的安全/炸死的記者是現年/歲的/攝影記者波茲克/西班牙第五頻道現年/的攝影記者庫索/以及實習吉拉電視台記者/布/路透社有/記者在美軍砲擊巴勒斯坦大/事件中受傷/國中央軍區前進指揮部的說/有人從該飯店的屋頂向/C D C SARS非亞洲/促勿歧視指美已/【本報綜合八日電訊報導】/到中國大陸調查嚴重急性呼吸/道症候群/SARS疫情的世界衛生組織/專家/日結束在/起源地廣東/省的調查訪問他們此行並沒/有突破性發現但表示一旦大/陸提供病患標本未來數月或/數月對此病的了解應會有很大/進展/由於醫學專家普遍懷疑/SARS源於大陸華盛頓加拿大/人抱怨因此被歧視美國疾病/防治中心/主管萊莉/葛柏汀/日警告不應有此歧/視因為此病不是亞洲人特有/的疾病/她還表示美國迄今已控制/此病可能擴散的威脅/時代雜誌/Time/網站/日報導北京醫師江延永/譯/音/在給該雜誌的署名聲明/中對大陸衛生部說的北京病/患數目提出質疑認為實際人/數應該高出官方數字很多因/加拿大/由於經濟/SARS疫情/少飛香港/機飛香港/飛到九龍/據法新社/日已達/亡大陸/個53人/病例928/三是加拿/10人死亡/個美國/都沒人死亡/CDC 8日/病例數布在/38個結/鎮州9個/葛柏汀/會員的選舉/亞洲人的疾/地區的民眾/的疾病",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "三年",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "中華民國九十二年四月九日星期三",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "解放伊拉克",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "見六版專頁",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "人事傾軋國親決策機制叫停",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "台聞",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "浙億萬富翁周祖豹命案偵破",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "陸聞",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "陸羽案又一幕後指使人被捕",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "港聞",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "胡錦濤關切湖南團在美車禍",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "綜合",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "世界日報",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "美軍巴城開火記者三死三傷",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "西班牙批聯軍事先擇定巴勒斯坦大飯店為目標美稱屋頂有人偷襲",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "本報綜合巴格達",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "華盛頓八訊報導一輛美軍坦克",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "外國記者群集的巴格達市巴組大飯店",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "為成兩名外國記者喪生",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "阿拉伯語吉拉電視台並",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "美軍飛彈炸中該電視台的",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "建築事處一名記者喪生",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "角大廈",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "日對記者喪生表示",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "並向他們的家屬致哀但",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "巴格達是戰區單方無法保",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "衛人的安全",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "炸死的記者是現年",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "歲的",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "攝影記者波茲克",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "西班牙第五頻道現年",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "的攝影記者庫索",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "以及實習吉拉電視台記者",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "布",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "路透社有",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "記者在美軍砲擊巴勒斯坦大",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "事件中受傷",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "國中央軍區前進指揮部的說",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "有人從該飯店的屋頂向",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "非亞洲",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "促勿歧視指美已",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "本報綜合八日電訊報導",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "到中國大陸調查嚴重急性呼吸",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "道症候群",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "疫情的世界衛生組織",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "專家",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "日結束在",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "起源地廣東",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "省的調查訪問他們此行並沒",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "有突破性發現但表示一旦大",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "陸提供病患標本未來數月或",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "數月對此病的了解應會有很大",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "進展",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "由於醫學專家普遍懷疑",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "源於大陸華盛頓加拿大",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "人抱怨因此被歧視美國疾病",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "防治中心",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "主管萊莉",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "葛柏汀",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "日警告不應有此歧",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "視因為此病不是亞洲人特有",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "的疾病",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "她還表示美國迄今已控制",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "此病可能擴散的威脅",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "時代雜誌",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "網站",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "日報導北京醫師江延永",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "譯",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "音",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "在給該雜誌的署名聲明",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "中對大陸衛生部說的北京病",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "患數目提出質疑認為實際人",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "數應該高出官方數字很多因",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "加拿大",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "由於經濟",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "疫情",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "少飛香港",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "機飛香港",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "飛到九龍",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "據法新社",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "日已達",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "亡大陸",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "個",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "人",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "病例",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "三是加拿",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "人死亡",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "個美國",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "都沒人死亡",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "日",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "病例數布在",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "個結",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "鎮州",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "會員的選舉",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "亞洲人的疾",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "地區的民眾",
      "literalMeaning": null,
      "exampleSentence": null
    }
  ]
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "西元二〇〇三年/中華民國九十二年四月九日星期三\n「解放伊拉克」見六版專頁\n人事傾軋國親決策機制叫停(台聞)\n浙億萬富翁周祖豹命案偵破(陸聞)\n陸羽案又一幕後指使人被捕(港聞)\n胡錦濤關切湖南團在美車禍(綜合)\n世界日報\nWorld Journal\n美軍巴城開火記者三死三傷\n西班牙批聯軍事先擇定巴勒斯坦大飯店為目標美稱屋頂有人偷襲\n本報綜合巴格達、華盛頓八訊報導一輛美軍坦克8外國記者群集的巴格達市巴組大飯店(Palestine Hotel)。為成兩名外國記者喪生。\n阿拉伯語吉拉電視台並\n美軍飛彈炸中該電視台的\n建築事處一名記者喪生。\n角大廈8日對記者喪生表示\n並向他們的家屬致哀但\n巴格達是戰區單方無法保\n衛人的安全。\n炸死的記者是現年35歲的\n攝影記者波茲克(Taras\nuk)、西班牙第五頻道現年\n的攝影記者庫索(Jose\n)以及實習吉拉電視台記者\n布(Tareq Ayub) 路透社有\n記者在美軍砲擊巴勒斯坦大\n事件中受傷。\n國中央軍區前進指揮部的說\n有人從該飯店的屋頂向\nC D C SARS非亞洲\n促勿歧視指美已\n【本報綜合八日電訊報導】\n到中國大陸調查嚴重急性呼吸\n道症候群(SARS)疫情的世界衛生組織(WHO)專家8\n日結束在SARS起源地廣東\n省的調查訪問他們此行並沒\n有突破性發現但表示一旦大\n陸提供病患標本未來數月或\n數月對此病的了解應會有很大\n進展。\n由於醫學專家普遍懷疑\nSARS源於大陸華盛頓加拿大\n人抱怨因此被歧視美國疾病\n防治中心(CDC)主管萊莉\n葛柏汀8日警告不應有此歧\n視因為此病不是亞洲人特有\n的疾病。\n她還表示美國迄今已控制\n此病可能擴散的威脅。\n時代雜誌(Time)網站8\n日報導北京醫師江延永(譯\n音)在給該雜誌的署名聲明\n中對大陸衛生部說的北京病\n患數目提出質疑認為實際人\n數應該高出官方數字很多因\n加拿大\n由於經濟\nSARS疫情\n少飛香港\n機飛香港\n飛到九龍\n據法新社\n日已達28\n亡大陸\n個53人\n病例928\n三是加拿\n10人死亡\n個美國\n都沒人死亡\nCDC 8日\n病例數布在\n38個結\n鎮州9個\n葛柏汀\n會員的選舉\n亞洲人的疾\n地區的民眾\n的疾病。",
  "language": "zh-Hant",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "西元二三年/中華民國九十二年四月九日星期三",
      "pinyin": "xī yuán èr sān nián/ zhōng huá mín guó jiǔ shí èr nián sì yuè jiǔ rì xīng qī sān",
      "translation": null,
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "西元二",
          "pinyin": "xī yuán èr",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t2",
          "hanzi": "三年",
          "pinyin": "sān nián",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t3",
          "hanzi": "/",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t4",
          "hanzi": "中華民國九十二年四月九日星期三",
          "pinyin": "zhōng huá mín guó jiǔ shí èr nián sì yuè jiǔ rì xīng qī sān",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "解放伊拉克見六版專頁",
      "pinyin": "jiě fàng yī lā kè jiàn liù bǎn zhuān yè",
      "translation": null,
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "解放伊拉克",
          "pinyin": "jiě fàng yī lā kè",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t2",
          "hanzi": "見六版專頁",
          "pinyin": "jiàn liù bǎn zhuān yè",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "人事傾軋國親決策機制叫停(台聞)",
      "pinyin": "rén shì qīng yà guó qīn jué cè jī zhì jiào tíng( tái wén)",
      "translation": null,
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "人事傾軋國親決策機制叫停",
          "pinyin": "rén shì qīng yà guó qīn jué cè jī zhì jiào tíng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t2",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t3",
          "hanzi": "台聞",
          "pinyin": "tái wén",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t4",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s4",
      "hanzi": "浙億萬富翁周祖豹命案偵破(陸聞)",
      "pinyin": "zhè yì wàn fù wēng zhōu zǔ bào mìng àn zhēn pò( lù wén)",
      "translation": null,
      "tokens": [
        {
          "id": "s4-t1",
          "hanzi": "浙億萬富翁周祖豹命案偵破",
          "pinyin": "zhè yì wàn fù wēng zhōu zǔ bào mìng àn zhēn pò",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t2",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t3",
          "hanzi": "陸聞",
          "pinyin": "lù wén",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t4",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s5",
      "hanzi": "陸羽案又一幕後指使人被捕(港聞)",
      "pinyin": "lù yǔ àn yòu yí mù hòu zhǐ shǐ rén bèi bǔ( gǎng wén)",
      "translation": null,
      "tokens": [
        {
          "id": "s5-t1",
          "hanzi": "陸羽案又一幕後指使人被捕",
          "pinyin": "lù yǔ àn yòu yí mù hòu zhǐ shǐ rén bèi bǔ",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t2",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t3",
          "hanzi": "港聞",
          "pinyin": "gǎng wén",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t4",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s6",
      "hanzi": "胡錦濤關切湖南團在美車禍(綜合)",
      "pinyin": "hú jǐn tāo guān qiè hú nán tuán zài měi chē huò( zōng hé)",
      "translation": null,
      "tokens": [
        {
          "id": "s6-t1",
          "hanzi": "胡錦濤關切湖南團在美車禍",
          "pinyin": "hú jǐn tāo guān qiè hú nán tuán zài měi chē huò",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t2",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t3",
          "hanzi": "綜合",
          "pinyin": "zōng hé",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t4",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s7",
      "hanzi": "世界日報",
      "pinyin": "shì jiè rì bào",
      "translation": null,
      "tokens": [
        {
          "id": "s7-t1",
          "hanzi": "世界日報",
          "pinyin": "shì jiè rì bào",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s8",
      "hanzi": "美軍巴城開火記者三死三傷",
      "pinyin": "měi jūn bā chéng kāi huǒ jì zhě sān sǐ sān shāng",
      "translation": null,
      "tokens": [
        {
          "id": "s8-t1",
          "hanzi": "美軍巴城開火記者三死三傷",
          "pinyin": "měi jūn bā chéng kāi huǒ jì zhě sān sǐ sān shāng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s9",
      "hanzi": "西班牙批聯軍事先擇定巴勒斯坦大飯店為目標美稱屋頂有人偷襲",
      "pinyin": "xī bān yá pī lián jūn shì xiān zé dìng bā lè sī tǎn dà fàn diàn wèi mù biāo měi chēng wū dǐng yǒu rén tōu xí",
      "translation": null,
      "tokens": [
        {
          "id": "s9-t1",
          "hanzi": "西班牙批聯軍事先擇定巴勒斯坦大飯店為目標美稱屋頂有人偷襲",
          "pinyin": "xī bān yá pī lián jūn shì xiān zé dìng bā lè sī tǎn dà fàn diàn wèi mù biāo měi chēng wū dǐng yǒu rén tōu xí",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s10",
      "hanzi": "本報綜合巴格達、華盛頓八訊報導一輛美軍坦克外國記者群集的巴格達市巴組大飯店()。",
      "pinyin": "běn bào zōng hé bā gé dá、 huá shèng dùn bā xùn bào dǎo yī liàng měi jūn tǎn kè wài guó jì zhě qún jí de bā gé dá shì bā zǔ dà fàn diàn()。",
      "translation": null,
      "tokens": [
        {
          "id": "s10-t1",
          "hanzi": "本報綜合巴格達",
          "pinyin": "běn bào zōng hé bā gé dá",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t2",
          "hanzi": "、",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t3",
          "hanzi": "華盛頓八訊報導一輛美軍坦克",
          "pinyin": "huá shèng dùn bā xùn bào dǎo yī liàng měi jūn tǎn kè",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t4",
          "hanzi": "外國記者群集的巴格達市巴組大飯店",
          "pinyin": "wài guó jì zhě qún jí de bā gé dá shì bā zǔ dà fàn diàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t5",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t6",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t7",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s11",
      "hanzi": "為成兩名外國記者喪生。",
      "pinyin": "wèi chéng liǎng míng wài guó jì zhě sàng shēng。",
      "translation": null,
      "tokens": [
        {
          "id": "s11-t1",
          "hanzi": "為成兩名外國記者喪生",
          "pinyin": "wèi chéng liǎng míng wài guó jì zhě sàng shēng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t2",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s12",
      "hanzi": "阿拉伯語吉拉電視台並",
      "pinyin": "ā lā bó yǔ jí lā diàn shì tái bìng",
      "translation": null,
      "tokens": [
        {
          "id": "s12-t1",
          "hanzi": "阿拉伯語吉拉電視台並",
          "pinyin": "ā lā bó yǔ jí lā diàn shì tái bìng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s13",
      "hanzi": "美軍飛彈炸中該電視台的",
      "pinyin": "měi jūn fēi dàn zhà zhōng gāi diàn shì tái de",
      "translation": null,
      "tokens": [
        {
          "id": "s13-t1",
          "hanzi": "美軍飛彈炸中該電視台的",
          "pinyin": "měi jūn fēi dàn zhà zhōng gāi diàn shì tái de",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s14",
      "hanzi": "建築事處一名記者喪生。",
      "pinyin": "jiàn zhù shì chù yī míng jì zhě sàng shēng。",
      "translation": null,
      "tokens": [
        {
          "id": "s14-t1",
          "hanzi": "建築事處一名記者喪生",
          "pinyin": "jiàn zhù shì chù yī míng jì zhě sàng shēng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s14-t2",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s15",
      "hanzi": "角大廈日對記者喪生表示",
      "pinyin": "jiǎo dà shà rì duì jì zhě sàng shēng biǎo shì",
      "translation": null,
      "tokens": [
        {
          "id": "s15-t1",
          "hanzi": "角大廈",
          "pinyin": "jiǎo dà shà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t2",
          "hanzi": "日對記者喪生表示",
          "pinyin": "rì duì jì zhě sàng shēng biǎo shì",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s16",
      "hanzi": "並向他們的家屬致哀但",
      "pinyin": "bìng xiàng tā men de jiā shǔ zhì āi dàn",
      "translation": null,
      "tokens": [
        {
          "id": "s16-t1",
          "hanzi": "並向他們的家屬致哀但",
          "pinyin": "bìng xiàng tā men de jiā shǔ zhì āi dàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s17",
      "hanzi": "巴格達是戰區單方無法保",
      "pinyin": "bā gé dá shì zhàn qū dān fāng wú fǎ bǎo",
      "translation": null,
      "tokens": [
        {
          "id": "s17-t1",
          "hanzi": "巴格達是戰區單方無法保",
          "pinyin": "bā gé dá shì zhàn qū dān fāng wú fǎ bǎo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s18",
      "hanzi": "衛人的安全。",
      "pinyin": "wèi rén de ān quán。",
      "translation": null,
      "tokens": [
        {
          "id": "s18-t1",
          "hanzi": "衛人的安全",
          "pinyin": "wèi rén de ān quán",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t2",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s19",
      "hanzi": "炸死的記者是現年歲的",
      "pinyin": "zhà sǐ de jì zhě shì xiàn nián suì de",
      "translation": null,
      "tokens": [
        {
          "id": "s19-t1",
          "hanzi": "炸死的記者是現年",
          "pinyin": "zhà sǐ de jì zhě shì xiàn nián",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t2",
          "hanzi": "歲的",
          "pinyin": "suì de",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s20",
      "hanzi": "攝影記者波茲克",
      "pinyin": "shè yǐng jì zhě bō zī kè",
      "translation": null,
      "tokens": [
        {
          "id": "s20-t1",
          "hanzi": "攝影記者波茲克",
          "pinyin": "shè yǐng jì zhě bō zī kè",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s21",
      "hanzi": "、西班牙第五頻道現年",
      "pinyin": "、 xī bān yá dì wǔ pín dào xiàn nián",
      "translation": null,
      "tokens": [
        {
          "id": "s21-t1",
          "hanzi": "、",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t2",
          "hanzi": "西班牙第五頻道現年",
          "pinyin": "xī bān yá dì wǔ pín dào xiàn nián",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s22",
      "hanzi": "的攝影記者庫索",
      "pinyin": "de shè yǐng jì zhě kù suǒ",
      "translation": null,
      "tokens": [
        {
          "id": "s22-t1",
          "hanzi": "的攝影記者庫索",
          "pinyin": "de shè yǐng jì zhě kù suǒ",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s23",
      "hanzi": "以及實習吉拉電視台記者",
      "pinyin": "yǐ jí shí xí jí lā diàn shì tái jì zhě",
      "translation": null,
      "tokens": [
        {
          "id": "s23-t1",
          "hanzi": "以及實習吉拉電視台記者",
          "pinyin": "yǐ jí shí xí jí lā diàn shì tái jì zhě",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s24",
      "hanzi": "布()路透社有",
      "pinyin": "bù() lù tòu shè yǒu",
      "translation": null,
      "tokens": [
        {
          "id": "s24-t1",
          "hanzi": "布",
          "pinyin": "bù",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s24-t2",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s24-t3",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s24-t4",
          "hanzi": "路透社有",
          "pinyin": "lù tòu shè yǒu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s25",
      "hanzi": "記者在美軍砲擊巴勒斯坦大",
      "pinyin": "jì zhě zài měi jūn pào jī bā lè sī tǎn dà",
      "translation": null,
      "tokens": [
        {
          "id": "s25-t1",
          "hanzi": "記者在美軍砲擊巴勒斯坦大",
          "pinyin": "jì zhě zài měi jūn pào jī bā lè sī tǎn dà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s26",
      "hanzi": "事件中受傷。",
      "pinyin": "shì jiàn zhōng shòu shāng。",
      "translation": null,
      "tokens": [
        {
          "id": "s26-t1",
          "hanzi": "事件中受傷",
          "pinyin": "shì jiàn zhōng shòu shāng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s26-t2",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s27",
      "hanzi": "國中央軍區前進指揮部的說",
      "pinyin": "guó zhōng yāng jūn qū qián jìn zhǐ huī bù de shuō",
      "translation": null,
      "tokens": [
        {
          "id": "s27-t1",
          "hanzi": "國中央軍區前進指揮部的說",
          "pinyin": "guó zhōng yāng jūn qū qián jìn zhǐ huī bù de shuō",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s28",
      "hanzi": "有人從該飯店的屋頂向",
      "pinyin": "yǒu rén cóng gāi fàn diàn de wū dǐng xiàng",
      "translation": null,
      "tokens": [
        {
          "id": "s28-t1",
          "hanzi": "有人從該飯店的屋頂向",
          "pinyin": "yǒu rén cóng gāi fàn diàn de wū dǐng xiàng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s29",
      "hanzi": "非亞洲",
      "pinyin": "fēi yà zhōu",
      "translation": null,
      "tokens": [
        {
          "id": "s29-t1",
          "hanzi": "非亞洲",
          "pinyin": "fēi yà zhōu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s30",
      "hanzi": "促勿歧視指美已",
      "pinyin": "cù wù qí shì zhǐ měi yǐ",
      "translation": null,
      "tokens": [
        {
          "id": "s30-t1",
          "hanzi": "促勿歧視指美已",
          "pinyin": "cù wù qí shì zhǐ měi yǐ",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s31",
      "hanzi": "本報綜合八日電訊報導",
      "pinyin": "běn bào zōng hé bā rì diàn xùn bào dǎo",
      "translation": null,
      "tokens": [
        {
          "id": "s31-t1",
          "hanzi": "本報綜合八日電訊報導",
          "pinyin": "běn bào zōng hé bā rì diàn xùn bào dǎo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s32",
      "hanzi": "到中國大陸調查嚴重急性呼吸",
      "pinyin": "dào zhōng guó dà lù diào chá yán zhòng jí xìng hū xī",
      "translation": null,
      "tokens": [
        {
          "id": "s32-t1",
          "hanzi": "到中國大陸調查嚴重急性呼吸",
          "pinyin": "dào zhōng guó dà lù diào chá yán zhòng jí xìng hū xī",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s33",
      "hanzi": "道症候群()疫情的世界衛生組織()專家",
      "pinyin": "dào zhèng hòu qún() yì qíng de shì jiè wèi shēng zǔ zhī() zhuān jiā",
      "translation": null,
      "tokens": [
        {
          "id": "s33-t1",
          "hanzi": "道症候群",
          "pinyin": "dào zhèng hòu qún",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s33-t2",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s33-t3",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s33-t4",
          "hanzi": "疫情的世界衛生組織",
          "pinyin": "yì qíng de shì jiè wèi shēng zǔ zhī",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s33-t5",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s33-t6",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s33-t7",
          "hanzi": "專家",
          "pinyin": "zhuān jiā",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s34",
      "hanzi": "日結束在起源地廣東",
      "pinyin": "rì jié shù zài qǐ yuán dì guǎng dōng",
      "translation": null,
      "tokens": [
        {
          "id": "s34-t1",
          "hanzi": "日結束在",
          "pinyin": "rì jié shù zài",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s34-t2",
          "hanzi": "起源地廣東",
          "pinyin": "qǐ yuán dì guǎng dōng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s35",
      "hanzi": "省的調查訪問他們此行並沒",
      "pinyin": "shěng de diào chá fǎng wèn tā men cǐ xíng bìng méi",
      "translation": null,
      "tokens": [
        {
          "id": "s35-t1",
          "hanzi": "省的調查訪問他們此行並沒",
          "pinyin": "shěng de diào chá fǎng wèn tā men cǐ xíng bìng méi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s36",
      "hanzi": "有突破性發現但表示一旦大",
      "pinyin": "yǒu tū pò xìng fā xiàn dàn biǎo shì yí dàn dà",
      "translation": null,
      "tokens": [
        {
          "id": "s36-t1",
          "hanzi": "有突破性發現但表示一旦大",
          "pinyin": "yǒu tū pò xìng fā xiàn dàn biǎo shì yí dàn dà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s37",
      "hanzi": "陸提供病患標本未來數月或",
      "pinyin": "lù tí gōng bìng huàn biāo běn wèi lái shù yuè huò",
      "translation": null,
      "tokens": [
        {
          "id": "s37-t1",
          "hanzi": "陸提供病患標本未來數月或",
          "pinyin": "lù tí gōng bìng huàn biāo běn wèi lái shù yuè huò",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s38",
      "hanzi": "數月對此病的了解應會有很大",
      "pinyin": "shù yuè duì cǐ bìng de liáo jiě yīng huì yǒu hěn dà",
      "translation": null,
      "tokens": [
        {
          "id": "s38-t1",
          "hanzi": "數月對此病的了解應會有很大",
          "pinyin": "shù yuè duì cǐ bìng de liáo jiě yīng huì yǒu hěn dà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s39",
      "hanzi": "進展。",
      "pinyin": "jìn zhǎn。",
      "translation": null,
      "tokens": [
        {
          "id": "s39-t1",
          "hanzi": "進展",
          "pinyin": "jìn zhǎn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s39-t2",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s40",
      "hanzi": "由於醫學專家普遍懷疑",
      "pinyin": "yóu yú yī xué zhuān jiā pǔ biàn huái yí",
      "translation": null,
      "tokens": [
        {
          "id": "s40-t1",
          "hanzi": "由於醫學專家普遍懷疑",
          "pinyin": "yóu yú yī xué zhuān jiā pǔ biàn huái yí",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s41",
      "hanzi": "源於大陸華盛頓加拿大",
      "pinyin": "yuán yú dà lù huá shèng dùn jiā ná dà",
      "translation": null,
      "tokens": [
        {
          "id": "s41-t1",
          "hanzi": "源於大陸華盛頓加拿大",
          "pinyin": "yuán yú dà lù huá shèng dùn jiā ná dà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s42",
      "hanzi": "人抱怨因此被歧視美國疾病",
      "pinyin": "rén bào yuàn yīn cǐ bèi qí shì měi guó jí bìng",
      "translation": null,
      "tokens": [
        {
          "id": "s42-t1",
          "hanzi": "人抱怨因此被歧視美國疾病",
          "pinyin": "rén bào yuàn yīn cǐ bèi qí shì měi guó jí bìng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s43",
      "hanzi": "防治中心()主管萊莉",
      "pinyin": "fáng zhì zhōng xīn() zhǔ guǎn lái lì",
      "translation": null,
      "tokens": [
        {
          "id": "s43-t1",
          "hanzi": "防治中心",
          "pinyin": "fáng zhì zhōng xīn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s43-t2",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s43-t3",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s43-t4",
          "hanzi": "主管萊莉",
          "pinyin": "zhǔ guǎn lái lì",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s44",
      "hanzi": "葛柏汀日警告不應有此歧",
      "pinyin": "gé bǎi tīng rì jǐng gào bù yīng yǒu cǐ qí",
      "translation": null,
      "tokens": [
        {
          "id": "s44-t1",
          "hanzi": "葛柏汀",
          "pinyin": "gé bǎi tīng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s44-t2",
          "hanzi": "日警告不應有此歧",
          "pinyin": "rì jǐng gào bù yīng yǒu cǐ qí",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s45",
      "hanzi": "視因為此病不是亞洲人特有",
      "pinyin": "shì yīn wèi cǐ bìng bú shì yà zhōu rén tè yǒu",
      "translation": null,
      "tokens": [
        {
          "id": "s45-t1",
          "hanzi": "視因為此病不是亞洲人特有",
          "pinyin": "shì yīn wèi cǐ bìng bú shì yà zhōu rén tè yǒu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s46",
      "hanzi": "的疾病。",
      "pinyin": "de jí bìng。",
      "translation": null,
      "tokens": [
        {
          "id": "s46-t1",
          "hanzi": "的疾病",
          "pinyin": "de jí bìng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s46-t2",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s47",
      "hanzi": "她還表示美國迄今已控制",
      "pinyin": "tā hái biǎo shì měi guó qì jīn yǐ kòng zhì",
      "translation": null,
      "tokens": [
        {
          "id": "s47-t1",
          "hanzi": "她還表示美國迄今已控制",
          "pinyin": "tā hái biǎo shì měi guó qì jīn yǐ kòng zhì",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s48",
      "hanzi": "此病可能擴散的威脅。",
      "pinyin": "cǐ bìng kě néng kuò sàn de wēi xié。",
      "translation": null,
      "tokens": [
        {
          "id": "s48-t1",
          "hanzi": "此病可能擴散的威脅",
          "pinyin": "cǐ bìng kě néng kuò sàn de wēi xié",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s48-t2",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s49",
      "hanzi": "時代雜誌()網站",
      "pinyin": "shí dài zá zhì() wǎng zhàn",
      "translation": null,
      "tokens": [
        {
          "id": "s49-t1",
          "hanzi": "時代雜誌",
          "pinyin": "shí dài zá zhì",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s49-t2",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s49-t3",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s49-t4",
          "hanzi": "網站",
          "pinyin": "wǎng zhàn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s50",
      "hanzi": "日報導北京醫師江延永(譯",
      "pinyin": "rì bào dǎo běi jīng yī shī jiāng yán yǒng( yì",
      "translation": null,
      "tokens": [
        {
          "id": "s50-t1",
          "hanzi": "日報導北京醫師江延永",
          "pinyin": "rì bào dǎo běi jīng yī shī jiāng yán yǒng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s50-t2",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s50-t3",
          "hanzi": "譯",
          "pinyin": "yì",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s51",
      "hanzi": "音)在給該雜誌的署名聲明",
      "pinyin": "yīn) zài gěi gāi zá zhì de shǔ míng shēng míng",
      "translation": null,
      "tokens": [
        {
          "id": "s51-t1",
          "hanzi": "音",
          "pinyin": "yīn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s51-t2",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s51-t3",
          "hanzi": "在給該雜誌的署名聲明",
          "pinyin": "zài gěi gāi zá zhì de shǔ míng shēng míng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s52",
      "hanzi": "中對大陸衛生部說的北京病",
      "pinyin": "zhōng duì dà lù wèi shēng bù shuō de běi jīng bìng",
      "translation": null,
      "tokens": [
        {
          "id": "s52-t1",
          "hanzi": "中對大陸衛生部說的北京病",
          "pinyin": "zhōng duì dà lù wèi shēng bù shuō de běi jīng bìng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s53",
      "hanzi": "患數目提出質疑認為實際人",
      "pinyin": "huàn shù mù tí chū zhì yí rèn wèi shí jì rén",
      "translation": null,
      "tokens": [
        {
          "id": "s53-t1",
          "hanzi": "患數目提出質疑認為實際人",
          "pinyin": "huàn shù mù tí chū zhì yí rèn wèi shí jì rén",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s54",
      "hanzi": "數應該高出官方數字很多因",
      "pinyin": "shù yīng gāi gāo chū guān fāng shù zì hěn duō yīn",
      "translation": null,
      "tokens": [
        {
          "id": "s54-t1",
          "hanzi": "數應該高出官方數字很多因",
          "pinyin": "shù yīng gāi gāo chū guān fāng shù zì hěn duō yīn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s55",
      "hanzi": "加拿大",
      "pinyin": "jiā ná dà",
      "translation": null,
      "tokens": [
        {
          "id": "s55-t1",
          "hanzi": "加拿大",
          "pinyin": "jiā ná dà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s56",
      "hanzi": "由於經濟",
      "pinyin": "yóu yú jīng jì",
      "translation": null,
      "tokens": [
        {
          "id": "s56-t1",
          "hanzi": "由於經濟",
          "pinyin": "yóu yú jīng jì",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s57",
      "hanzi": "疫情",
      "pinyin": "yì qíng",
      "translation": null,
      "tokens": [
        {
          "id": "s57-t1",
          "hanzi": "疫情",
          "pinyin": "yì qíng",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s58",
      "hanzi": "少飛香港",
      "pinyin": "shǎo fēi xiāng gǎng",
      "translation": null,
      "tokens": [
        {
          "id": "s58-t1",
          "hanzi": "少飛香港",
          "pinyin": "shǎo fēi xiāng gǎng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s59",
      "hanzi": "機飛香港",
      "pinyin": "jī fēi xiāng gǎng",
      "translation": null,
      "tokens": [
        {
          "id": "s59-t1",
          "hanzi": "機飛香港",
          "pinyin": "jī fēi xiāng gǎng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s60",
      "hanzi": "飛到九龍",
      "pinyin": "fēi dào jiǔ lóng",
      "translation": null,
      "tokens": [
        {
          "id": "s60-t1",
          "hanzi": "飛到九龍",
          "pinyin": "fēi dào jiǔ lóng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s61",
      "hanzi": "據法新社",
      "pinyin": "jù fǎ xīn shè",
      "translation": null,
      "tokens": [
        {
          "id": "s61-t1",
          "hanzi": "據法新社",
          "pinyin": "jù fǎ xīn shè",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s62",
      "hanzi": "日已達",
      "pinyin": "rì yǐ dá",
      "translation": null,
      "tokens": [
        {
          "id": "s62-t1",
          "hanzi": "日已達",
          "pinyin": "rì yǐ dá",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s63",
      "hanzi": "亡大陸",
      "pinyin": "wáng dà lù",
      "translation": null,
      "tokens": [
        {
          "id": "s63-t1",
          "hanzi": "亡大陸",
          "pinyin": "wáng dà lù",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s64",
      "hanzi": "個人",
      "pinyin": "gè rén",
      "translation": null,
      "tokens": [
        {
          "id": "s64-t1",
          "hanzi": "個",
          "pinyin": "gè",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s64-t2",
          "hanzi": "人",
          "pinyin": "rén",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s65",
      "hanzi": "病例",
      "pinyin": "bìng lì",
      "translation": null,
      "tokens": [
        {
          "id": "s65-t1",
          "hanzi": "病例",
          "pinyin": "bìng lì",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s66",
      "hanzi": "三是加拿",
      "pinyin": "sān shì jiā ná",
      "translation": null,
      "tokens": [
        {
          "id": "s66-t1",
          "hanzi": "三是加拿",
          "pinyin": "sān shì jiā ná",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s67",
      "hanzi": "人死亡",
      "pinyin": "rén sǐ wáng",
      "translation": null,
      "tokens": [
        {
          "id": "s67-t1",
          "hanzi": "人死亡",
          "pinyin": "rén sǐ wáng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s68",
      "hanzi": "個美國",
      "pinyin": "gè měi guó",
      "translation": null,
      "tokens": [
        {
          "id": "s68-t1",
          "hanzi": "個美國",
          "pinyin": "gè měi guó",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s69",
      "hanzi": "都沒人死亡",
      "pinyin": "dōu méi rén sǐ wáng",
      "translation": null,
      "tokens": [
        {
          "id": "s69-t1",
          "hanzi": "都沒人死亡",
          "pinyin": "dōu méi rén sǐ wáng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s70",
      "hanzi": "日",
      "pinyin": "rì",
      "translation": null,
      "tokens": [
        {
          "id": "s70-t1",
          "hanzi": "日",
          "pinyin": "rì",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s71",
      "hanzi": "病例數布在",
      "pinyin": "bìng lì shù bù zài",
      "translation": null,
      "tokens": [
        {
          "id": "s71-t1",
          "hanzi": "病例數布在",
          "pinyin": "bìng lì shù bù zài",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s72",
      "hanzi": "個結",
      "pinyin": "gè jié",
      "translation": null,
      "tokens": [
        {
          "id": "s72-t1",
          "hanzi": "個結",
          "pinyin": "gè jié",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s73",
      "hanzi": "鎮州個",
      "pinyin": "zhèn zhōu gè",
      "translation": null,
      "tokens": [
        {
          "id": "s73-t1",
          "hanzi": "鎮州",
          "pinyin": "zhèn zhōu",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s73-t2",
          "hanzi": "個",
          "pinyin": "gè",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s74",
      "hanzi": "葛柏汀",
      "pinyin": "gé bǎi tīng",
      "translation": null,
      "tokens": [
        {
          "id": "s74-t1",
          "hanzi": "葛柏汀",
          "pinyin": "gé bǎi tīng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s75",
      "hanzi": "會員的選舉",
      "pinyin": "huì yuán de xuǎn jǔ",
      "translation": null,
      "tokens": [
        {
          "id": "s75-t1",
          "hanzi": "會員的選舉",
          "pinyin": "huì yuán de xuǎn jǔ",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s76",
      "hanzi": "亞洲人的疾",
      "pinyin": "yà zhōu rén de jí",
      "translation": null,
      "tokens": [
        {
          "id": "s76-t1",
          "hanzi": "亞洲人的疾",
          "pinyin": "yà zhōu rén de jí",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s77",
      "hanzi": "地區的民眾",
      "pinyin": "dì qū de mín zhòng",
      "translation": null,
      "tokens": [
        {
          "id": "s77-t1",
          "hanzi": "地區的民眾",
          "pinyin": "dì qū de mín zhòng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s78",
      "hanzi": "的疾病。",
      "pinyin": "de jí bìng。",
      "translation": null,
      "tokens": [
        {
          "id": "s78-t1",
          "hanzi": "的疾病",
          "pinyin": "de jí bìng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s78-t2",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "西元二",
      "pinyin": "xī yuán èr",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "三年",
      "pinyin": "sān nián",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "中華民國九十二年四月九日星期三",
      "pinyin": "zhōng huá mín guó jiǔ shí èr nián sì yuè jiǔ rì xīng qī sān",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "解放伊拉克",
      "pinyin": "jiě fàng yī lā kè",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "見六版專頁",
      "pinyin": "jiàn liù bǎn zhuān yè",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "人事傾軋國親決策機制叫停",
      "pinyin": "rén shì qīng yà guó qīn jué cè jī zhì jiào tíng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "台聞",
      "pinyin": "tái wén",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "浙億萬富翁周祖豹命案偵破",
      "pinyin": "zhè yì wàn fù wēng zhōu zǔ bào mìng àn zhēn pò",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "陸聞",
      "pinyin": "lù wén",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "陸羽案又一幕後指使人被捕",
      "pinyin": "lù yǔ àn yòu yí mù hòu zhǐ shǐ rén bèi bǔ",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "港聞",
      "pinyin": "gǎng wén",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "胡錦濤關切湖南團在美車禍",
      "pinyin": "hú jǐn tāo guān qiè hú nán tuán zài měi chē huò",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "綜合",
      "pinyin": "zōng hé",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "世界日報",
      "pinyin": "shì jiè rì bào",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "美軍巴城開火記者三死三傷",
      "pinyin": "měi jūn bā chéng kāi huǒ jì zhě sān sǐ sān shāng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "西班牙批聯軍事先擇定巴勒斯坦大飯店為目標美稱屋頂有人偷襲",
      "pinyin": "xī bān yá pī lián jūn shì xiān zé dìng bā lè sī tǎn dà fàn diàn wèi mù biāo měi chēng wū dǐng yǒu rén tōu xí",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "本報綜合巴格達",
      "pinyin": "běn bào zōng hé bā gé dá",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "華盛頓八訊報導一輛美軍坦克",
      "pinyin": "huá shèng dùn bā xùn bào dǎo yī liàng měi jūn tǎn kè",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "外國記者群集的巴格達市巴組大飯店",
      "pinyin": "wài guó jì zhě qún jí de bā gé dá shì bā zǔ dà fàn diàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "為成兩名外國記者喪生",
      "pinyin": "wèi chéng liǎng míng wài guó jì zhě sàng shēng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "阿拉伯語吉拉電視台並",
      "pinyin": "ā lā bó yǔ jí lā diàn shì tái bìng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "美軍飛彈炸中該電視台的",
      "pinyin": "měi jūn fēi dàn zhà zhōng gāi diàn shì tái de",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "建築事處一名記者喪生",
      "pinyin": "jiàn zhù shì chù yī míng jì zhě sàng shēng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "角大廈",
      "pinyin": "jiǎo dà shà",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "日對記者喪生表示",
      "pinyin": "rì duì jì zhě sàng shēng biǎo shì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "並向他們的家屬致哀但",
      "pinyin": "bìng xiàng tā men de jiā shǔ zhì āi dàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "巴格達是戰區單方無法保",
      "pinyin": "bā gé dá shì zhàn qū dān fāng wú fǎ bǎo",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "衛人的安全",
      "pinyin": "wèi rén de ān quán",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "炸死的記者是現年",
      "pinyin": "zhà sǐ de jì zhě shì xiàn nián",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "歲的",
      "pinyin": "suì de",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "攝影記者波茲克",
      "pinyin": "shè yǐng jì zhě bō zī kè",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "西班牙第五頻道現年",
      "pinyin": "xī bān yá dì wǔ pín dào xiàn nián",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "的攝影記者庫索",
      "pinyin": "de shè yǐng jì zhě kù suǒ",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "以及實習吉拉電視台記者",
      "pinyin": "yǐ jí shí xí jí lā diàn shì tái jì zhě",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "布",
      "pinyin": "bù",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "路透社有",
      "pinyin": "lù tòu shè yǒu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "記者在美軍砲擊巴勒斯坦大",
      "pinyin": "jì zhě zài měi jūn pào jī bā lè sī tǎn dà",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "事件中受傷",
      "pinyin": "shì jiàn zhōng shòu shāng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "國中央軍區前進指揮部的說",
      "pinyin": "guó zhōng yāng jūn qū qián jìn zhǐ huī bù de shuō",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "有人從該飯店的屋頂向",
      "pinyin": "yǒu rén cóng gāi fàn diàn de wū dǐng xiàng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "非亞洲",
      "pinyin": "fēi yà zhōu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "促勿歧視指美已",
      "pinyin": "cù wù qí shì zhǐ měi yǐ",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "本報綜合八日電訊報導",
      "pinyin": "běn bào zōng hé bā rì diàn xùn bào dǎo",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "到中國大陸調查嚴重急性呼吸",
      "pinyin": "dào zhōng guó dà lù diào chá yán zhòng jí xìng hū xī",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "道症候群",
      "pinyin": "dào zhèng hòu qún",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "疫情的世界衛生組織",
      "pinyin": "yì qíng de shì jiè wèi shēng zǔ zhī",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "專家",
      "pinyin": "zhuān jiā",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "日結束在",
      "pinyin": "rì jié shù zài",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "起源地廣東",
      "pinyin": "qǐ yuán dì guǎng dōng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "省的調查訪問他們此行並沒",
      "pinyin": "shěng de diào chá fǎng wèn tā men cǐ xíng bìng méi",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "有突破性發現但表示一旦大",
      "pinyin": "yǒu tū pò xìng fā xiàn dàn biǎo shì yí dàn dà",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "陸提供病患標本未來數月或",
      "pinyin": "lù tí gōng bìng huàn biāo běn wèi lái shù yuè huò",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "數月對此病的了解應會有很大",
      "pinyin": "shù yuè duì cǐ bìng de liáo jiě yīng huì yǒu hěn dà",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "進展",
      "pinyin": "jìn zhǎn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "由於醫學專家普遍懷疑",
      "pinyin": "yóu yú yī xué zhuān jiā pǔ biàn huái yí",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "源於大陸華盛頓加拿大",
      "pinyin": "yuán yú dà lù huá shèng dùn jiā ná dà",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "人抱怨因此被歧視美國疾病",
      "pinyin": "rén bào yuàn yīn cǐ bèi qí shì měi guó jí bìng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "防治中心",
      "pinyin": "fáng zhì zhōng xīn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "主管萊莉",
      "pinyin": "zhǔ guǎn lái lì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "葛柏汀",
      "pinyin": "gé bǎi tīng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "日警告不應有此歧",
      "pinyin": "rì jǐng gào bù yīng yǒu cǐ qí",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "視因為此病不是亞洲人特有",
      "pinyin": "shì yīn wèi cǐ bìng bú shì yà zhōu rén tè yǒu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "的疾病",
      "pinyin": "de jí bìng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "她還表示美國迄今已控制",
      "pinyin": "tā hái biǎo shì měi guó qì jīn yǐ kòng zhì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "此病可能擴散的威脅",
      "pinyin": "cǐ bìng kě néng kuò sàn de wēi xié",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "時代雜誌",
      "pinyin": "shí dài zá zhì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "網站",
      "pinyin": "wǎng zhàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "日報導北京醫師江延永",
      "pinyin": "rì bào dǎo běi jīng yī shī jiāng yán yǒng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "譯",
      "pinyin": "yì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "音",
      "pinyin": "yīn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "在給該雜誌的署名聲明",
      "pinyin": "zài gěi gāi zá zhì de shǔ míng shēng míng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "中對大陸衛生部說的北京病",
      "pinyin": "zhōng duì dà lù wèi shēng bù shuō de běi jīng bìng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "患數目提出質疑認為實際人",
      "pinyin": "huàn shù mù tí chū zhì yí rèn wèi shí jì rén",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "數應該高出官方數字很多因",
      "pinyin": "shù yīng gāi gāo chū guān fāng shù zì hěn duō yīn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "加拿大",
      "pinyin": "jiā ná dà",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "由於經濟",
      "pinyin": "yóu yú jīng jì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "疫情",
      "pinyin": "yì qíng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "少飛香港",
      "pinyin": "shǎo fēi xiāng gǎng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "機飛香港",
      "pinyin": "jī fēi xiāng gǎng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "飛到九龍",
      "pinyin": "fēi dào jiǔ lóng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "據法新社",
      "pinyin": "jù fǎ xīn shè",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "日已達",
      "pinyin": "rì yǐ dá",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "亡大陸",
      "pinyin": "wáng dà lù",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "個",
      "pinyin": "gè",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "人",
      "pinyin": "rén",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "病例",
      "pinyin": "bìng lì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "三是加拿",
      "pinyin": "sān shì jiā ná",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "人死亡",
      "pinyin": "rén sǐ wáng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "個美國",
      "pinyin": "gè měi guó",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "都沒人死亡",
      "pinyin": "dōu méi rén sǐ wáng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "日",
      "pinyin": "rì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "病例數布在",
      "pinyin": "bìng lì shù bù zài",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "個結",
      "pinyin": "gè jié",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "鎮州",
      "pinyin": "zhèn zhōu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "會員的選舉",
      "pinyin": "huì yuán de xuǎn jǔ",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "亞洲人的疾",
      "pinyin": "yà zhōu rén de jí",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "地區的民眾",
      "pinyin": "dì qū de mín zhòng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "西元二",
  "pinyin": "xī yuán èr",
  "meaning": "AD 2; the second year of the Common Era.",
  "notes": "Short for 西元二年; used in historical or formal date contexts. In full dates, it is usually followed by 年 (year).",
  "examples": [],
  "pinyinSource": "vision_hint"
}
```

## 6. The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | baidu/qianfan-ocr-fast:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=200, latency=339.57s
- Explain endpoint: status=200, latency=1.86s

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=True, attempts=1, latency=173.44s, prompt_tokens=4127, completion_tokens=18833, total_tokens=22960, t/s=108.58
- `text analysis` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=152.36s, prompt_tokens=1425, completion_tokens=32768, total_tokens=34193, t/s=215.07
- `glossary enrichment` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=13.69s, prompt_tokens=2215, completion_tokens=2731, total_tokens=4946, t/s=199.43

### Vision Output
```json
{
  "documentText": "西元二〇〇三年/中華民國九十二年四月九日星期三\n「解放伊拉克」見六版專頁\n人事傾軋國親決策機制叫停(台聞)\n浙億萬富翁周祖豹命案偵破(陸聞)\n陸羽案又一幕後指使人被捕(港聞)\n胡錦濤關切湖南團在美車禍(綜合)\n世界日報\nWorld Journal\n美軍巴城開火記者三死三傷\n西班牙批聯軍事先擇定巴勒斯坦大飯店為目標美稱屋頂有人偷襲\n本報綜合巴格達、華盛頓八訊報導一輛美軍坦克8外國記者群集的巴格達市巴組大飯店(Palestine Hotel)。為成兩名外國記者喪生。\n阿拉伯語吉拉電視台並\n美軍飛彈炸中該電視台的\n建築事處一名記者喪生。\n角大廈8日對記者喪生表示\n並向他們的家屬致哀但\n巴格達是戰區單方無法保\n衛人的安全。\n炸死的記者是現年35歲的\n攝影記者波茲克(Taras\nuk)、西班牙第五頻道現年\n的攝影記者庫索(Jose\n)以及實習吉拉電視台記者\n布(Tareq Ayub) 路透社有\n記者在美軍砲擊巴勒斯坦大\n事件中受傷。\n國中央軍事前進指揮部的說\n有人從該飯店的屋頂向\nC D C SARS非亞洲\n促勿歧視指美已\n【本報綜合八日電訊報導】\n到中國大陸調查嚴重急性呼吸\n道症候群(SARS)疫情的世界衛生組織(WHO)專家8\n日結束在SARS起源地廣東\n省的調查訪問他們此行並沒\n有突破性發現但表示一旦大\n陸提供病患標本未來數月或\n數月對此病的了解應會有很大\n進展。\n由於醫學專家普遍懷疑\nSARS源於大陸華盛頓加拿大\n人抱怨因此被歧視美國疾病\n防治中心(CDC)主管萊莉\n葛柏汀8日警告不應有此歧\n視因為此病不是亞洲人特有\n的疾病。\n她還表示美國迄今已控制\n此病可能擴散的威脅。\n時代雜誌(Time)網站8\n日報導北京醫師江延永(譯\n音)在給該雜誌的署名聲明\n中對大陸衛生部說的北京病\n患數目提出質疑認為實際人\n數應該高出官方數字很多因\n加拿大\n由於經濟\nSARS疫情\n少飛香港\n機飛香港\n飛到九莊\n據法新社\n日已達28\n亡大陸\n個53人\n病例928\n三是加拿\n10人死亡\n個美國\n都沒人死亡\nCDC8日\n病例數布在\n38個結\n鎮州9個\n葛柏汀\n會員的選舉\n亞洲人的疾\n地區的民眾\n的疾病。",
  "language": "zh-Hant",
  "readingLines": [
    "西元二〇〇三年/中華民國九十二年四月九日星期三",
    "「解放伊拉克」見六版專頁",
    "人事傾軋國親決策機制叫停(台聞)",
    "浙億萬富翁周祖豹命案偵破(陸聞)",
    "陸羽案又一幕後指使人被捕(港聞)",
    "胡錦濤關切湖南團在美車禍(綜合)",
    "世界日報",
    "World Journal",
    "美軍巴城開火記者三死三傷",
    "西班牙批聯軍事先擇定巴勒斯坦大飯店為目標美稱屋頂有人偷襲",
    "本報綜合巴格達、華盛頓八訊報導一輛美軍坦克8外國記者群集的巴格達市巴組大飯店(Palestine Hotel)。為成兩名外國記者喪生。",
    "阿拉伯語吉拉電視台並",
    "美軍飛彈炸中該電視台的\n建築事處一名記者喪生。",
    "角大廈8日對記者喪生表示\n並向他們的家屬致哀但\n巴格達是戰區單方無法保\n衛人的安全。",
    "炸死的記者是現年35歲的\n攝影記者波茲克(Taras\nuk)、西班牙第五頻道現年\n的攝影記者庫索(Jose\n)以及實習吉拉電視台記者\n布(Tareq Ayub) 路透社有\n記者在美軍砲擊巴勒斯坦大\n事件中受傷。",
    "國中央軍事前進指揮部的說\n有人從該飯店的屋頂向",
    "C D C SARS非亞洲\n促勿歧視指美已",
    "【本報綜合八日電訊報導】\n到中國大陸調查嚴重急性呼吸\n道症候群(SARS)疫情的世界衛生組織(WHO)專家8\n日結束在SARS起源地廣東\n省的調查訪問他們此行並沒\n有突破性發現但表示一旦大\n陸提供病患標本未來數月或\n數月對此病的了解應會有很大\n進展。",
    "由於醫學專家普遍懷疑\nSARS源於大陸華盛頓加拿大\n人抱怨因此被歧視美國疾病\n防治中心(CDC)主管萊莉\n葛柏汀8日警告不應有此歧\n視因為此病不是亞洲人特有\n的疾病。",
    "她還表示美國迄今已控制\n此病可能擴散的威脅。",
    "時代雜誌(Time)網站8\n日報導北京醫師江延永(譯\n音)在給該雜誌的署名聲明\n中對大陸衛生部說的北京病\n患數目提出質疑認為實際人\n數應該高出官方數字很多因",
    "加拿大\n由於經濟\nSARS疫情\n少飛香港\n機飛香港\n飛到九莊\n據法新社\n日已達28\n亡大陸\n個53人\n病例928\n三是加拿\n10人死亡\n個美國\n都沒人死亡\nCDC8日\n病例數布在\n38個結\n鎮州9個\n葛柏汀\n會員的選舉\n亞洲人的疾\n地區的民眾\n的疾病。"
  ],
  "pronunciationHints": [],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [],
  "glossary": [],
  "pronunciationHints": []
}
```

### Glossary Enrichment Output
```json
{
  "entries": [
    {
      "text": "西元二〇〇三年/中華民國九十二年四月九日星期三/解放伊拉克/見六版專頁/人事傾軋國親決策機制叫停/台聞/浙億萬富翁周祖豹命案偵破/陸聞/陸羽案又一幕後指使人被捕/港聞/胡錦濤關切湖南團在美車禍/綜合/世界日報/美軍巴城開火記者三死三傷/西班牙批聯軍事先擇定巴勒斯坦大飯店為目標美稱屋頂有人偷襲/本報綜合巴格達/華盛頓八訊報導一輛美軍坦克/外國記者群集的巴格達市巴組大飯店/為成兩名外國記者喪生/阿拉伯語吉拉電視台並/美軍飛彈炸中該電視台的/建築事處一名記者喪生/角大廈/日對記者喪生表示/並向他們的家屬致哀但/巴格達是戰區單方無法保衛人的安全/炸死的記者是現年/歲的/攝影記者波茲克/西班牙第五頻道現年/的攝影記者庫索/以及實習吉拉電視台記者/布/路透社有/記者在美軍砲擊巴勒斯坦大/事件中受傷/國中央軍事前進指揮部的說/有人從該飯店的屋頂向/C D C SARS非亞洲/促勿歧視指美已/【本報綜合八日電訊報導】/到中國大陸調查嚴重急性呼吸/道症候群/SARS疫情的世界衛生組織/專家/日結束在/起源地廣東/省的調查訪問他們此行並沒/有突破性發現但表示一旦大/陸提供病患標本未來數月或/數月對此病的了解應會有很大/進展/由於醫學專家普遍懷疑/SARS源於大陸華盛頓加拿大/人抱怨因此被歧視美國疾病/防治中心/主管萊莉/葛柏汀/日警告不應有此歧/視因為此病不是亞洲人特有/的疾病/她還表示美國迄今已控制/此病可能擴散的威脅/時代雜誌/Time/網站/日報導北京醫師江延永/譯/音/在給該雜誌的署名聲明/中對大陸衛生部說的北京病/患數目提出質疑認為實際人/數應該高出官方數字很多因/加拿大/由於經濟/SARS疫情/少飛香港/機飛香港/飛到九莊/據法新社/日已達/亡大陸/個53人/病例928/三是加拿/10人死亡/個美國/都沒人死亡/CDC8日/病例數布在/38個結/鎮州9個/葛柏汀/會員的選舉/亞洲人的疾/地區的民眾/的疾病",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "三年",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "中華民國九十二年四月九日星期三",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "解放伊拉克",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "見六版專頁",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "人事傾軋國親決策機制叫停",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "台聞",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "浙億萬富翁周祖豹命案偵破",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "陸聞",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "陸羽案又一幕後指使人被捕",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "港聞",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "胡錦濤關切湖南團在美車禍",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "綜合",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "世界日報",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "美軍巴城開火記者三死三傷",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "西班牙批聯軍事先擇定巴勒斯坦大飯店為目標美稱屋頂有人偷襲",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "本報綜合巴格達",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "華盛頓八訊報導一輛美軍坦克",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "外國記者群集的巴格達市巴組大飯店",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "為成兩名外國記者喪生",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "阿拉伯語吉拉電視台並",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "美軍飛彈炸中該電視台的",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "建築事處一名記者喪生",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "角大廈",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "日對記者喪生表示",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "並向他們的家屬致哀但",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "巴格達是戰區單方無法保",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "衛人的安全",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "炸死的記者是現年",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "歲的",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "攝影記者波茲克",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "西班牙第五頻道現年",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "的攝影記者庫索",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "以及實習吉拉電視台記者",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "布",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "路透社有",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "記者在美軍砲擊巴勒斯坦大",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "事件中受傷",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "國中央軍事前進指揮部的說",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "有人從該飯店的屋頂向",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "非亞洲",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "促勿歧視指美已",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "本報綜合八日電訊報導",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "到中國大陸調查嚴重急性呼吸",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "道症候群",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "疫情的世界衛生組織",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "專家",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "日結束在",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "起源地廣東",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "省的調查訪問他們此行並沒",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "有突破性發現但表示一旦大",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "陸提供病患標本未來數月或",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "數月對此病的了解應會有很大",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "進展",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "由於醫學專家普遍懷疑",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "源於大陸華盛頓加拿大",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "人抱怨因此被歧視美國疾病",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "防治中心",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "主管萊莉",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "葛柏汀",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "日警告不應有此歧",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "視因為此病不是亞洲人特有",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "的疾病",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "她還表示美國迄今已控制",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "此病可能擴散的威脅",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "時代雜誌",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "網站",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "日報導北京醫師江延永",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "譯",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "音",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "在給該雜誌的署名聲明",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "中對大陸衛生部說的北京病",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "患數目提出質疑認為實際人",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "數應該高出官方數字很多因",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "加拿大",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "由於經濟",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "疫情",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "少飛香港",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "機飛香港",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "飛到九莊",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "據法新社",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "日已達",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "亡大陸",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "個",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "人",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "病例",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "三是加拿",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "人死亡",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "個美國",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "都沒人死亡",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "日",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "病例數布在",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "個結",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "鎮州",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "會員的選舉",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "亞洲人的疾",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "地區的民眾",
      "literalMeaning": null,
      "exampleSentence": null
    }
  ]
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "西元二〇〇三年/中華民國九十二年四月九日星期三\n「解放伊拉克」見六版專頁\n人事傾軋國親決策機制叫停(台聞)\n浙億萬富翁周祖豹命案偵破(陸聞)\n陸羽案又一幕後指使人被捕(港聞)\n胡錦濤關切湖南團在美車禍(綜合)\n世界日報\nWorld Journal\n美軍巴城開火記者三死三傷\n西班牙批聯軍事先擇定巴勒斯坦大飯店為目標美稱屋頂有人偷襲\n本報綜合巴格達、華盛頓八訊報導一輛美軍坦克8外國記者群集的巴格達市巴組大飯店(Palestine Hotel)。為成兩名外國記者喪生。\n阿拉伯語吉拉電視台並\n美軍飛彈炸中該電視台的\n建築事處一名記者喪生。\n角大廈8日對記者喪生表示\n並向他們的家屬致哀但\n巴格達是戰區單方無法保\n衛人的安全。\n炸死的記者是現年35歲的\n攝影記者波茲克(Taras\nuk)、西班牙第五頻道現年\n的攝影記者庫索(Jose\n)以及實習吉拉電視台記者\n布(Tareq Ayub) 路透社有\n記者在美軍砲擊巴勒斯坦大\n事件中受傷。\n國中央軍事前進指揮部的說\n有人從該飯店的屋頂向\nC D C SARS非亞洲\n促勿歧視指美已\n【本報綜合八日電訊報導】\n到中國大陸調查嚴重急性呼吸\n道症候群(SARS)疫情的世界衛生組織(WHO)專家8\n日結束在SARS起源地廣東\n省的調查訪問他們此行並沒\n有突破性發現但表示一旦大\n陸提供病患標本未來數月或\n數月對此病的了解應會有很大\n進展。\n由於醫學專家普遍懷疑\nSARS源於大陸華盛頓加拿大\n人抱怨因此被歧視美國疾病\n防治中心(CDC)主管萊莉\n葛柏汀8日警告不應有此歧\n視因為此病不是亞洲人特有\n的疾病。\n她還表示美國迄今已控制\n此病可能擴散的威脅。\n時代雜誌(Time)網站8\n日報導北京醫師江延永(譯\n音)在給該雜誌的署名聲明\n中對大陸衛生部說的北京病\n患數目提出質疑認為實際人\n數應該高出官方數字很多因\n加拿大\n由於經濟\nSARS疫情\n少飛香港\n機飛香港\n飛到九莊\n據法新社\n日已達28\n亡大陸\n個53人\n病例928\n三是加拿\n10人死亡\n個美國\n都沒人死亡\nCDC8日\n病例數布在\n38個結\n鎮州9個\n葛柏汀\n會員的選舉\n亞洲人的疾\n地區的民眾\n的疾病。",
  "language": "zh-Hant",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "西元二三年/中華民國九十二年四月九日星期三",
      "pinyin": "xī yuán èr sān nián/ zhōng huá mín guó jiǔ shí èr nián sì yuè jiǔ rì xīng qī sān",
      "translation": null,
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "西元二",
          "pinyin": "xī yuán èr",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t2",
          "hanzi": "三年",
          "pinyin": "sān nián",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t3",
          "hanzi": "/",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t4",
          "hanzi": "中華民國九十二年四月九日星期三",
          "pinyin": "zhōng huá mín guó jiǔ shí èr nián sì yuè jiǔ rì xīng qī sān",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "解放伊拉克見六版專頁",
      "pinyin": "jiě fàng yī lā kè jiàn liù bǎn zhuān yè",
      "translation": null,
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "解放伊拉克",
          "pinyin": "jiě fàng yī lā kè",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t2",
          "hanzi": "見六版專頁",
          "pinyin": "jiàn liù bǎn zhuān yè",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "人事傾軋國親決策機制叫停(台聞)",
      "pinyin": "rén shì qīng yà guó qīn jué cè jī zhì jiào tíng( tái wén)",
      "translation": null,
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "人事傾軋國親決策機制叫停",
          "pinyin": "rén shì qīng yà guó qīn jué cè jī zhì jiào tíng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t2",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t3",
          "hanzi": "台聞",
          "pinyin": "tái wén",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t4",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s4",
      "hanzi": "浙億萬富翁周祖豹命案偵破(陸聞)",
      "pinyin": "zhè yì wàn fù wēng zhōu zǔ bào mìng àn zhēn pò( lù wén)",
      "translation": null,
      "tokens": [
        {
          "id": "s4-t1",
          "hanzi": "浙億萬富翁周祖豹命案偵破",
          "pinyin": "zhè yì wàn fù wēng zhōu zǔ bào mìng àn zhēn pò",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t2",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t3",
          "hanzi": "陸聞",
          "pinyin": "lù wén",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t4",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s5",
      "hanzi": "陸羽案又一幕後指使人被捕(港聞)",
      "pinyin": "lù yǔ àn yòu yí mù hòu zhǐ shǐ rén bèi bǔ( gǎng wén)",
      "translation": null,
      "tokens": [
        {
          "id": "s5-t1",
          "hanzi": "陸羽案又一幕後指使人被捕",
          "pinyin": "lù yǔ àn yòu yí mù hòu zhǐ shǐ rén bèi bǔ",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t2",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t3",
          "hanzi": "港聞",
          "pinyin": "gǎng wén",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t4",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s6",
      "hanzi": "胡錦濤關切湖南團在美車禍(綜合)",
      "pinyin": "hú jǐn tāo guān qiè hú nán tuán zài měi chē huò( zōng hé)",
      "translation": null,
      "tokens": [
        {
          "id": "s6-t1",
          "hanzi": "胡錦濤關切湖南團在美車禍",
          "pinyin": "hú jǐn tāo guān qiè hú nán tuán zài měi chē huò",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t2",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t3",
          "hanzi": "綜合",
          "pinyin": "zōng hé",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t4",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s7",
      "hanzi": "世界日報",
      "pinyin": "shì jiè rì bào",
      "translation": null,
      "tokens": [
        {
          "id": "s7-t1",
          "hanzi": "世界日報",
          "pinyin": "shì jiè rì bào",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s8",
      "hanzi": "美軍巴城開火記者三死三傷",
      "pinyin": "měi jūn bā chéng kāi huǒ jì zhě sān sǐ sān shāng",
      "translation": null,
      "tokens": [
        {
          "id": "s8-t1",
          "hanzi": "美軍巴城開火記者三死三傷",
          "pinyin": "měi jūn bā chéng kāi huǒ jì zhě sān sǐ sān shāng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s9",
      "hanzi": "西班牙批聯軍事先擇定巴勒斯坦大飯店為目標美稱屋頂有人偷襲",
      "pinyin": "xī bān yá pī lián jūn shì xiān zé dìng bā lè sī tǎn dà fàn diàn wèi mù biāo měi chēng wū dǐng yǒu rén tōu xí",
      "translation": null,
      "tokens": [
        {
          "id": "s9-t1",
          "hanzi": "西班牙批聯軍事先擇定巴勒斯坦大飯店為目標美稱屋頂有人偷襲",
          "pinyin": "xī bān yá pī lián jūn shì xiān zé dìng bā lè sī tǎn dà fàn diàn wèi mù biāo měi chēng wū dǐng yǒu rén tōu xí",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s10",
      "hanzi": "本報綜合巴格達、華盛頓八訊報導一輛美軍坦克外國記者群集的巴格達市巴組大飯店()。",
      "pinyin": "běn bào zōng hé bā gé dá、 huá shèng dùn bā xùn bào dǎo yī liàng měi jūn tǎn kè wài guó jì zhě qún jí de bā gé dá shì bā zǔ dà fàn diàn()。",
      "translation": null,
      "tokens": [
        {
          "id": "s10-t1",
          "hanzi": "本報綜合巴格達",
          "pinyin": "běn bào zōng hé bā gé dá",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t2",
          "hanzi": "、",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t3",
          "hanzi": "華盛頓八訊報導一輛美軍坦克",
          "pinyin": "huá shèng dùn bā xùn bào dǎo yī liàng měi jūn tǎn kè",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t4",
          "hanzi": "外國記者群集的巴格達市巴組大飯店",
          "pinyin": "wài guó jì zhě qún jí de bā gé dá shì bā zǔ dà fàn diàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t5",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t6",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t7",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s11",
      "hanzi": "為成兩名外國記者喪生。",
      "pinyin": "wèi chéng liǎng míng wài guó jì zhě sàng shēng。",
      "translation": null,
      "tokens": [
        {
          "id": "s11-t1",
          "hanzi": "為成兩名外國記者喪生",
          "pinyin": "wèi chéng liǎng míng wài guó jì zhě sàng shēng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t2",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s12",
      "hanzi": "阿拉伯語吉拉電視台並",
      "pinyin": "ā lā bó yǔ jí lā diàn shì tái bìng",
      "translation": null,
      "tokens": [
        {
          "id": "s12-t1",
          "hanzi": "阿拉伯語吉拉電視台並",
          "pinyin": "ā lā bó yǔ jí lā diàn shì tái bìng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s13",
      "hanzi": "美軍飛彈炸中該電視台的建築事處一名記者喪生。",
      "pinyin": "měi jūn fēi dàn zhà zhōng gāi diàn shì tái de jiàn zhù shì chù yī míng jì zhě sàng shēng。",
      "translation": null,
      "tokens": [
        {
          "id": "s13-t1",
          "hanzi": "美軍飛彈炸中該電視台的",
          "pinyin": "měi jūn fēi dàn zhà zhōng gāi diàn shì tái de",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t2",
          "hanzi": "建築事處一名記者喪生",
          "pinyin": "jiàn zhù shì chù yī míng jì zhě sàng shēng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t3",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s14",
      "hanzi": "角大廈日對記者喪生表示並向他們的家屬致哀但巴格達是戰區單方無法保衛人的安全。",
      "pinyin": "jiǎo dà shà rì duì jì zhě sàng shēng biǎo shì bìng xiàng tā men de jiā shǔ zhì āi dàn bā gé dá shì zhàn qū dān fāng wú fǎ bǎo wèi rén de ān quán。",
      "translation": null,
      "tokens": [
        {
          "id": "s14-t1",
          "hanzi": "角大廈",
          "pinyin": "jiǎo dà shà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s14-t2",
          "hanzi": "日對記者喪生表示",
          "pinyin": "rì duì jì zhě sàng shēng biǎo shì",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s14-t3",
          "hanzi": "並向他們的家屬致哀但",
          "pinyin": "bìng xiàng tā men de jiā shǔ zhì āi dàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s14-t4",
          "hanzi": "巴格達是戰區單方無法保",
          "pinyin": "bā gé dá shì zhàn qū dān fāng wú fǎ bǎo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s14-t5",
          "hanzi": "衛人的安全",
          "pinyin": "wèi rén de ān quán",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s14-t6",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s15",
      "hanzi": "炸死的記者是現年歲的攝影記者波茲克()、西班牙第五頻道現年的攝影記者庫索()以及實習吉拉電視台記者布()路透社有記者在美軍砲擊巴勒斯坦大事件中受傷。",
      "pinyin": "zhà sǐ de jì zhě shì xiàn nián suì de shè yǐng jì zhě bō zī kè()、 xī bān yá dì wǔ pín dào xiàn nián de shè yǐng jì zhě kù suǒ() yǐ jí shí xí jí lā diàn shì tái jì zhě bù() lù tòu shè yǒu jì zhě zài měi jūn pào jī bā lè sī tǎn dà shì jiàn zhōng shòu shāng。",
      "translation": null,
      "tokens": [
        {
          "id": "s15-t1",
          "hanzi": "炸死的記者是現年",
          "pinyin": "zhà sǐ de jì zhě shì xiàn nián",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t2",
          "hanzi": "歲的",
          "pinyin": "suì de",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t3",
          "hanzi": "攝影記者波茲克",
          "pinyin": "shè yǐng jì zhě bō zī kè",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t4",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t5",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t6",
          "hanzi": "、",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t7",
          "hanzi": "西班牙第五頻道現年",
          "pinyin": "xī bān yá dì wǔ pín dào xiàn nián",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t8",
          "hanzi": "的攝影記者庫索",
          "pinyin": "de shè yǐng jì zhě kù suǒ",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t9",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t10",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t11",
          "hanzi": "以及實習吉拉電視台記者",
          "pinyin": "yǐ jí shí xí jí lā diàn shì tái jì zhě",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t12",
          "hanzi": "布",
          "pinyin": "bù",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t13",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t14",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t15",
          "hanzi": "路透社有",
          "pinyin": "lù tòu shè yǒu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t16",
          "hanzi": "記者在美軍砲擊巴勒斯坦大",
          "pinyin": "jì zhě zài měi jūn pào jī bā lè sī tǎn dà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t17",
          "hanzi": "事件中受傷",
          "pinyin": "shì jiàn zhōng shòu shāng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t18",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s16",
      "hanzi": "國中央軍事前進指揮部的說有人從該飯店的屋頂向",
      "pinyin": "guó zhōng yāng jūn shì qián jìn zhǐ huī bù de shuō yǒu rén cóng gāi fàn diàn de wū dǐng xiàng",
      "translation": null,
      "tokens": [
        {
          "id": "s16-t1",
          "hanzi": "國中央軍事前進指揮部的說",
          "pinyin": "guó zhōng yāng jūn shì qián jìn zhǐ huī bù de shuō",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s16-t2",
          "hanzi": "有人從該飯店的屋頂向",
          "pinyin": "yǒu rén cóng gāi fàn diàn de wū dǐng xiàng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s17",
      "hanzi": "非亞洲促勿歧視指美已",
      "pinyin": "fēi yà zhōu cù wù qí shì zhǐ měi yǐ",
      "translation": null,
      "tokens": [
        {
          "id": "s17-t1",
          "hanzi": "非亞洲",
          "pinyin": "fēi yà zhōu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s17-t2",
          "hanzi": "促勿歧視指美已",
          "pinyin": "cù wù qí shì zhǐ měi yǐ",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s18",
      "hanzi": "本報綜合八日電訊報導到中國大陸調查嚴重急性呼吸道症候群()疫情的世界衛生組織()專家日結束在起源地廣東省的調查訪問他們此行並沒有突破性發現但表示一旦大陸提供病患標本未來數月或數月對此病的了解應會有很大進展。",
      "pinyin": "běn bào zōng hé bā rì diàn xùn bào dǎo dào zhōng guó dà lù diào chá yán zhòng jí xìng hū xī dào zhèng hòu qún() yì qíng de shì jiè wèi shēng zǔ zhī() zhuān jiā rì jié shù zài qǐ yuán dì guǎng dōng shěng de diào chá fǎng wèn tā men cǐ xíng bìng méi yǒu tū pò xìng fā xiàn dàn biǎo shì yí dàn dà lù tí gōng bìng huàn biāo běn wèi lái shù yuè huò shù yuè duì cǐ bìng de liáo jiě yīng huì yǒu hěn dà jìn zhǎn。",
      "translation": null,
      "tokens": [
        {
          "id": "s18-t1",
          "hanzi": "本報綜合八日電訊報導",
          "pinyin": "běn bào zōng hé bā rì diàn xùn bào dǎo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t2",
          "hanzi": "到中國大陸調查嚴重急性呼吸",
          "pinyin": "dào zhōng guó dà lù diào chá yán zhòng jí xìng hū xī",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t3",
          "hanzi": "道症候群",
          "pinyin": "dào zhèng hòu qún",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t4",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t5",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t6",
          "hanzi": "疫情的世界衛生組織",
          "pinyin": "yì qíng de shì jiè wèi shēng zǔ zhī",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t7",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t8",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t9",
          "hanzi": "專家",
          "pinyin": "zhuān jiā",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t10",
          "hanzi": "日結束在",
          "pinyin": "rì jié shù zài",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t11",
          "hanzi": "起源地廣東",
          "pinyin": "qǐ yuán dì guǎng dōng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t12",
          "hanzi": "省的調查訪問他們此行並沒",
          "pinyin": "shěng de diào chá fǎng wèn tā men cǐ xíng bìng méi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t13",
          "hanzi": "有突破性發現但表示一旦大",
          "pinyin": "yǒu tū pò xìng fā xiàn dàn biǎo shì yí dàn dà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t14",
          "hanzi": "陸提供病患標本未來數月或",
          "pinyin": "lù tí gōng bìng huàn biāo běn wèi lái shù yuè huò",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t15",
          "hanzi": "數月對此病的了解應會有很大",
          "pinyin": "shù yuè duì cǐ bìng de liáo jiě yīng huì yǒu hěn dà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t16",
          "hanzi": "進展",
          "pinyin": "jìn zhǎn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t17",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s19",
      "hanzi": "由於醫學專家普遍懷疑源於大陸華盛頓加拿大人抱怨因此被歧視美國疾病防治中心()主管萊莉葛柏汀日警告不應有此歧視因為此病不是亞洲人特有的疾病。",
      "pinyin": "yóu yú yī xué zhuān jiā pǔ biàn huái yí yuán yú dà lù huá shèng dùn jiā ná dà rén bào yuàn yīn cǐ bèi qí shì měi guó jí bìng fáng zhì zhōng xīn() zhǔ guǎn lái lì gé bǎi tīng rì jǐng gào bù yīng yǒu cǐ qí shì yīn wèi cǐ bìng bú shì yà zhōu rén tè yǒu de jí bìng。",
      "translation": null,
      "tokens": [
        {
          "id": "s19-t1",
          "hanzi": "由於醫學專家普遍懷疑",
          "pinyin": "yóu yú yī xué zhuān jiā pǔ biàn huái yí",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t2",
          "hanzi": "源於大陸華盛頓加拿大",
          "pinyin": "yuán yú dà lù huá shèng dùn jiā ná dà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t3",
          "hanzi": "人抱怨因此被歧視美國疾病",
          "pinyin": "rén bào yuàn yīn cǐ bèi qí shì měi guó jí bìng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t4",
          "hanzi": "防治中心",
          "pinyin": "fáng zhì zhōng xīn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t5",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t6",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t7",
          "hanzi": "主管萊莉",
          "pinyin": "zhǔ guǎn lái lì",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t8",
          "hanzi": "葛柏汀",
          "pinyin": "gé bǎi tīng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t9",
          "hanzi": "日警告不應有此歧",
          "pinyin": "rì jǐng gào bù yīng yǒu cǐ qí",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t10",
          "hanzi": "視因為此病不是亞洲人特有",
          "pinyin": "shì yīn wèi cǐ bìng bú shì yà zhōu rén tè yǒu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t11",
          "hanzi": "的疾病",
          "pinyin": "de jí bìng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t12",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s20",
      "hanzi": "她還表示美國迄今已控制此病可能擴散的威脅。",
      "pinyin": "tā hái biǎo shì měi guó qì jīn yǐ kòng zhì cǐ bìng kě néng kuò sàn de wēi xié。",
      "translation": null,
      "tokens": [
        {
          "id": "s20-t1",
          "hanzi": "她還表示美國迄今已控制",
          "pinyin": "tā hái biǎo shì měi guó qì jīn yǐ kòng zhì",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s20-t2",
          "hanzi": "此病可能擴散的威脅",
          "pinyin": "cǐ bìng kě néng kuò sàn de wēi xié",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s20-t3",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s21",
      "hanzi": "時代雜誌()網站日報導北京醫師江延永(譯音)在給該雜誌的署名聲明中對大陸衛生部說的北京病患數目提出質疑認為實際人數應該高出官方數字很多因",
      "pinyin": "shí dài zá zhì() wǎng zhàn rì bào dǎo běi jīng yī shī jiāng yán yǒng( yì yīn) zài gěi gāi zá zhì de shǔ míng shēng míng zhōng duì dà lù wèi shēng bù shuō de běi jīng bìng huàn shù mù tí chū zhì yí rèn wèi shí jì rén shù yīng gāi gāo chū guān fāng shù zì hěn duō yīn",
      "translation": null,
      "tokens": [
        {
          "id": "s21-t1",
          "hanzi": "時代雜誌",
          "pinyin": "shí dài zá zhì",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t2",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t3",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t4",
          "hanzi": "網站",
          "pinyin": "wǎng zhàn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t5",
          "hanzi": "日報導北京醫師江延永",
          "pinyin": "rì bào dǎo běi jīng yī shī jiāng yán yǒng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t6",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t7",
          "hanzi": "譯",
          "pinyin": "yì",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t8",
          "hanzi": "音",
          "pinyin": "yīn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t9",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t10",
          "hanzi": "在給該雜誌的署名聲明",
          "pinyin": "zài gěi gāi zá zhì de shǔ míng shēng míng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t11",
          "hanzi": "中對大陸衛生部說的北京病",
          "pinyin": "zhōng duì dà lù wèi shēng bù shuō de běi jīng bìng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t12",
          "hanzi": "患數目提出質疑認為實際人",
          "pinyin": "huàn shù mù tí chū zhì yí rèn wèi shí jì rén",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t13",
          "hanzi": "數應該高出官方數字很多因",
          "pinyin": "shù yīng gāi gāo chū guān fāng shù zì hěn duō yīn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s22",
      "hanzi": "加拿大由於經濟疫情少飛香港機飛香港飛到九莊據法新社日已達亡大陸個人病例三是加拿人死亡個美國都沒人死亡日病例數布在個結鎮州個葛柏汀會員的選舉亞洲人的疾地區的民眾的疾病。",
      "pinyin": "jiā ná dà yóu yú jīng jì yì qíng shǎo fēi xiāng gǎng jī fēi xiāng gǎng fēi dào jiǔ zhuāng jù fǎ xīn shè rì yǐ dá wáng dà lù gè rén bìng lì sān shì jiā ná rén sǐ wáng gè měi guó dōu méi rén sǐ wáng rì bìng lì shù bù zài gè jié zhèn zhōu gè gé bǎi tīng huì yuán de xuǎn jǔ yà zhōu rén de jí dì qū de mín zhòng de jí bìng。",
      "translation": null,
      "tokens": [
        {
          "id": "s22-t1",
          "hanzi": "加拿大",
          "pinyin": "jiā ná dà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t2",
          "hanzi": "由於經濟",
          "pinyin": "yóu yú jīng jì",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t3",
          "hanzi": "疫情",
          "pinyin": "yì qíng",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t4",
          "hanzi": "少飛香港",
          "pinyin": "shǎo fēi xiāng gǎng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t5",
          "hanzi": "機飛香港",
          "pinyin": "jī fēi xiāng gǎng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t6",
          "hanzi": "飛到九莊",
          "pinyin": "fēi dào jiǔ zhuāng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t7",
          "hanzi": "據法新社",
          "pinyin": "jù fǎ xīn shè",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t8",
          "hanzi": "日已達",
          "pinyin": "rì yǐ dá",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t9",
          "hanzi": "亡大陸",
          "pinyin": "wáng dà lù",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t10",
          "hanzi": "個",
          "pinyin": "gè",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t11",
          "hanzi": "人",
          "pinyin": "rén",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t12",
          "hanzi": "病例",
          "pinyin": "bìng lì",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t13",
          "hanzi": "三是加拿",
          "pinyin": "sān shì jiā ná",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t14",
          "hanzi": "人死亡",
          "pinyin": "rén sǐ wáng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t15",
          "hanzi": "個美國",
          "pinyin": "gè měi guó",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t16",
          "hanzi": "都沒人死亡",
          "pinyin": "dōu méi rén sǐ wáng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t17",
          "hanzi": "日",
          "pinyin": "rì",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t18",
          "hanzi": "病例數布在",
          "pinyin": "bìng lì shù bù zài",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t19",
          "hanzi": "個結",
          "pinyin": "gè jié",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t20",
          "hanzi": "鎮州",
          "pinyin": "zhèn zhōu",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t21",
          "hanzi": "個",
          "pinyin": "gè",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t22",
          "hanzi": "葛柏汀",
          "pinyin": "gé bǎi tīng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t23",
          "hanzi": "會員的選舉",
          "pinyin": "huì yuán de xuǎn jǔ",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t24",
          "hanzi": "亞洲人的疾",
          "pinyin": "yà zhōu rén de jí",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t25",
          "hanzi": "地區的民眾",
          "pinyin": "dì qū de mín zhòng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t26",
          "hanzi": "的疾病",
          "pinyin": "de jí bìng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t27",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "西元二",
      "pinyin": "xī yuán èr",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "三年",
      "pinyin": "sān nián",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "中華民國九十二年四月九日星期三",
      "pinyin": "zhōng huá mín guó jiǔ shí èr nián sì yuè jiǔ rì xīng qī sān",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "解放伊拉克",
      "pinyin": "jiě fàng yī lā kè",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "見六版專頁",
      "pinyin": "jiàn liù bǎn zhuān yè",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "人事傾軋國親決策機制叫停",
      "pinyin": "rén shì qīng yà guó qīn jué cè jī zhì jiào tíng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "台聞",
      "pinyin": "tái wén",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "浙億萬富翁周祖豹命案偵破",
      "pinyin": "zhè yì wàn fù wēng zhōu zǔ bào mìng àn zhēn pò",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "陸聞",
      "pinyin": "lù wén",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "陸羽案又一幕後指使人被捕",
      "pinyin": "lù yǔ àn yòu yí mù hòu zhǐ shǐ rén bèi bǔ",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "港聞",
      "pinyin": "gǎng wén",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "胡錦濤關切湖南團在美車禍",
      "pinyin": "hú jǐn tāo guān qiè hú nán tuán zài měi chē huò",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "綜合",
      "pinyin": "zōng hé",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "世界日報",
      "pinyin": "shì jiè rì bào",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "美軍巴城開火記者三死三傷",
      "pinyin": "měi jūn bā chéng kāi huǒ jì zhě sān sǐ sān shāng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "西班牙批聯軍事先擇定巴勒斯坦大飯店為目標美稱屋頂有人偷襲",
      "pinyin": "xī bān yá pī lián jūn shì xiān zé dìng bā lè sī tǎn dà fàn diàn wèi mù biāo měi chēng wū dǐng yǒu rén tōu xí",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "本報綜合巴格達",
      "pinyin": "běn bào zōng hé bā gé dá",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "華盛頓八訊報導一輛美軍坦克",
      "pinyin": "huá shèng dùn bā xùn bào dǎo yī liàng měi jūn tǎn kè",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "外國記者群集的巴格達市巴組大飯店",
      "pinyin": "wài guó jì zhě qún jí de bā gé dá shì bā zǔ dà fàn diàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "為成兩名外國記者喪生",
      "pinyin": "wèi chéng liǎng míng wài guó jì zhě sàng shēng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "阿拉伯語吉拉電視台並",
      "pinyin": "ā lā bó yǔ jí lā diàn shì tái bìng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "美軍飛彈炸中該電視台的",
      "pinyin": "měi jūn fēi dàn zhà zhōng gāi diàn shì tái de",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "建築事處一名記者喪生",
      "pinyin": "jiàn zhù shì chù yī míng jì zhě sàng shēng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "角大廈",
      "pinyin": "jiǎo dà shà",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "日對記者喪生表示",
      "pinyin": "rì duì jì zhě sàng shēng biǎo shì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "並向他們的家屬致哀但",
      "pinyin": "bìng xiàng tā men de jiā shǔ zhì āi dàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "巴格達是戰區單方無法保",
      "pinyin": "bā gé dá shì zhàn qū dān fāng wú fǎ bǎo",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "衛人的安全",
      "pinyin": "wèi rén de ān quán",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "炸死的記者是現年",
      "pinyin": "zhà sǐ de jì zhě shì xiàn nián",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "歲的",
      "pinyin": "suì de",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "攝影記者波茲克",
      "pinyin": "shè yǐng jì zhě bō zī kè",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "西班牙第五頻道現年",
      "pinyin": "xī bān yá dì wǔ pín dào xiàn nián",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "的攝影記者庫索",
      "pinyin": "de shè yǐng jì zhě kù suǒ",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "以及實習吉拉電視台記者",
      "pinyin": "yǐ jí shí xí jí lā diàn shì tái jì zhě",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "布",
      "pinyin": "bù",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "路透社有",
      "pinyin": "lù tòu shè yǒu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "記者在美軍砲擊巴勒斯坦大",
      "pinyin": "jì zhě zài měi jūn pào jī bā lè sī tǎn dà",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "事件中受傷",
      "pinyin": "shì jiàn zhōng shòu shāng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "國中央軍事前進指揮部的說",
      "pinyin": "guó zhōng yāng jūn shì qián jìn zhǐ huī bù de shuō",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "有人從該飯店的屋頂向",
      "pinyin": "yǒu rén cóng gāi fàn diàn de wū dǐng xiàng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "非亞洲",
      "pinyin": "fēi yà zhōu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "促勿歧視指美已",
      "pinyin": "cù wù qí shì zhǐ měi yǐ",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "本報綜合八日電訊報導",
      "pinyin": "běn bào zōng hé bā rì diàn xùn bào dǎo",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "到中國大陸調查嚴重急性呼吸",
      "pinyin": "dào zhōng guó dà lù diào chá yán zhòng jí xìng hū xī",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "道症候群",
      "pinyin": "dào zhèng hòu qún",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "疫情的世界衛生組織",
      "pinyin": "yì qíng de shì jiè wèi shēng zǔ zhī",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "專家",
      "pinyin": "zhuān jiā",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "日結束在",
      "pinyin": "rì jié shù zài",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "起源地廣東",
      "pinyin": "qǐ yuán dì guǎng dōng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "省的調查訪問他們此行並沒",
      "pinyin": "shěng de diào chá fǎng wèn tā men cǐ xíng bìng méi",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "有突破性發現但表示一旦大",
      "pinyin": "yǒu tū pò xìng fā xiàn dàn biǎo shì yí dàn dà",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "陸提供病患標本未來數月或",
      "pinyin": "lù tí gōng bìng huàn biāo běn wèi lái shù yuè huò",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "數月對此病的了解應會有很大",
      "pinyin": "shù yuè duì cǐ bìng de liáo jiě yīng huì yǒu hěn dà",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "進展",
      "pinyin": "jìn zhǎn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "由於醫學專家普遍懷疑",
      "pinyin": "yóu yú yī xué zhuān jiā pǔ biàn huái yí",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "源於大陸華盛頓加拿大",
      "pinyin": "yuán yú dà lù huá shèng dùn jiā ná dà",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "人抱怨因此被歧視美國疾病",
      "pinyin": "rén bào yuàn yīn cǐ bèi qí shì měi guó jí bìng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "防治中心",
      "pinyin": "fáng zhì zhōng xīn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "主管萊莉",
      "pinyin": "zhǔ guǎn lái lì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "葛柏汀",
      "pinyin": "gé bǎi tīng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "日警告不應有此歧",
      "pinyin": "rì jǐng gào bù yīng yǒu cǐ qí",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "視因為此病不是亞洲人特有",
      "pinyin": "shì yīn wèi cǐ bìng bú shì yà zhōu rén tè yǒu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "的疾病",
      "pinyin": "de jí bìng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "她還表示美國迄今已控制",
      "pinyin": "tā hái biǎo shì měi guó qì jīn yǐ kòng zhì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "此病可能擴散的威脅",
      "pinyin": "cǐ bìng kě néng kuò sàn de wēi xié",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "時代雜誌",
      "pinyin": "shí dài zá zhì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "網站",
      "pinyin": "wǎng zhàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "日報導北京醫師江延永",
      "pinyin": "rì bào dǎo běi jīng yī shī jiāng yán yǒng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "譯",
      "pinyin": "yì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "音",
      "pinyin": "yīn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "在給該雜誌的署名聲明",
      "pinyin": "zài gěi gāi zá zhì de shǔ míng shēng míng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "中對大陸衛生部說的北京病",
      "pinyin": "zhōng duì dà lù wèi shēng bù shuō de běi jīng bìng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "患數目提出質疑認為實際人",
      "pinyin": "huàn shù mù tí chū zhì yí rèn wèi shí jì rén",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "數應該高出官方數字很多因",
      "pinyin": "shù yīng gāi gāo chū guān fāng shù zì hěn duō yīn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "加拿大",
      "pinyin": "jiā ná dà",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "由於經濟",
      "pinyin": "yóu yú jīng jì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "疫情",
      "pinyin": "yì qíng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "少飛香港",
      "pinyin": "shǎo fēi xiāng gǎng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "機飛香港",
      "pinyin": "jī fēi xiāng gǎng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "飛到九莊",
      "pinyin": "fēi dào jiǔ zhuāng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "據法新社",
      "pinyin": "jù fǎ xīn shè",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "日已達",
      "pinyin": "rì yǐ dá",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "亡大陸",
      "pinyin": "wáng dà lù",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "個",
      "pinyin": "gè",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "人",
      "pinyin": "rén",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "病例",
      "pinyin": "bìng lì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "三是加拿",
      "pinyin": "sān shì jiā ná",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "人死亡",
      "pinyin": "rén sǐ wáng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "個美國",
      "pinyin": "gè měi guó",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "都沒人死亡",
      "pinyin": "dōu méi rén sǐ wáng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "日",
      "pinyin": "rì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "病例數布在",
      "pinyin": "bìng lì shù bù zài",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "個結",
      "pinyin": "gè jié",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "鎮州",
      "pinyin": "zhèn zhōu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "會員的選舉",
      "pinyin": "huì yuán de xuǎn jǔ",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "亞洲人的疾",
      "pinyin": "yà zhōu rén de jí",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "地區的民眾",
      "pinyin": "dì qū de mín zhòng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "西元二",
  "pinyin": "xī yuán èr",
  "meaning": "AD 2; the phrase appears in dates like '西元二三年' (AD 23) or '中華民國九十二年' (Republic of China Year 92).",
  "notes": "Commonly used in formal or historical date expressions; not a standalone year.",
  "examples": [],
  "pinyinSource": "vision_hint"
}
```

## 7. weibo_6_toutiao_comparison.jpg | auto | baidu/qianfan-ocr-fast:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=200, latency=176.95s
- Explain endpoint: status=200, latency=1.39s

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=True, attempts=1, latency=18.47s, prompt_tokens=3361, completion_tokens=1776, total_tokens=5137, t/s=96.16
- `text analysis` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=156.77s, prompt_tokens=3307, completion_tokens=32768, total_tokens=36075, t/s=209.01
- `glossary enrichment` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=1.65s, prompt_tokens=844, completion_tokens=137, total_tokens=981, t/s=83.14

### Vision Output
```json
{
  "documentText": "头条\nToutiao\n10:544G\n微头条发布\n热榜\n#怀念单田芳# 送大师最后一程\n#台风山竹# 广州停工停课\n#被讹小伙要起... 双方和解小伙发声\n#朱旭去世# 享年88岁\n韩路出品\n前天19:37知名车评人老司机App联...\n关注\n我们现在3200米海拔的四川轿顶山，大雾，本来想着气爽来看贡嘎雪山，如今成了0度99%湿度还没电的湿湿哒之旅\nMavic2近地起降场补光，像不像UFO抓地球人时候那感觉\nWeibo\n10:554G\nSearch\nFollowing hot\n斯道\n5 min ago Edited\n章子怡徐峥争论引发热议，每个导师侧重点不一样，理性讨论挺好。网友表示章子怡老师你能不能让徐峥大叔把话说完，老是打断人家这样很不好\n徐璐阚清子的表演你喜欢吗~\n央视新闻\n38 min ago from 微博 weibo.com Edited",
  "language": "zh-Hans",
  "readingLines": [
    "头条\nToutiao\n10:544G\n微头条发布\n热榜\n#怀念单田芳# 送大师最后一程\n#台风山竹# 广州停工停课\n#被讹小伙要起... 双方和解小伙发声\n#朱旭去世# 享年88岁\n韩路出品\n前天19:37知名车评人老司机App联...\n关注\n我们现在3200米海拔的四川轿顶山，大雾，本来想着气爽来看贡嘎雪山，如今成了0度99%湿度还没电的湿湿哒之旅\nMavic2近地起降场补光，像不像UFO抓地球人时候那感觉\nWeibo\n10:554G\nSearch\nFollowing hot\n斯道\n5 min ago Edited\n章子怡徐峥争论引发热议，每个导师侧重点不一样，理性讨论挺好。网友表示章子怡老师你能不能让徐峥大叔把话说完，老是打断人家这样很不好\n徐璐阚清子的表演你喜欢吗~\n央视新闻\n38 min ago from 微博 weibo.com Edited"
  ],
  "pronunciationHints": [
    {
      "phrase": "头条",
      "preferredPinyin": "tóu tiáo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Toutiao",
      "preferredPinyin": "tuóu táo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "4G",
      "preferredPinyin": "sì gē",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "微头条",
      "preferredPinyin": "wēi tóu tiáo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "发布",
      "preferredPinyin": "fā bù",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "热榜",
      "preferredPinyin": "rè bǎng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "怀念单田芳",
      "preferredPinyin": "huái niàn dān tián fāng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "送大师最后一程",
      "preferredPinyin": "sòng dà shī zuì hòu yī chéng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "台风山竹",
      "preferredPinyin": "tái fēng shān zhú",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "广州停工停课",
      "preferredPinyin": "guǎng zhōu gōng gōng tīng kè",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "被讹小伙要起",
      "preferredPinyin": "bèi é hǎo xiǎo yào qǐ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "双方和解小伙发声",
      "preferredPinyin": "shuāng fāng hé jiě hǎo xiǎo fā shēng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "朱旭去世",
      "preferredPinyin": "zhū xù qū sǐ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "享年88岁",
      "preferredPinyin": "xiǎng nián 88 suì",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "韩路出品",
      "preferredPinyin": "hán lù chū pǐn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "知名车评人",
      "preferredPinyin": "zhī míng chē píng rén",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "我们现在3200米海拔的四川轿顶山",
      "preferredPinyin": "wǒ men xiànzài 3200 mǐ bēi dǎi de sì chuān jiào dǐng shān",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "大雾",
      "preferredPinyin": "dà wù",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "本来想着气爽来看贡嘎雪山",
      "preferredPinyin": "lái láng xiǎng zhe qì shuǎng kàn lǎng gǔng gǔn xuě shān",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "如今成了0度",
      "preferredPinyin": "rú jīn chéng le 0 dù",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "99%湿度还没电的湿湿哒之旅",
      "preferredPinyin": "99% shù dù hái méi diàn de shī shī dā zhī lǚ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Mavic2近地起降场补光",
      "preferredPinyin": "Mavic2 jìn dì qǐ jiàng chǎng bǔ guāng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "像不像UFO抓地球人时候那感觉",
      "preferredPinyin": "xiàng bù xiàng UFO zhuā dì qiú rén shí hòu nà gǎn jué",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Weibo",
      "preferredPinyin": "wèi bo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "10:554G",
      "preferredPinyin": "10:55 sì gē",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Search",
      "preferredPinyin": "sōu suǒ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Following",
      "preferredPinyin": "yǐn fēng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "hot",
      "preferredPinyin": "rè",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "斯道",
      "preferredPinyin": "sī dào",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "章子怡徐峥争论引发热议",
      "preferredPinyin": "zhāng zǐ yí xú zhēng zhēn lùn yǐn rè huì yì",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "每个导师侧重点不一样",
      "preferredPinyin": "měi gè dǎo shī cè zhòng diǎn bù yī yàng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "理性讨论挺好",
      "preferredPinyin": "lǐ xìng tǎo lùn hěn hǎo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "网友表示章子怡老师你能不能让徐峥大叔把话说完",
      "preferredPinyin": "wǎng hù biǎo shì zhāng zǐ yí lǎo shī nǐ néng néng ràng xú zhēng dà shū bǎ huà shuō wán",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "老是打断人家这样很不好",
      "preferredPinyin": "lǎo shì dǎ duàn rén jiā zhè yàng hěn bù hǎo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "徐璐阚清子的表演你喜欢吗~",
      "preferredPinyin": "xú lù kàn qīng zǐ de biǎo yǎn nǐ xǐ huān ma~",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "央视新闻",
      "preferredPinyin": "cì yì xīn wén",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "38 min ago from 微博 weibo.com Edited",
      "preferredPinyin": "38 mín gāo cóng wēi bo weibo.com Edited",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    }
  ],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [],
  "glossary": [],
  "pronunciationHints": []
}
```

### Glossary Enrichment Output
```json
{
  "entries": [
    {
      "text": "头条', 'literalMeaning': 'Top story', 'exampleSentence': '头条新闻很吸引人'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "微头条发布', 'literalMeaning': 'Micro headline post', 'exampleSentence': '他发布了微头条发布'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "热榜', 'literalMeaning': 'Hot list', 'exampleSentence': '这个话题上了热榜'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "怀念单田芳', 'literalMeaning':",
      "literalMeaning": null,
      "exampleSentence": null
    }
  ]
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "头条\nToutiao\n10:544G\n微头条发布\n热榜\n#怀念单田芳# 送大师最后一程\n#台风山竹# 广州停工停课\n#被讹小伙要起... 双方和解小伙发声\n#朱旭去世# 享年88岁\n韩路出品\n前天19:37知名车评人老司机App联...\n关注\n我们现在3200米海拔的四川轿顶山，大雾，本来想着气爽来看贡嘎雪山，如今成了0度99%湿度还没电的湿湿哒之旅\nMavic2近地起降场补光，像不像UFO抓地球人时候那感觉\nWeibo\n10:554G\nSearch\nFollowing hot\n斯道\n5 min ago Edited\n章子怡徐峥争论引发热议，每个导师侧重点不一样，理性讨论挺好。网友表示章子怡老师你能不能让徐峥大叔把话说完，老是打断人家这样很不好\n徐璐阚清子的表演你喜欢吗~\n央视新闻\n38 min ago from 微博 weibo.com Edited",
  "language": "zh-Hans",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "头条Toutiao\n10:544G微头条发布热榜怀念单田芳送大师最后一程台风山竹广州停工停课被讹小伙要起双方和解小伙发声朱旭去世享年88岁韩路出品前天:知名车评人老司机联关注我们现在3200米海拔的四川轿顶山，大雾，本来想着气爽来看贡嘎雪山，如今成了0度99湿度还没电的湿湿哒之旅Mavic2近地起降场补光，像不像UFO抓地球人时候那感觉Weibo\n10:554G\nSearch\nFollowing hot斯道章子怡徐峥争论引发热议，每个导师侧重点不一样，理性讨论挺好。",
      "pinyin": "tóu tiáo Toutiao 10: 544G wēi tóu tiáo fā bù rè bǎng huái niàn dān tián fāng sòng dà shī zuì hòu yī chéng tái fēng shān zhú guǎng zhōu gōng gōng tīng kè bèi é hǎo xiǎo yào qǐ shuāng fāng hé jiě hǎo xiǎo fā shēng zhū xù qū sǐ xiǎng nián 88 suì hán lù chū pǐn qián tiān: zhī míng chē píng rén lǎo sī jī lián guān zhù wǒ men xiàn zài 3200 mǐ hǎi bá de sì chuān jiào dǐng shān， dà wù， lái láng xiǎng zhe qì shuǎng kàn lǎng gǔng gǔn xuě shān， rú jīn chéng le 0 dù 99 shī dù hái méi diàn de shī shī dá zhī lǚ Mavic2 jìn dì qǐ jiàng chǎng bǔ guāng， xiàng bú xiàng UFO zhuā dì qiú rén shí hòu nà gǎn jué Weibo 10: 554G Search Following hot sī dào zhāng zǐ yí xú zhēng zhēn lùn yǐn rè huì yì， měi gè dǎo shī cè zhòng diǎn bù yī yàng， lǐ xìng tǎo lùn hěn hǎo。",
      "translation": null,
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "头条",
          "pinyin": "tóu tiáo",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t2",
          "hanzi": "Toutiao\n10",
          "pinyin": "Toutiao 10",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t3",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t4",
          "hanzi": "544G",
          "pinyin": "544G",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t5",
          "hanzi": "微头条发布",
          "pinyin": "wēi tóu tiáo fā bù",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t6",
          "hanzi": "热榜",
          "pinyin": "rè bǎng",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t7",
          "hanzi": "怀念单田芳",
          "pinyin": "huái niàn dān tián fāng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t8",
          "hanzi": "送大师最后一程",
          "pinyin": "sòng dà shī zuì hòu yī chéng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t9",
          "hanzi": "台风山竹",
          "pinyin": "tái fēng shān zhú",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t10",
          "hanzi": "广州停工停课",
          "pinyin": "guǎng zhōu gōng gōng tīng kè",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t11",
          "hanzi": "被讹小伙要起",
          "pinyin": "bèi é hǎo xiǎo yào qǐ",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t12",
          "hanzi": "双方和解小伙发声",
          "pinyin": "shuāng fāng hé jiě hǎo xiǎo fā shēng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t13",
          "hanzi": "朱旭去世",
          "pinyin": "zhū xù qū sǐ",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t14",
          "hanzi": "享年",
          "pinyin": "xiǎng nián",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t15",
          "hanzi": "88",
          "pinyin": "88",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t16",
          "hanzi": "岁",
          "pinyin": "suì",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t17",
          "hanzi": "韩路出品",
          "pinyin": "hán lù chū pǐn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t18",
          "hanzi": "前天",
          "pinyin": "qián tiān",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t19",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t20",
          "hanzi": "知名车评人老司机",
          "pinyin": "zhī míng chē píng rén lǎo sī jī",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t21",
          "hanzi": "联",
          "pinyin": "lián",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t22",
          "hanzi": "关注",
          "pinyin": "guān zhù",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t23",
          "hanzi": "我们现在",
          "pinyin": "wǒ men xiàn zài",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t24",
          "hanzi": "3200",
          "pinyin": "3200",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t25",
          "hanzi": "米海拔的四川轿顶山",
          "pinyin": "mǐ hǎi bá de sì chuān jiào dǐng shān",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t26",
          "hanzi": "，",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t27",
          "hanzi": "大雾",
          "pinyin": "dà wù",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t28",
          "hanzi": "，",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t29",
          "hanzi": "本来想着气爽来看贡嘎雪山",
          "pinyin": "lái láng xiǎng zhe qì shuǎng kàn lǎng gǔng gǔn xuě shān",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t30",
          "hanzi": "，",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t31",
          "hanzi": "如今成了",
          "pinyin": "rú jīn chéng le",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t32",
          "hanzi": "0",
          "pinyin": "0",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t33",
          "hanzi": "度",
          "pinyin": "dù",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t34",
          "hanzi": "99",
          "pinyin": "99",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t35",
          "hanzi": "湿度还没电的湿湿哒之旅",
          "pinyin": "shī dù hái méi diàn de shī shī dá zhī lǚ",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t36",
          "hanzi": "Mavic2",
          "pinyin": "Mavic2",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t37",
          "hanzi": "近地起降场补光",
          "pinyin": "jìn dì qǐ jiàng chǎng bǔ guāng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t38",
          "hanzi": "，",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t39",
          "hanzi": "像不像",
          "pinyin": "xiàng bú xiàng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t40",
          "hanzi": "UFO",
          "pinyin": "UFO",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t41",
          "hanzi": "抓地球人时候那感觉",
          "pinyin": "zhuā dì qiú rén shí hòu nà gǎn jué",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t42",
          "hanzi": "Weibo\n10",
          "pinyin": "Weibo 10",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t43",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t44",
          "hanzi": "554G\nSearch\nFollowing hot",
          "pinyin": "554G Search Following hot",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t45",
          "hanzi": "斯道",
          "pinyin": "sī dào",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t46",
          "hanzi": "章子怡徐峥争论引发热议",
          "pinyin": "zhāng zǐ yí xú zhēng zhēn lùn yǐn rè huì yì",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t47",
          "hanzi": "，",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t48",
          "hanzi": "每个导师侧重点不一样",
          "pinyin": "měi gè dǎo shī cè zhòng diǎn bù yī yàng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t49",
          "hanzi": "，",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t50",
          "hanzi": "理性讨论挺好",
          "pinyin": "lǐ xìng tǎo lùn hěn hǎo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t51",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "网友表示章子怡老师你能不能让徐峥大叔把话说完，老是打断人家这样很不好徐璐阚清子的表演你喜欢吗央视新闻38 min ago from微博weibocom Edited",
      "pinyin": "wǎng hù biǎo shì zhāng zǐ yí lǎo shī nǐ néng néng ràng xú zhēng dà shū bǎ huà shuō wán， lǎo shì dǎ duàn rén jiā zhè yàng hěn bù hǎo xú lù hǎn qīng zi de biǎo yǎn nǐ xǐ huān ma cì yì xīn wén 38 min ago from wēi bó weibo com Edited",
      "translation": null,
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "网友表示章子怡老师你能不能让徐峥大叔把话说完",
          "pinyin": "wǎng hù biǎo shì zhāng zǐ yí lǎo shī nǐ néng néng ràng xú zhēng dà shū bǎ huà shuō wán",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s2-t2",
          "hanzi": "，",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t3",
          "hanzi": "老是打断人家这样很不好",
          "pinyin": "lǎo shì dǎ duàn rén jiā zhè yàng hěn bù hǎo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s2-t4",
          "hanzi": "徐璐阚清子的表演你喜欢吗",
          "pinyin": "xú lù hǎn qīng zi de biǎo yǎn nǐ xǐ huān ma",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t5",
          "hanzi": "央视新闻",
          "pinyin": "cì yì xīn wén",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s2-t6",
          "hanzi": "38 min ago from",
          "pinyin": "38 min ago from",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t7",
          "hanzi": "微博",
          "pinyin": "wēi bó",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t8",
          "hanzi": "weibo",
          "pinyin": "weibo",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t9",
          "hanzi": "com Edited",
          "pinyin": "com Edited",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "头条",
      "pinyin": "tóu tiáo",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "微头条发布",
      "pinyin": "wēi tóu tiáo fā bù",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "热榜",
      "pinyin": "rè bǎng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "怀念单田芳",
      "pinyin": "huái niàn dān tián fāng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "送大师最后一程",
      "pinyin": "sòng dà shī zuì hòu yī chéng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "台风山竹",
      "pinyin": "tái fēng shān zhú",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "广州停工停课",
      "pinyin": "guǎng zhōu gōng gōng tīng kè",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "被讹小伙要起",
      "pinyin": "bèi é hǎo xiǎo yào qǐ",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "双方和解小伙发声",
      "pinyin": "shuāng fāng hé jiě hǎo xiǎo fā shēng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "朱旭去世",
      "pinyin": "zhū xù qū sǐ",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "享年",
      "pinyin": "xiǎng nián",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "岁",
      "pinyin": "suì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "韩路出品",
      "pinyin": "hán lù chū pǐn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "前天",
      "pinyin": "qián tiān",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "知名车评人老司机",
      "pinyin": "zhī míng chē píng rén lǎo sī jī",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "联",
      "pinyin": "lián",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "关注",
      "pinyin": "guān zhù",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "我们现在",
      "pinyin": "wǒ men xiàn zài",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "米海拔的四川轿顶山",
      "pinyin": "mǐ hǎi bá de sì chuān jiào dǐng shān",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "大雾",
      "pinyin": "dà wù",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "本来想着气爽来看贡嘎雪山",
      "pinyin": "lái láng xiǎng zhe qì shuǎng kàn lǎng gǔng gǔn xuě shān",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "如今成了",
      "pinyin": "rú jīn chéng le",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "度",
      "pinyin": "dù",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "湿度还没电的湿湿哒之旅",
      "pinyin": "shī dù hái méi diàn de shī shī dá zhī lǚ",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "近地起降场补光",
      "pinyin": "jìn dì qǐ jiàng chǎng bǔ guāng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "像不像",
      "pinyin": "xiàng bú xiàng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "抓地球人时候那感觉",
      "pinyin": "zhuā dì qiú rén shí hòu nà gǎn jué",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "斯道",
      "pinyin": "sī dào",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "章子怡徐峥争论引发热议",
      "pinyin": "zhāng zǐ yí xú zhēng zhēn lùn yǐn rè huì yì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "每个导师侧重点不一样",
      "pinyin": "měi gè dǎo shī cè zhòng diǎn bù yī yàng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "理性讨论挺好",
      "pinyin": "lǐ xìng tǎo lùn hěn hǎo",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "网友表示章子怡老师你能不能让徐峥大叔把话说完",
      "pinyin": "wǎng hù biǎo shì zhāng zǐ yí lǎo shī nǐ néng néng ràng xú zhēng dà shū bǎ huà shuō wán",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "老是打断人家这样很不好",
      "pinyin": "lǎo shì dǎ duàn rén jiā zhè yàng hěn bù hǎo",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "徐璐阚清子的表演你喜欢吗",
      "pinyin": "xú lù hǎn qīng zi de biǎo yǎn nǐ xǐ huān ma",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "央视新闻",
      "pinyin": "cì yì xīn wén",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "微博",
      "pinyin": "wēi bó",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "头条",
  "pinyin": "tóu tiáo",
  "meaning": "Top headline; trending topic; the most important news story at the top of a news feed.",
  "notes": "Commonly used in media and social platforms to refer to trending or breaking news.",
  "examples": [],
  "pinyinSource": "text_model_hint"
}
```

## 8. weibo_6_toutiao_comparison.jpg | zh | baidu/qianfan-ocr-fast:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=200, latency=199.61s
- Explain endpoint: status=200, latency=1.13s

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=True, attempts=1, latency=13.92s, prompt_tokens=3359, completion_tokens=1245, total_tokens=4604, t/s=89.44
- `text analysis` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=13.35s, prompt_tokens=2452, completion_tokens=2508, total_tokens=4960, t/s=187.85
- `glossary enrichment` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=172.29s, prompt_tokens=562, completion_tokens=32768, total_tokens=33330, t/s=190.19

### Vision Output
```json
{
  "documentText": "头条\nToutiao\n10:544G\n微头条发布\n热榜\n#怀念单田芳# #台风山竹# #被讹小伙要起... #朱旭去世# 韩路出品前天19:37·知名车评人老司机App联... 我们现在3200米海拔的四川轿顶山，大雾，本来想着气爽来看贡嘎雪山，如今成了0度99%湿度还没电的湿湿哒之旅😂😂😂 Mavic2近地起降场补光，像不像UFO抓地球人时候那感觉😂😂😂\n头条\nToutiao\n10:554G\nSearch\nFollowing hot\n斯道5 min ago Edited 章子怡徐峥争论引发热议，每个导师侧重点不一样，理性讨论挺好。网友表示章子怡老师你能不能让徐峥大叔把话说完，老是打断人家这样很不好徐璐阚清子的表演你喜欢吗～\n央视新闻38 min ago from 微博 weibo.com Edited\nWeibo\nMessage Discover Me",
  "language": "zh-Hans",
  "readingLines": [
    "头条\nToutiao\n10:544G\n微头条发布\n热榜\n#怀念单田芳# #台风山竹# #被讹小伙要起... #朱旭去世# 韩路出品前天19:37·知名车评人老司机App联... 我们现在3200米海拔的四川轿顶山，大雾，本来想着气爽来看贡嘎雪山，如今成了0度99%湿度还没电的湿湿哒之旅😂😂😂 Mavic2近地起降场补光，像不像UFO抓地球人时候那感觉😂😂😂",
    "头条\nToutiao\n10:554G\nSearch\nFollowing hot\n斯道5 min ago Edited 章子怡徐峥争论引发热议，每个导师侧重点不一样，理性讨论挺好。网友表示章子怡老师你能不能让徐峥大叔把话说完，老是打断人家这样很不好徐璐阚清子的表演你喜欢吗～\n央视新闻38 min ago from 微博 weibo.com Edited\nWeibo\nMessage Discover Me"
  ],
  "pronunciationHints": [
    {
      "phrase": "头条",
      "preferredPinyin": "tóu tiáo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Toutiao",
      "preferredPinyin": "tuóu táo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "微头条",
      "preferredPinyin": "wēi tóu tiáo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "发布",
      "preferredPinyin": "fā bù",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "热榜",
      "preferredPinyin": "rè bǎng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "怀念单田芳",
      "preferredPinyin": "huái niàn dān tián fāng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "台风山竹",
      "preferredPinyin": "tái fēng shān zhú",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "被讹小伙要起",
      "preferredPinyin": "bèi é hǎo hǎo yào qǐ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "朱旭去世",
      "preferredPinyin": "zhū xù qū sǐ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "韩路出品",
      "preferredPinyin": "hán lù chū pǐn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "知名车评人",
      "preferredPinyin": "zhī míng chē píng rén",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "老司机App联",
      "preferredPinyin": "lǎo jī xíng app lián",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "四川轿顶山",
      "preferredPinyin": "sì chuān jiào dǐng shān",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "贡嘎雪山",
      "preferredPinyin": "gòng gǎ xuě shān",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "湿湿哒之旅",
      "preferredPinyin": "shī shī dā zhī lǚ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Mavic2近地起降场补光",
      "preferredPinyin": "má vī 2 jìn dì qǐ jiàng chǎng bǔ guāng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "UFO抓地球人",
      "preferredPinyin": "u fó zhuā dì qiú rén",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "斯道",
      "preferredPinyin": "sī dào",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "章子怡徐峥争论",
      "preferredPinyin": "zhāng zǐ yí xú zhēng zhēng lùn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "理性讨论挺好",
      "preferredPinyin": "lǐ xìng tǎo lùn hěn hǎo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "徐璐阚清子的表演",
      "preferredPinyin": "xú lù kàn qīng zǐ de biǎo yǎn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "央视新闻",
      "preferredPinyin": "cì yì xīn wén",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "微博",
      "preferredPinyin": "wēi bo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "weibo.com",
      "preferredPinyin": "wēi bo . com",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Message",
      "preferredPinyin": "mèi xìn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Discover",
      "preferredPinyin": "fā xiàn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Me",
      "preferredPinyin": "wǒ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    }
  ],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [
    {
      "hanzi": "头条",
      "translation": "Top headline news item on Toutiao app, a social media platform for trending topics in China. 头条 tuóu táo means top news story or trending topic on social media platforms in China, commonly seen on news aggregator apps like Toutiao where users can quickly browse current events and popular discussions across various topics including entertainment, politics, and social issues that are capturing public attention at the moment. This serves as a primary source for staying updated on current affairs in Chinese digital media landscape where information spreads rapidly through social sharing and algorithmic curation based on user interests and engagement patterns that reflect what topics are gaining momentum and visibility among Chinese internet users across different regions and demographic groups.",
      "tokens": [
        {
          "text": "头条",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Toutiao",
      "translation": "Name of a Chinese news aggregation app. 托头涛 (tuóu táo) is the phonetic approximation used for English speakers.",
      "tokens": [
        {
          "text": "Toutiao",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "10:54 4G",
      "translation": "Timestamp and network type. 10:54 (shí diǎn wǔ shí sì) means 10:54, and 4G (sì shì) refers to the fourth generation mobile network technology providing high-speed internet access on smartphones and mobile devices with faster data transfer rates compared to previous generations like 3G or 2G, enabling smoother streaming, quicker downloads, and better overall connectivity for users on the go in urban and rural areas across China where telecommunications infrastructure continues to expand rapidly to meet growing consumer demands for mobile data services.",
      "tokens": [
        {
          "text": "10:54 4G",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "微头条发布",
      "translation": "Weitoutiao published a post. 微 (wēi) means micro or small, 头条 (tóu tiáo) means top headline, and 发布 (fā bù) means to publish or release content online through social media platforms or news websites where users can share information, opinions, and updates with their followers or the general public in real-time through digital communication channels that connect people across different regions and time zones enabling instant information dissemination and social interaction among diverse user groups including individuals, organizations, and communities interested in staying informed about current events, trends, and various topics of interest through online platforms that serve as virtual gathering spaces for discussion, debate, and knowledge sharing in the digital age where traditional media boundaries are increasingly blurred by technological advancements and changing user behaviors in how they consume and interact with content in their daily lives.",
      "tokens": [
        {
          "text": "微头条发布",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "热榜",
      "translation": "Trending topics list. 热 (rè) means hot, 榜 (bǎng) means list or ranking.",
      "tokens": [
        {
          "text": "热榜",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "#怀念单田芳#",
      "translation": "Remembering Shantianfang. 单 (dān) means single, 田 (tián) means field, 芳 (fāng) means fragrance or distinguished.",
      "tokens": [
        {
          "text": "#怀念单田芳#",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "#台风山竹#",
      "translation": "Typhoon Mangkhut. 台风 (tái fēng) means typhoon, 山竹 (shān zhú) means mountain bamboo.",
      "tokens": [
        {
          "text": "#台风山竹#",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "#被讹小伙要起#",
      "translation": "The guy being scammed wants to stand up. 被 (bèi) means being, 讹 (é) means scam, 小伙 (hǎo hǎo) means young guy, 要 (yào) means want, 起 (qǐ) means to stand up.",
      "tokens": [
        {
          "text": "#被讹小伙要起#",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "#朱旭去世#",
      "translation": "Zhu Xu passed away. 去世 (qū sǐ) means to pass away or die.",
      "tokens": [
        {
          "text": "#朱旭去世#",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "韩路出品",
      "translation": "Produced by Han Lu. 韩 (hán) is a surname, 路 (lù) means road, 出品 (chū pǐn) means production or product.",
      "tokens": [
        {
          "text": "韩路出品",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "前天19:37",
      "translation": "The day before yesterday at 19:37. 前天 (qián tiān) means day before yesterday, 19:37 is the time in 24-hour format.",
      "tokens": [
        {
          "text": "前天19:37",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "知名车评人",
      "translation": "Famous car reviewer. 知名 (zhī míng) means famous or well-known, 车评人 (chē píng rén) means car reviewer.",
      "tokens": [
        {
          "text": "知名车评人",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "老司机App联",
      "translation": "Old driver App link. 老司机 (lǎo jī xíng) means experienced driver, App (app) is application software, 联 (lián) means to connect or link.",
      "tokens": [
        {
          "text": "老司机App联",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "我们现在3200米海拔的四川轿顶山",
      "translation": "We are now at 3200 meters altitude in Jiaodingshan, Sichuan. 海拔 (hǎi bá) means altitude, 四川 (sì chuān) means Sichuan, 轿顶山 (jiào dǐng shān) means sedan chair top mountain.",
      "tokens": [
        {
          "text": "我们现在3200米海拔的四川轿顶山",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "大雾",
      "translation": "Heavy fog. 雾 (wù) means fog.",
      "tokens": [
        {
          "text": "大雾",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "本来想着气爽来看贡嘎雪山",
      "translation": "Originally wanted to enjoy the fresh air to see Gongga Snow Mountain. 本来 (běn lái) means originally, 想着 (xiǎng zhe) means thinking about, 气爽 (qì shuǎng) means fresh air, 来 (lái) means to come, 看 (kàn) means to see, 贡嘎雪山 (gòng gǎ xuě shān) is a mountain in Sichuan.",
      "tokens": [
        {
          "text": "本来想着气爽来看贡嘎雪山",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "如今成了0度99%湿度还没电的湿湿哒之旅",
      "translation": "Now it became a wet trip with 0°C and 99% humidity, no power. 湿湿哒 (shī shī dā) means wet and damp, 之旅 (zhī lǚ) means journey.",
      "tokens": [
        {
          "text": "如今成了0度99%湿度还没电的湿湿哒之旅",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "😂😂😂",
      "translation": "Laughing emoji.",
      "tokens": [
        {
          "text": "😂😂😂",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Mavic2近地起降场补光",
      "translation": "Mavic2 near-ground takeoff and landing field supplemental lighting. 近地 (jìn dì) means near ground, 起降场 (qǐ jiàng chǎng) means takeoff and landing field, 补光 (bǔ guāng) means supplemental lighting.",
      "tokens": [
        {
          "text": "Mavic2近地起降场补光",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "像不像UFO抓地球人时候那感觉",
      "translation": "Like UFO capturing people on Earth. UFO (u fó) means unidentified flying object, 抓 (zhuā) means to catch, 地球人 (dì qiú rén) means earthling or person from Earth.",
      "tokens": [
        {
          "text": "像不像UFO抓地球人时候那感觉",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "央视新闻",
      "translation": "CCTV News. 央视 (cì yì) is short for China Central Television, 新闻 (xīn wén) means news.",
      "tokens": [
        {
          "text": "央视新闻",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "微博",
      "translation": "Weibo. A Chinese social media platform similar to Twitter.",
      "tokens": [
        {
          "text": "微博",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "weibo.com",
      "translation": "Weibo website URL.",
      "tokens": [
        {
          "text": "weibo.com",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Message",
      "translation": "Message in English.",
      "tokens": [
        {
          "text": "Message",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Discover",
      "translation": "Discover in English.",
      "tokens": [
        {
          "text": "Discover",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Me",
      "translation": "Me in English.",
      "tokens": [
        {
          "text": "Me",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "斯道5 min ago Edited",
      "translation": "This post was edited 5 minutes ago. 斯道 (sī dào) is a username or topic identifier, min (min) is minute, ago (ago) indicates past time, Edited (yǐ jìng) means modified or edited.",
      "tokens": [
        {
          "text": "斯道5 min ago Edited",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "章子怡徐峥争论引发热议",
      "translation": "Zhang Ziyi and Xu Zheng's argument sparked heated discussion. 章子怡 (zhāng zǐ yí) is an actress, 徐峥 (xú zhēng) is an actor, 争论 (zhēng lùn) means argument, 引发 (yǐn fā) means to trigger, 热议 (rè lùn) means heated discussion.",
      "tokens": [
        {
          "text": "章子怡徐峥争论引发热议",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "每个导师侧重点不一样",
      "translation": "Each mentor focuses differently. 导师 (dǎo shī) means mentor, 侧重点 (cè zhòng diǎn) means focus or emphasis, 不一样 (bù yī yàng) means different.",
      "tokens": [
        {
          "text": "每个导师侧重点不一样",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "理性讨论挺好",
      "translation": "Rational discussion is good. 理性 (lǐ xìng) means rational, 讨论 (tǎo lùn) means discussion, 挺好 (tǐ hǎo) means good.",
      "tokens": [
        {
          "text": "理性讨论挺好",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "网友表示章子怡老师你能不能让徐峥大叔把话说完",
      "translation": "Netizens say Teacher Zhang Ziyi, can you let Uncle Xu Zheng finish his sentence. 网友 (wǎng yǒu) means netizen, 表示 (biǎo shì) means indicate or say, 能不能 (néng bù néng) means can or cannot, 让 (ràng) means to let, 大叔 (dà shū) means uncle, 把话说完 (bǎ huà shuō wán) means finish speaking.",
      "tokens": [
        {
          "text": "网友表示章子怡老师你能不能让徐峥大叔把话说完",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "老是打断人家这样很不好",
      "translation": "Always interrupting others is not good. 老是 (lǎo shì) means always, 打断 (dǎ duàn) means to interrupt, 人家 (rén jia) means others, 很不好 (hěn bù hǎo) means not good.",
      "tokens": [
        {
          "text": "老是打断人家这样很不好",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "徐璐阚清子的表演",
      "translation": "Performance of Xu Lu and Kan Qingzi. 徐璐 (xú lù) is an actress, 阚清子 (kàn qīng zǐ) is an actress, 的 (de) indicates possession, 表演 (biǎo yǎn) means performance.",
      "tokens": [
        {
          "text": "徐璐阚清子的表演",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "你喜欢吗～",
      "translation": "Do you like it? 喜欢 (xǐ huan) means to like, 吗 (ma) is a question particle, ～ (tilde) indicates a trailing off or casual tone.",
      "tokens": [
        {
          "text": "你喜欢吗～",
          "kind": "other",
          "meaning": null
        }
      ]
    }
  ],
  "glossary": [],
  "pronunciationHints": []
}
```

### Glossary Enrichment Output
```json
{
  "entries": []
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "头条\nToutiao\n10:544G\n微头条发布\n热榜\n#怀念单田芳# #台风山竹# #被讹小伙要起... #朱旭去世# 韩路出品前天19:37·知名车评人老司机App联... 我们现在3200米海拔的四川轿顶山，大雾，本来想着气爽来看贡嘎雪山，如今成了0度99%湿度还没电的湿湿哒之旅😂😂😂 Mavic2近地起降场补光，像不像UFO抓地球人时候那感觉😂😂😂\n头条\nToutiao\n10:554G\nSearch\nFollowing hot\n斯道5 min ago Edited 章子怡徐峥争论引发热议，每个导师侧重点不一样，理性讨论挺好。网友表示章子怡老师你能不能让徐峥大叔把话说完，老是打断人家这样很不好徐璐阚清子的表演你喜欢吗～\n央视新闻38 min ago from 微博 weibo.com Edited\nWeibo\nMessage Discover Me",
  "language": "zh-Hans",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "头条",
      "pinyin": "tóu tiáo",
      "translation": "Top headline news item on Toutiao app, a social media platform for trending topics in China.",
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "头条",
          "pinyin": "tóu tiáo",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "vision_hint"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "微头条发布",
      "pinyin": "wēi tóu tiáo fā bù",
      "translation": "Weitoutiao published a post.",
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "微头条发布",
          "pinyin": "wēi tóu tiáo fā bù",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "热榜",
      "pinyin": "rè bǎng",
      "translation": "Trending topics list.",
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "热榜",
          "pinyin": "rè bǎng",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "vision_hint"
        }
      ]
    },
    {
      "id": "s4",
      "hanzi": "#怀念单田芳#",
      "pinyin": "# huái niàn dān tián fāng #",
      "translation": "Remembering Shantianfang.",
      "tokens": [
        {
          "id": "s4-t1",
          "hanzi": "#怀念单田芳#",
          "pinyin": "# huái niàn dān tián fāng #",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s5",
      "hanzi": "#台风山竹#",
      "pinyin": "# tái fēng shān zhú #",
      "translation": "Typhoon Mangkhut.",
      "tokens": [
        {
          "id": "s5-t1",
          "hanzi": "#台风山竹#",
          "pinyin": "# tái fēng shān zhú #",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s6",
      "hanzi": "#被讹小伙要起#",
      "pinyin": "# bèi é xiǎo huǒ yào qǐ #",
      "translation": "The guy being scammed wants to stand up.",
      "tokens": [
        {
          "id": "s6-t1",
          "hanzi": "#被讹小伙要起#",
          "pinyin": "# bèi é xiǎo huǒ yào qǐ #",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s7",
      "hanzi": "#朱旭去世#",
      "pinyin": "# zhū xù qù shì #",
      "translation": "Zhu Xu passed away.",
      "tokens": [
        {
          "id": "s7-t1",
          "hanzi": "#朱旭去世#",
          "pinyin": "# zhū xù qù shì #",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s8",
      "hanzi": "韩路出品",
      "pinyin": "hán lù chū pǐn",
      "translation": "Produced by Han Lu.",
      "tokens": [
        {
          "id": "s8-t1",
          "hanzi": "韩路出品",
          "pinyin": "hán lù chū pǐn",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "vision_hint"
        }
      ]
    },
    {
      "id": "s9",
      "hanzi": "前天",
      "pinyin": "qián tiān",
      "translation": "The day before yesterday at 19:37.",
      "tokens": [
        {
          "id": "s9-t1",
          "hanzi": "前天",
          "pinyin": "qián tiān",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s10",
      "hanzi": "知名车评人",
      "pinyin": "zhī míng chē píng rén",
      "translation": "Famous car reviewer.",
      "tokens": [
        {
          "id": "s10-t1",
          "hanzi": "知名车评人",
          "pinyin": "zhī míng chē píng rén",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "vision_hint"
        }
      ]
    },
    {
      "id": "s11",
      "hanzi": "老司机App联",
      "pinyin": "lǎo jī xíng app lián",
      "translation": "Old driver App link.",
      "tokens": [
        {
          "id": "s11-t1",
          "hanzi": "老司机App联",
          "pinyin": "lǎo jī xíng app lián",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "vision_hint"
        }
      ]
    },
    {
      "id": "s12",
      "hanzi": "我们现在3200米海拔的四川轿顶山",
      "pinyin": "wǒ men xiàn zài 3200 mǐ hǎi bá de sì chuān jiào dǐng shān",
      "translation": "We are now at 3200 meters altitude in Jiaodingshan, Sichuan.",
      "tokens": [
        {
          "id": "s12-t1",
          "hanzi": "我们现在3200米海拔的四川轿顶山",
          "pinyin": "wǒ men xiàn zài 3200 mǐ hǎi bá de sì chuān jiào dǐng shān",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s13",
      "hanzi": "大雾",
      "pinyin": "dà wù",
      "translation": "Heavy fog.",
      "tokens": [
        {
          "id": "s13-t1",
          "hanzi": "大雾",
          "pinyin": "dà wù",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s14",
      "hanzi": "本来想着气爽来看贡嘎雪山",
      "pinyin": "běn lái xiǎng zhe qì shuǎng lái kàn gòng gā xuě shān",
      "translation": "Originally wanted to enjoy the fresh air to see Gongga Snow Mountain.",
      "tokens": [
        {
          "id": "s14-t1",
          "hanzi": "本来想着气爽来看贡嘎雪山",
          "pinyin": "běn lái xiǎng zhe qì shuǎng lái kàn gòng gā xuě shān",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s15",
      "hanzi": "如今成了0度99%湿度还没电的湿湿哒之旅",
      "pinyin": "rú jīn chéng le 0 dù 99% shī dù hái méi diàn de shī shī dá zhī lǚ",
      "translation": "Now it became a wet trip with 0°C and 99% humidity, no power.",
      "tokens": [
        {
          "id": "s15-t1",
          "hanzi": "如今成了0度99%湿度还没电的湿湿哒之旅",
          "pinyin": "rú jīn chéng le 0 dù 99% shī dù hái méi diàn de shī shī dá zhī lǚ",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s16",
      "hanzi": "Mavic2近地起降场补光",
      "pinyin": "má vī 2 jìn dì qǐ jiàng chǎng bǔ guāng",
      "translation": "Mavic2 near-ground takeoff and landing field supplemental lighting.",
      "tokens": [
        {
          "id": "s16-t1",
          "hanzi": "Mavic2近地起降场补光",
          "pinyin": "má vī 2 jìn dì qǐ jiàng chǎng bǔ guāng",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "vision_hint"
        }
      ]
    },
    {
      "id": "s17",
      "hanzi": "像不像UFO抓地球人时候那感觉",
      "pinyin": "xiàng bú xiàng UFO zhuā dì qiú rén shí hòu nà gǎn jué",
      "translation": "Like UFO capturing people on Earth.",
      "tokens": [
        {
          "id": "s17-t1",
          "hanzi": "像不像UFO抓地球人时候那感觉",
          "pinyin": "xiàng bú xiàng UFO zhuā dì qiú rén shí hòu nà gǎn jué",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s18",
      "hanzi": "央视新闻",
      "pinyin": "cì yì xīn wén",
      "translation": "CCTV News.",
      "tokens": [
        {
          "id": "s18-t1",
          "hanzi": "央视新闻",
          "pinyin": "cì yì xīn wén",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "vision_hint"
        }
      ]
    },
    {
      "id": "s19",
      "hanzi": "微博",
      "pinyin": "wēi bo",
      "translation": "Weibo.",
      "tokens": [
        {
          "id": "s19-t1",
          "hanzi": "微博",
          "pinyin": "wēi bo",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "vision_hint"
        }
      ]
    },
    {
      "id": "s20",
      "hanzi": "斯道5 min ago Edited",
      "pinyin": "sī dào 5 min ago Edited",
      "translation": "This post was edited 5 minutes ago.",
      "tokens": [
        {
          "id": "s20-t1",
          "hanzi": "斯道5 min ago Edited",
          "pinyin": "sī dào 5 min ago Edited",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s21",
      "hanzi": "章子怡徐峥争论引发热议",
      "pinyin": "zhāng zi yí xú zhēng zhēng lùn yǐn fā rè yì",
      "translation": "Zhang Ziyi and Xu Zheng's argument sparked heated discussion.",
      "tokens": [
        {
          "id": "s21-t1",
          "hanzi": "章子怡徐峥争论引发热议",
          "pinyin": "zhāng zi yí xú zhēng zhēng lùn yǐn fā rè yì",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s22",
      "hanzi": "每个导师侧重点不一样",
      "pinyin": "měi gè dǎo shī cè zhòng diǎn bù yí yàng",
      "translation": "Each mentor focuses differently.",
      "tokens": [
        {
          "id": "s22-t1",
          "hanzi": "每个导师侧重点不一样",
          "pinyin": "měi gè dǎo shī cè zhòng diǎn bù yí yàng",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s23",
      "hanzi": "理性讨论挺好",
      "pinyin": "lǐ xìng tǎo lùn hěn hǎo",
      "translation": "Rational discussion is good.",
      "tokens": [
        {
          "id": "s23-t1",
          "hanzi": "理性讨论挺好",
          "pinyin": "lǐ xìng tǎo lùn hěn hǎo",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "vision_hint"
        }
      ]
    },
    {
      "id": "s24",
      "hanzi": "网友表示章子怡老师你能不能让徐峥大叔把话说完",
      "pinyin": "wǎng yǒu biǎo shì zhāng zi yí lǎo shī nǐ néng bù néng ràng xú zhēng dà shū bǎ huà shuō wán",
      "translation": "Netizens say Teacher Zhang Ziyi, can you let Uncle Xu Zheng finish his sentence.",
      "tokens": [
        {
          "id": "s24-t1",
          "hanzi": "网友表示章子怡老师你能不能让徐峥大叔把话说完",
          "pinyin": "wǎng yǒu biǎo shì zhāng zi yí lǎo shī nǐ néng bù néng ràng xú zhēng dà shū bǎ huà shuō wán",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s25",
      "hanzi": "老是打断人家这样很不好",
      "pinyin": "lǎo shì dǎ duàn rén jiā zhè yàng hěn bù hǎo",
      "translation": "Always interrupting others is not good.",
      "tokens": [
        {
          "id": "s25-t1",
          "hanzi": "老是打断人家这样很不好",
          "pinyin": "lǎo shì dǎ duàn rén jiā zhè yàng hěn bù hǎo",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s26",
      "hanzi": "徐璐阚清子的表演",
      "pinyin": "xú lù kàn qīng zǐ de biǎo yǎn",
      "translation": "Performance of Xu Lu and Kan Qingzi.",
      "tokens": [
        {
          "id": "s26-t1",
          "hanzi": "徐璐阚清子的表演",
          "pinyin": "xú lù kàn qīng zǐ de biǎo yǎn",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "vision_hint"
        }
      ]
    },
    {
      "id": "s27",
      "hanzi": "你喜欢吗",
      "pinyin": "nǐ xǐ huān ma",
      "translation": "Do you like it?",
      "tokens": [
        {
          "id": "s27-t1",
          "hanzi": "你喜欢吗",
          "pinyin": "nǐ xǐ huān ma",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "前天",
      "pinyin": "qián tiān",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "你喜欢吗",
      "pinyin": "nǐ xǐ huān ma",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "前天",
  "pinyin": "qián tiān",
  "meaning": "the day before yesterday",
  "notes": "Refers to two days ago; commonly used in time expressions.",
  "examples": [],
  "pinyinSource": "text_model_hint"
}
```

## 9. weibo_kol_1.jpg | auto | baidu/qianfan-ocr-fast:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=200, latency=39.54s
- Explain endpoint: status=200, latency=2.12s

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=True, attempts=1, latency=26.05s, prompt_tokens=4129, completion_tokens=2170, total_tokens=6299, t/s=83.32
- `text analysis` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=13.47s, prompt_tokens=3957, completion_tokens=2711, total_tokens=6668, t/s=201.25

### Vision Output
```json
{
  "documentText": "15:3315:3415:34 Search Weibo Weibo Following hot 粉丝福利购2626醉鹅娘醉鹅娘精品葡萄酒店5 Yesterday 19:25 from 微博视频怎么能让一碟菜从20块钱变成200块钱呢？醉鹅娘超话 #醉鹅娘品味小知识# @鲜城 【10元券】微博专享限时领券醉鹅娘的微博视频在礼盒后面有一个品鉴方法1010元券】微博专享限时领券用券后价：¥299.00领券20.3K views 4846 Weibo Video Discover Message Me 15:3415:34 Weibo Weibo 粉丝福利购2626醉鹅娘精品葡萄酒店510使用期限2019.06.24-2019.07.31立即领券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮2笔成交现价：¥309用券后 ¥299.00更多宝贝推荐优惠券 ¥5优惠券 ¥5顺风包邮101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回加入购物车领券购买用券后价 ¥299 Users can click coupons at the bottom of a KOL post They will then be directly be taken to Taobao Product page displays once they claim the coupon",
  "language": "zh-Hans",
  "readingLines": [],
  "pronunciationHints": [
    {
      "phrase": "醉鹅娘",
      "preferredPinyin": "zuì é jiāng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "微博视频",
      "preferredPinyin": "wēi bo shì pín",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "10元券",
      "preferredPinyin": "shí yuán quàn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "微博专享限时领券",
      "preferredPinyin": "wēi bo zhuān xiǎng xiàn shí lǐng quàn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "品鉴方法",
      "preferredPinyin": "pǐn jiàn fǎng fǎ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "礼盒",
      "preferredPinyin": "lǐ hé",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "粉丝福利购",
      "preferredPinyin": "fàn shī fú lì gòu",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "醉鹅娘精品葡萄酒店",
      "preferredPinyin": "zuì é jiāng jīng pǐn pú táo jiǔ diàn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "使用期限",
      "preferredPinyin": "shǐ yòng xì qī",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "立即领券",
      "preferredPinyin": "lì jí lǐng quàn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "西伯利亚",
      "preferredPinyin": "xī bó lì yà",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "礼盒装",
      "preferredPinyin": "lǐ hé zhuāng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "包邮",
      "preferredPinyin": "bāo yóu",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "2笔成交",
      "preferredPinyin": "èr bǐ chéng jiāo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "现价",
      "preferredPinyin": "xiàn jià",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "用券后",
      "preferredPinyin": "yòng quàn hòu",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "¥309",
      "preferredPinyin": "sān bǎi yuán jiǔ bǎo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "惠淘价",
      "preferredPinyin": "huì táo jià",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "价格",
      "preferredPinyin": "jià sù",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "领券后预计减10元",
      "preferredPinyin": "lǐng quàn hòu yù jì jiǎn shí yuán",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "满699减30店铺优惠券",
      "preferredPinyin": "mǎn liù jiǔ jiǔ jiǎn sān shí diàn shuò yōu huì quàn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "了不起鹅",
      "preferredPinyin": "le bù qǐ é",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "诗芮",
      "preferredPinyin": "shī ruì",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "鱼子酱",
      "preferredPinyin": "yú zǐ jiàng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "西伯利亚30g",
      "preferredPinyin": "xī bó lì yà sān shí gē",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "2人赞过",
      "preferredPinyin": "èr rén zàn guò",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "帮我选",
      "preferredPinyin": "bāng wǒ xuǎn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "发货",
      "preferredPinyin": "fā huò",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "四川成都",
      "preferredPinyin": "sì chuān chéng dōu",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "快递：免运费",
      "preferredPinyin": "kuài dì：miǎn fèi yòng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "月销3",
      "preferredPinyin": "yuè xiāo sān",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "服务",
      "preferredPinyin": "fú wù",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "7天内发货·坏单包赔·订单险",
      "preferredPinyin": "qī tiān nèi fā huò·huài dān bāo pèi·dìng dān xiǎn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "生产日期",
      "preferredPinyin": "shēng chǎn rì qī",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "厂名",
      "preferredPinyin": "chǎng míng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "加入购物车",
      "preferredPinyin": "jiā rù gòu wù chē",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "领券购买",
      "preferredPinyin": "lǐng quàn gòu mǎi",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "用券后价",
      "preferredPinyin": "yòng quàn hòu jià",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "¥299",
      "preferredPinyin": "èr jiǔ jiū yuán jiǔ bǎo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Users can click coupons at the bottom of a KOL post",
      "preferredPinyin": "yòng hù kàn kè lǐng quàn zài dǐng duō de a KOL post",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "They will then be directly be taken to Taobao",
      "preferredPinyin": "tā men huì nà hòu bèi zhí xiē tōng dào Taobao",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Product page displays once they claim the coupon",
      "preferredPinyin": "chǎn pǐn zhèng xiǎn chū wén tā men zhāo lǐng lǐng quàn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    }
  ],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [
    {
      "hanzi": "15:33 15:34 Search Weibo",
      "translation": "15:33 15:34 Search Weibo platform now。', 'tokens': [{'text': '15:33', 'kind': 'other'}, {'text': '15:34', 'kind': 'other'}, {'text': 'Search', 'kind': 'word'}, {'text': 'Weibo', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "15:33 15:34 Search Weibo",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Weibo Following hot 粉丝福利购2626 醉鹅娘精品葡萄酒店5",
      "translation": "Weibo following popular items: Zuie Jiangang wine shop。', 'tokens': [{'text': 'Weibo', 'kind': 'word'}, {'text': 'Following', 'kind': 'word'}, {'text': 'hot', 'kind': 'word'}, {'text': '粉丝福利购2626', 'kind': 'phrase'}, {'text': '醉鹅娘精品葡萄酒店5', 'kind': 'phrase'}]",
      "tokens": [
        {
          "text": "Weibo Following hot 粉丝福利购2626 醉鹅娘精品葡萄酒店5",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Yesterday 19:25 from 微博视频怎么能让一碟菜从20块钱变成200块钱呢？醉鹅娘超话 #醉鹅娘品味小知识# @鲜城 【10元券】微博专享限时领券",
      "translation": "Yesterday 19:25: How can one dish become 10 times pricier? #ZuieJiangang tips# @XianCity coupon。', 'tokens': [{'text': 'Yesterday', 'kind': 'word'}, {'text': '19:25', 'kind': 'other'}, {'text': '微博视频', 'kind': 'phrase'}, {'text': '一碟菜', 'kind': 'phrase'}, {'text': '20块钱', 'kind': 'phrase'}, {'text': '200块钱', 'kind': 'phrase'}, {'text': '醉鹅娘超话', 'kind': 'phrase'}, {'text': '#醉鹅娘品味小知识#', 'kind': 'phrase'}, {'text': '@鲜城', 'kind': 'word'}, {'text': '【10元券】', 'kind': 'phrase'}, {'text': '微博专享限时领券', 'kind': 'phrase'}]",
      "tokens": [
        {
          "text": "Yesterday 19:25 from 微博视频怎么能让一碟菜从20块钱变成200块钱呢？醉鹅娘超话 #醉鹅娘品味小知识# @鲜城 【10元券】微博专享限时领券",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "醉鹅娘的微博视频在礼盒后面有一个品鉴方法1010元券】微博专享限时领券",
      "translation": "In the gift box behind the video: tasting method with 10 yuan coupon。', 'tokens': [{'text': '醉鹅娘的微博视频', 'kind': 'phrase'}, {'text': '在礼盒后面', 'kind': 'phrase'}, {'text': '有一个品鉴方法', 'kind': 'phrase'}, {'text': '1010元券', 'kind': 'phrase'}, {'text': '微博专享限时领券', 'kind': 'phrase'}]",
      "tokens": [
        {
          "text": "醉鹅娘的微博视频在礼盒后面有一个品鉴方法1010元券】微博专享限时领券",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "用券后价：¥299.00领券20.3K views 4846",
      "translation": "Price after coupon: ¥299.00 with 20.3K views。', 'tokens': [{'text': '用券后价', 'kind': 'phrase'}, {'text': '¥299.00', 'kind': 'other'}, {'text': '领券', 'kind': 'phrase'}, {'text': '20.3K views', 'kind': 'other'}, {'text': '4846', 'kind': 'other'}]",
      "tokens": [
        {
          "text": "用券后价：¥299.00领券20.3K views 4846",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Weibo Video Discover Message Me 15:3415:34 Weibo Weibo 粉丝福利购2626醉鹅娘精品葡萄酒店5",
      "translation": "Weibo Video Discover: message and user profile。', 'tokens': [{'text': 'Weibo Video Discover', 'kind': 'word'}, {'text': 'Message', 'kind': 'word'}, {'text': 'Me', 'kind': 'word'}, {'text': '15:3415:34 Weibo Weibo', 'kind': 'other'}, {'text': '粉丝福利购2626醉鹅娘精品葡萄酒店5', 'kind': 'phrase'}]",
      "tokens": [
        {
          "text": "Weibo Video Discover Message Me 15:3415:34 Weibo Weibo 粉丝福利购2626醉鹅娘精品葡萄酒店5",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "使用期限2019.06.24-2019.07.31立即领券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮2笔成交现价：¥309用券后 ¥299.00",
      "translation": "Valid until 2019.07.31: Zuie amazing goose with caviar gift set, 2 sold at ¥299 after coupon。', 'tokens': [{'text': '使用期限', 'kind': 'phrase'}, {'text': '2019.06.24-2019.07.31', 'kind': 'other'}, {'text': '立即领券', 'kind': 'phrase'}, {'text': '醉鹅娘了不起鹅', 'kind': 'phrase'}, {'text': 'x', 'kind': 'other'}, {'text': '诗芮鱼子酱西伯利亚30g', 'kind': 'phrase'}, {'text': '礼盒装包邮', 'kind': 'phrase'}, {'text': '2笔成交', 'kind': 'phrase'}, {'text': '现价：¥309', 'kind': 'phrase'}, {'text': '用券后 ¥299.00', 'kind': 'phrase'}]",
      "tokens": [
        {
          "text": "使用期限2019.06.24-2019.07.31立即领券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮2笔成交现价：¥309用券后 ¥299.00",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "更多宝贝推荐优惠券 ¥5优惠券 ¥5顺风包邮101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券",
      "translation": "More recommendations: coupons, free shipping, and gifts for new users。', 'tokens': [{'text': '更多宝贝推荐', 'kind': 'phrase'}, {'text': '优惠券 ¥5', 'kind': 'phrase'}, {'text': '顺风包邮101领券下单立减5元188元', 'kind': 'phrase'}, {'text': '收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽', 'kind': 'phrase'}, {'text': '黑鱼子酱西伯利亚鲟鱼籽酱... 106.00', 'kind': 'phrase'}, {'text': '1697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱', 'kind': 'phrase'}, {'text': '7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00', 'kind': 'phrase'}, {'text': '484笔成交用券后 ¥101.00优惠券 ¥5领取', 'kind': 'phrase'}, {'text': '309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券', 'kind': 'phrase'}]",
      "tokens": [
        {
          "text": "更多宝贝推荐优惠券 ¥5优惠券 ¥5顺风包邮101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱",
      "translation": "Same gift set, 2 people liked it, ships from Chengdu with free freight。', 'tokens': [{'text': '醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g', 'kind': 'phrase'}, {'text': '礼盒装', 'kind': 'phrase'}, {'text': '2人赞过帮我选发货', 'kind': 'phrase'}, {'text': '四川成都快递：免运费', 'kind': 'phrase'}, {'text': '月销3服务7天内发货·坏单包赔·订单险', 'kind': 'phrase'}, {'text': '生产日期厂名... 返回101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽', 'kind': 'phrase'}, {'text': '黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱', 'kind': 'phrase'}]",
      "tokens": [
        {
          "text": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券",
      "translation": "484 deals at ¥101 after coupon, shop discount available。', 'tokens': [{'text': '106.00', 'kind': 'other'}, {'text': '484笔成交', 'kind': 'phrase'}, {'text': '用券后 ¥101.00优惠券 ¥5领取', 'kind': 'phrase'}, {'text': '309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券', 'kind': 'phrase'}]",
      "tokens": [
        {
          "text": "106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回加入购物车领券购买用券后价 ¥299",
      "translation": "Add to cart and buy with coupon, price after coupon is ¥299。', 'tokens': [{'text': '醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g', 'kind': 'phrase'}, {'text': '礼盒装', 'kind': 'phrase'}, {'text': '2人赞过帮我选发货', 'kind': 'phrase'}, {'text': '四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回加入购物车领券购买', 'kind': 'phrase'}, {'text': '用券后价 ¥299', 'kind': 'phrase'}]",
      "tokens": [
        {
          "text": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回加入购物车领券购买用券后价 ¥299",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Users can click coupons at the bottom of a KOL post They will then be directly be taken to Taobao Product page displays once they claim the coupon",
      "translation": "Click coupon at KOL post bottom to go to Taobao product page。', 'tokens': [{'text': 'Users can click coupons at the bottom of a KOL post', 'kind': 'word'}, {'text': 'They will then be directly be taken to Taobao', 'kind': 'word'}, {'text': 'Product page displays once they claim the coupon', 'kind': 'word",
      "tokens": [
        {
          "text": "Users can click coupons at the bottom of a KOL post They will then be directly be taken to Taobao Product page displays once they claim the coupon",
          "kind": "other",
          "meaning": null
        }
      ]
    }
  ],
  "glossary": [],
  "pronunciationHints": []
}
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "documentText": "15:3315:3415:34 Search Weibo Weibo Following hot 粉丝福利购2626醉鹅娘醉鹅娘精品葡萄酒店5 Yesterday 19:25 from 微博视频怎么能让一碟菜从20块钱变成200块钱呢？醉鹅娘超话 #醉鹅娘品味小知识# @鲜城 【10元券】微博专享限时领券醉鹅娘的微博视频在礼盒后面有一个品鉴方法1010元券】微博专享限时领券用券后价：¥299.00领券20.3K views 4846 Weibo Video Discover Message Me 15:3415:34 Weibo Weibo 粉丝福利购2626醉鹅娘精品葡萄酒店510使用期限2019.06.24-2019.07.31立即领券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮2笔成交现价：¥309用券后 ¥299.00更多宝贝推荐优惠券 ¥5优惠券 ¥5顺风包邮101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回加入购物车领券购买用券后价 ¥299 Users can click coupons at the bottom of a KOL post They will then be directly be taken to Taobao Product page displays once they claim the coupon",
  "language": "zh-Hans",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "Weibo Following hot 粉丝福利购2626 醉鹅娘精品葡萄酒店5",
      "pinyin": "Weibo Following hot fěn sī fú lì gòu 2626 zuì é niáng jīng pǐn pú táo jiǔ diàn 5",
      "translation": "Weibo following popular items: Zuie Jiangang wine shop。', 'tokens': [{'text': 'Weibo', 'kind': 'word'}, {'text': 'Following', 'kind': 'word'}, {'text': 'hot', 'kind': 'word'}, {'text': '粉丝福利购2626', 'kind': 'phrase'}, {'text': '醉鹅娘精品葡萄酒店5', 'kind': 'phrase'}]",
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "Weibo Following hot 粉丝福利购2626 醉鹅娘精品葡萄酒店5",
          "pinyin": "Weibo Following hot fěn sī fú lì gòu 2626 zuì é niáng jīng pǐn pú táo jiǔ diàn 5",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "Yesterday 19:25 from 微博视频怎么能让一碟菜从20块钱变成200块钱呢？醉鹅娘超话 #醉鹅娘品味小知识# @鲜城 【10元券】微博专享限时领券",
      "pinyin": "Yesterday 19:25 from wēi bó shì pín zěn me néng ràng yī dié cài cóng 20 kuài qián biàn chéng 200 kuài qián ne ？ zuì é niáng chāo huà # zuì é niáng pǐn wèi xiǎo zhī shí # @ xiān chéng 【10 yuán quàn 】 wēi bó zhuān xiǎng xiàn shí lǐng quàn",
      "translation": "Yesterday 19:25: How can one dish become 10 times pricier?",
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "Yesterday 19:25 from 微博视频怎么能让一碟菜从20块钱变成200块钱呢？醉鹅娘超话 #醉鹅娘品味小知识# @鲜城 【10元券】微博专享限时领券",
          "pinyin": "Yesterday 19:25 from wēi bó shì pín zěn me néng ràng yī dié cài cóng 20 kuài qián biàn chéng 200 kuài qián ne ？ zuì é niáng chāo huà # zuì é niáng pǐn wèi xiǎo zhī shí # @ xiān chéng 【10 yuán quàn 】 wēi bó zhuān xiǎng xiàn shí lǐng quàn",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "醉鹅娘的微博视频在礼盒后面有一个品鉴方法1010元券】微博专享限时领券",
      "pinyin": "zuì é niáng de wēi bó shì pín zài lǐ hé hòu miàn yǒu yí gè pǐn jiàn fāng fǎ 1010 yuán quàn 】 wēi bó zhuān xiǎng xiàn shí lǐng quàn",
      "translation": "In the gift box behind the video: tasting method with 10 yuan coupon。', 'tokens': [{'text': '醉鹅娘的微博视频', 'kind': 'phrase'}, {'text': '在礼盒后面', 'kind': 'phrase'}, {'text': '有一个品鉴方法', 'kind': 'phrase'}, {'text': '1010元券', 'kind': 'phrase'}, {'text': '微博专享限时领券', 'kind': 'phrase'}]",
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "醉鹅娘的微博视频在礼盒后面有一个品鉴方法1010元券】微博专享限时领券",
          "pinyin": "zuì é niáng de wēi bó shì pín zài lǐ hé hòu miàn yǒu yí gè pǐn jiàn fāng fǎ 1010 yuán quàn 】 wēi bó zhuān xiǎng xiàn shí lǐng quàn",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s4",
      "hanzi": "用券后价：¥299.00领券20.3K views 4846",
      "pinyin": "yòng quàn hòu jià ：¥299.00 lǐng quàn 20.3K views 4846",
      "translation": null,
      "tokens": [
        {
          "id": "s4-t1",
          "hanzi": "用券后价：¥299.00领券20.3K views 4846",
          "pinyin": "yòng quàn hòu jià ：¥299.00 lǐng quàn 20.3K views 4846",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s5",
      "hanzi": "Weibo Video Discover Message Me 15:3415:34 Weibo Weibo 粉丝福利购2626醉鹅娘精品葡萄酒店5",
      "pinyin": "Weibo Video Discover Message Me 15:3415:34 Weibo Weibo fěn sī fú lì gòu 2626 zuì é niáng jīng pǐn pú táo jiǔ diàn 5",
      "translation": "Weibo Video Discover: message and user profile。', 'tokens': [{'text': 'Weibo Video Discover', 'kind': 'word'}, {'text': 'Message', 'kind': 'word'}, {'text': 'Me', 'kind': 'word'}, {'text': '15:3415:34 Weibo Weibo', 'kind': 'other'}, {'text': '粉丝福利购2626醉鹅娘精品葡萄酒店5', 'kind': 'phrase'}]",
      "tokens": [
        {
          "id": "s5-t1",
          "hanzi": "Weibo Video Discover Message Me 15:3415:34 Weibo Weibo 粉丝福利购2626醉鹅娘精品葡萄酒店5",
          "pinyin": "Weibo Video Discover Message Me 15:3415:34 Weibo Weibo fěn sī fú lì gòu 2626 zuì é niáng jīng pǐn pú táo jiǔ diàn 5",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s6",
      "hanzi": "使用期限2019.06.24-2019.07.31立即领券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮2笔成交现价：¥309用券后 ¥299.00",
      "pinyin": "shǐ yòng qī xiàn 2019.06.24-2019.07.31 lì jí lǐng quàn zuì é niáng liǎo bù qǐ é x shī ruì yú zi jiàng xī bó lì yà 30g lǐ hé zhuāng bāo yóu 2 bǐ chéng jiāo xiàn jià ：¥309 yòng quàn hòu ¥299.00",
      "translation": "Valid until 2019.07.31: Zuie amazing goose with caviar gift set, 2 sold at ¥299 after coupon。', 'tokens': [{'text': '使用期限', 'kind': 'phrase'}, {'text': '2019.06.24-2019.07.31', 'kind': 'other'}, {'text': '立即领券', 'kind': 'phrase'}, {'text': '醉鹅娘了不起鹅', 'kind': 'phrase'}, {'text': 'x', 'kind': 'other'}, {'text': '诗芮鱼子酱西伯利亚30g', 'kind': 'phrase'}, {'text': '礼盒装包邮', 'kind': 'phrase'}, {'text': '2笔成交', 'kind': 'phrase'}, {'text': '现价：¥309', 'kind': 'phrase'}, {'text': '用券后 ¥299.00', 'kind': 'phrase'}]",
      "tokens": [
        {
          "id": "s6-t1",
          "hanzi": "使用期限2019.06.24-2019.07.31立即领券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮2笔成交现价：¥309用券后 ¥299.00",
          "pinyin": "shǐ yòng qī xiàn 2019.06.24-2019.07.31 lì jí lǐng quàn zuì é niáng liǎo bù qǐ é x shī ruì yú zi jiàng xī bó lì yà 30g lǐ hé zhuāng bāo yóu 2 bǐ chéng jiāo xiàn jià ：¥309 yòng quàn hòu ¥299.00",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s7",
      "hanzi": "更多宝贝推荐优惠券 ¥5优惠券 ¥5顺风包邮101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券",
      "pinyin": "gèng duō bǎo bèi tuī jiàn yōu huì quàn ¥5 yōu huì quàn ¥5 shùn fēng bāo yóu 101 lǐng quàn xià dān lì jiǎn 5 yuán 188 yuán shōu cáng jiā gòu sòng kāi guàn lǐ xīn rén lǐ sòng 50g xún yú ròu kǎ lù gā hēi yú zi jiàng xī bó lì yà xún yú zǐ jiàng ... 106.001697 bǐ chéng jiāo yòng quàn hòu ¥98.00 yōu huì quàn ¥5 lǐng qǔ yú zi jiàng 7 nián shēng xī bó lì yà xún yú zǐ jiàng jí shí hēi yú zi jiàng guàn tou 1... 106.00484 bǐ chéng jiāo yòng quàn hòu ¥101.00 yōu huì quàn ¥5 lǐng qǔ 309 huì táo jià jià gé ¥339 lǐng quàn hòu yù jì jiǎn 10 yuán mǎn 699 jiǎn 30 diàn pù yōu huì quàn",
      "translation": "More recommendations: coupons, free shipping, and gifts for new users。', 'tokens': [{'text': '更多宝贝推荐', 'kind': 'phrase'}, {'text': '优惠券 ¥5', 'kind': 'phrase'}, {'text': '顺风包邮101领券下单立减5元188元', 'kind': 'phrase'}, {'text': '收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽', 'kind': 'phrase'}, {'text': '黑鱼子酱西伯利亚鲟鱼籽酱... 106.00', 'kind': 'phrase'}, {'text': '1697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱', 'kind': 'phrase'}, {'text': '7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00', 'kind': 'phrase'}, {'text': '484笔成交用券后 ¥101.00优惠券 ¥5领取', 'kind': 'phrase'}, {'text': '309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券', 'kind': 'phrase'}]",
      "tokens": [
        {
          "id": "s7-t1",
          "hanzi": "更多宝贝推荐优惠券 ¥5优惠券 ¥5顺风包邮101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券",
          "pinyin": "gèng duō bǎo bèi tuī jiàn yōu huì quàn ¥5 yōu huì quàn ¥5 shùn fēng bāo yóu 101 lǐng quàn xià dān lì jiǎn 5 yuán 188 yuán shōu cáng jiā gòu sòng kāi guàn lǐ xīn rén lǐ sòng 50g xún yú ròu kǎ lù gā hēi yú zi jiàng xī bó lì yà xún yú zǐ jiàng ... 106.001697 bǐ chéng jiāo yòng quàn hòu ¥98.00 yōu huì quàn ¥5 lǐng qǔ yú zi jiàng 7 nián shēng xī bó lì yà xún yú zǐ jiàng jí shí hēi yú zi jiàng guàn tou 1... 106.00484 bǐ chéng jiāo yòng quàn hòu ¥101.00 yōu huì quàn ¥5 lǐng qǔ 309 huì táo jià jià gé ¥339 lǐng quàn hòu yù jì jiǎn 10 yuán mǎn 699 jiǎn 30 diàn pù yōu huì quàn",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s8",
      "hanzi": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱",
      "pinyin": "zuì é niáng liǎo bù qǐ é x shī ruì yú zi jiàng xī bó lì yà 30g lǐ hé zhuāng 2 rén zàn guò bāng wǒ xuǎn fā huò sì chuān chéng dū kuài dì ： miǎn yùn fèi yuè xiāo 3 fú wù 7 tiān nèi fā huò · huài dān bāo péi · dìng dān xiǎn shēng chǎn rì qī chǎng míng ... fǎn huí 101 lǐng quàn xià dān lì jiǎn 5 yuán 188 yuán shōu cáng jiā gòu sòng kāi guàn lǐ xīn rén lǐ sòng 50g xún yú ròu kǎ lù gā hēi yú zi jiàng xī bó lì yà xún yú zǐ jiàng ... 106.001697 bǐ chéng jiāo yòng quàn hòu ¥98.00 yōu huì quàn ¥5 lǐng qǔ yú zi jiàng",
      "translation": "Same gift set, 2 people liked it, ships from Chengdu with free freight。', 'tokens': [{'text': '醉鹅娘了不起鹅 x",
      "tokens": [
        {
          "id": "s8-t1",
          "hanzi": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱",
          "pinyin": "zuì é niáng liǎo bù qǐ é x shī ruì yú zi jiàng xī bó lì yà 30g lǐ hé zhuāng 2 rén zàn guò bāng wǒ xuǎn fā huò sì chuān chéng dū kuài dì ： miǎn yùn fèi yuè xiāo 3 fú wù 7 tiān nèi fā huò · huài dān bāo péi · dìng dān xiǎn shēng chǎn rì qī chǎng míng ... fǎn huí 101 lǐng quàn xià dān lì jiǎn 5 yuán 188 yuán shōu cáng jiā gòu sòng kāi guàn lǐ xīn rén lǐ sòng 50g xún yú ròu kǎ lù gā hēi yú zi jiàng xī bó lì yà xún yú zǐ jiàng ... 106.001697 bǐ chéng jiāo yòng quàn hòu ¥98.00 yōu huì quàn ¥5 lǐng qǔ yú zi jiàng",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s9",
      "hanzi": "106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券",
      "pinyin": "106.00484 bǐ chéng jiāo yòng quàn hòu ¥101.00 yōu huì quàn ¥5 lǐng qǔ 309 huì táo jià jià gé ¥339 lǐng quàn hòu yù jì jiǎn 10 yuán mǎn 699 jiǎn 30 diàn pù yōu huì quàn",
      "translation": "484 deals at ¥101 after coupon, shop discount available。', 'tokens': [{'text': '106.00', 'kind': 'other'}, {'text': '484笔成交', 'kind': 'phrase'}, {'text': '用券后 ¥101.00优惠券 ¥5领取', 'kind': 'phrase'}, {'text': '309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券', 'kind': 'phrase'}]",
      "tokens": [
        {
          "id": "s9-t1",
          "hanzi": "106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券",
          "pinyin": "106.00484 bǐ chéng jiāo yòng quàn hòu ¥101.00 yōu huì quàn ¥5 lǐng qǔ 309 huì táo jià jià gé ¥339 lǐng quàn hòu yù jì jiǎn 10 yuán mǎn 699 jiǎn 30 diàn pù yōu huì quàn",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s10",
      "hanzi": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回加入购物车领券购买用券后价 ¥299",
      "pinyin": "zuì é niáng liǎo bù qǐ é x shī ruì yú zi jiàng xī bó lì yà 30g lǐ hé zhuāng 2 rén zàn guò bāng wǒ xuǎn fā huò sì chuān chéng dū kuài dì ： miǎn yùn fèi yuè xiāo 3 fú wù 7 tiān nèi fā huò · huài dān bāo péi · dìng dān xiǎn shēng chǎn rì qī chǎng míng ... fǎn huí jiā rù gòu wù chē lǐng quàn gòu mǎi yòng quàn hòu jià ¥299",
      "translation": "Add to cart and buy with coupon, price after coupon is ¥299。', 'tokens': [{'text': '醉鹅娘了不起鹅 x",
      "tokens": [
        {
          "id": "s10-t1",
          "hanzi": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回加入购物车领券购买用券后价 ¥299",
          "pinyin": "zuì é niáng liǎo bù qǐ é x shī ruì yú zi jiàng xī bó lì yà 30g lǐ hé zhuāng 2 rén zàn guò bāng wǒ xuǎn fā huò sì chuān chéng dū kuài dì ： miǎn yùn fèi yuè xiāo 3 fú wù 7 tiān nèi fā huò · huài dān bāo péi · dìng dān xiǎn shēng chǎn rì qī chǎng míng ... fǎn huí jiā rù gòu wù chē lǐng quàn gòu mǎi yòng quàn hòu jià ¥299",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "Weibo Following hot 粉丝福利购2626 醉鹅娘精品葡萄酒店5",
  "pinyin": "Weibo Following rè fěnsī fúlì gòu 2626 zuì éniáng jīngpǐn pútáojiǔdiàn 5",
  "meaning": "Trending Weibo post about a fan benefit purchase (ID 2626) for Zui E Niang’s premium grape wine shop (item 5).",
  "notes": "A social-media style phrase mixing English and Chinese; 粉丝 (fans) and 福利 (benefit) are common in online promotions.",
  "examples": [],
  "pinyinSource": "text_model_hint"
}
```

## 10. weibo_kol_1.jpg | zh | baidu/qianfan-ocr-fast:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=200, latency=37.15s
- Explain endpoint: status=200, latency=1.77s

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=True, attempts=1, latency=11.20s, prompt_tokens=4127, completion_tokens=890, total_tokens=5017, t/s=79.44
- `text analysis` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=18.19s, prompt_tokens=1275, completion_tokens=3830, total_tokens=5105, t/s=210.50
- `glossary enrichment` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=7.73s, prompt_tokens=1408, completion_tokens=1495, total_tokens=2903, t/s=193.50

### Vision Output
```json
{
  "documentText": "15:3315:3415:34 Search Weibo Weibo Following hot 粉丝福利购2626醉鹅娘醉鹅娘精品葡萄酒店5 Yesterday 19:25 from 微博视频怎么能让一碟菜从20块钱变成200块钱呢？醉鹅娘超话 #醉鹅娘品味小知识# @鲜城 【10元券】微博专享限时领券醉鹅娘的微博视频在礼盒后面有一个品鉴方法1010元券】微博专享限时领券用券后价：¥299.00领券20.3K views 4846 Weibo Video Discover Message Me 15:3415:34 Weibo Weibo 粉丝福利购2626醉鹅娘精品葡萄酒店510使用期限2019.06.24-2019.07.31立即领券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮2笔成交现价：¥309用券后 ¥299.00更多宝贝推荐优惠券 ¥5优惠券 ¥5顺风包邮101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回加入购物车领券购买用券后价 ¥299",
  "language": "zh-Hans",
  "readingLines": [],
  "pronunciationHints": [],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [
    {
      "hanzi": "15:34 Search Weibo",
      "translation": "15:34 搜索微博。', 'tokens': [{'text': '15:34', 'kind': 'other'}, {'text': 'Search', 'kind': 'word'}, {'text': 'Weibo', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "15:34 Search Weibo",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Weibo Following hot 粉丝福利购",
      "translation": "微博关注热门商品。', 'tokens': [{'text': 'Weibo', 'kind': 'word'}, {'text': 'Following', 'kind': 'word'}, {'text': 'hot', 'kind': 'word'}, {'text': '粉丝福利购', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "Weibo Following hot 粉丝福利购",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "醉鹅娘精品葡萄酒店5",
      "translation": "醉鹅娘精品葡萄酒店5。', 'tokens': [{'text': '醉鹅娘精品葡萄酒店5', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "醉鹅娘精品葡萄酒店5",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Yesterday 19:25 from 微博视频",
      "translation": "昨天19:25 来自微博视频。', 'tokens': [{'text': 'Yesterday', 'kind': 'word'}, {'text': '19:25', 'kind': 'other'}, {'text': 'from', 'kind': 'word'}, {'text': '微博视频', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "Yesterday 19:25 from 微博视频",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "怎么能让一碟菜从20块钱变成200块钱呢？",
      "translation": "如何让一道菜从20元变成200元？', 'tokens': [{'text': '怎么', 'kind': 'word'}, {'text': '能让', 'kind': 'word'}, {'text': '一碟菜', 'kind': 'phrase'}, {'text': '从', 'kind': 'word'}, {'text': '20块钱', 'kind': 'phrase'}, {'text': '变成', 'kind': 'word'}, {'text': '200块钱', 'kind': 'phrase'}, {'text': '呢', 'kind': 'punctuation'}]",
      "tokens": [
        {
          "text": "怎么能让一碟菜从20块钱变成200块钱呢？",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "醉鹅娘超话 #醉鹅娘品味小知识#",
      "translation": "醉鹅娘超话 #醉鹅娘品味小知识#。', 'tokens': [{'text': '醉鹅娘超话', 'kind': 'word'}, {'text': '#醉鹅娘品味小知识#', 'kind': 'other'}]",
      "tokens": [
        {
          "text": "醉鹅娘超话 #醉鹅娘品味小知识#",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "@鲜城 【10元券】微博专享限时领券",
      "translation": "@鲜城 【10元券】微博专享限时领券。', 'tokens': [{'text': '@鲜城', 'kind': 'other'}, {'text': '【10元券】', 'kind': 'other'}, {'text': '微博专享限时领券', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "@鲜城 【10元券】微博专享限时领券",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "醉鹅娘的微博视频在礼盒后面有一个品鉴方法1010元券",
      "translation": "醉鹅娘的视频在礼盒后有1010元品鉴券。', 'tokens': [{'text': '醉鹅娘的微博视频', 'kind': 'word'}, {'text': '在', 'kind': 'word'}, {'text': '礼盒', 'kind': 'word'}, {'text': '后面', 'kind': 'word'}, {'text': '有', 'kind': 'word'}, {'text': '一个品鉴方法1010元券', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "醉鹅娘的微博视频在礼盒后面有一个品鉴方法1010元券",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "微博专享限时领券用券后价：¥299.00领券20.3K views",
      "translation": "领券后价¥299.00，20.3K次观看。', 'tokens': [{'text': '微博专享限时领券', 'kind': 'word'}, {'text': '用券后价', 'kind': 'word'}, {'text': '¥299.00', 'kind': 'other'}, {'text': '领券', 'kind': 'word'}, {'text': '20.3K views', 'kind': 'other'}]",
      "tokens": [
        {
          "text": "微博专享限时领券用券后价：¥299.00领券20.3K views",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "4846 Weibo Video Discover Message Me",
      "translation": "4846 微博视频消息。', 'tokens': [{'text': '4846', 'kind': 'other'}, {'text': 'Weibo Video', 'kind': 'word'}, {'text': 'Discover', 'kind': 'word'}, {'text': 'Message', 'kind': 'word'}, {'text': 'Me', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "4846 Weibo Video Discover Message Me",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "15:3415:34 Weibo Weibo 粉丝福利购2626醉鹅娘精品葡萄酒店5",
      "translation": "15:34 微博 微博 粉丝福利购2626醉鹅娘精品葡萄酒店5。', 'tokens': [{'text': '15:3415:34', 'kind': 'other'}, {'text': 'Weibo Weibo', 'kind': 'word'}, {'text': '粉丝福利购2626醉鹅娘精品葡萄酒店5', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "15:3415:34 Weibo Weibo 粉丝福利购2626醉鹅娘精品葡萄酒店5",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "10使用期限2019.06.24-2019.07.31立即领券",
      "translation": "有效期2019.06.24-2019.07.31 立即领券。', 'tokens': [{'text': '10使用期限', 'kind': 'word'}, {'text': '2019.06.24-2019.07.31', 'kind': 'other'}, {'text': '立即领券', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "10使用期限2019.06.24-2019.07.31立即领券",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮",
      "translation": "醉鹅娘 x 诗芮鱼子酱西伯利亚30g 礼盒包邮。', 'tokens': [{'text': '醉鹅娘了不起鹅', 'kind': 'word'}, {'text': 'x', 'kind': 'other'}, {'text': '诗芮鱼子酱西伯利亚30g', 'kind': 'word'}, {'text': '礼盒装包邮', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "2笔成交现价：¥309用券后 ¥299.00更多宝贝推荐",
      "translation": "2笔成交现价¥309，领券后¥299.00 更多推荐。', 'tokens': [{'text': '2笔成交', 'kind': 'word'}, {'text': '现价：¥309', 'kind': 'other'}, {'text': '用券后', 'kind': 'word'}, {'text': '¥299.00', 'kind': 'other'}, {'text': '更多宝贝推荐', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "2笔成交现价：¥309用券后 ¥299.00更多宝贝推荐",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "优惠券 ¥5顺风包邮101领券下单立减5元",
      "translation": "优惠券¥5，顺邮101 领券立减5元。', 'tokens': [{'text': '优惠券', 'kind': 'word'}, {'text': '¥5', 'kind': 'other'}, {'text': '顺风包邮101', 'kind': 'word'}, {'text': '领券下单立减5元', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "优惠券 ¥5顺风包邮101领券下单立减5元",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱...",
      "translation": "收藏加购送开罐礼，新人送50g鲟鱼子酱。', 'tokens': [{'text': '188元收藏加购送开罐礼', 'kind': 'word'}, {'text': '新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱...', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱...",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1...",
      "translation": "106.00 1697笔成交，领券后¥98.00 领取7年生成品鱼子酱罐头。', 'tokens': [{'text': '106.001697笔成交', 'kind': 'other'}, {'text': '用券后', 'kind': 'word'}, {'text': '¥98.00', 'kind': 'other'}, {'text': '优惠券', 'kind': 'word'}, {'text': '¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1...', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1...",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "106.00484笔成交用券后 ¥101.00优惠券 ¥5领取",
      "translation": "106.00 484笔成交，领券后¥101.00。', 'tokens': [{'text': '106.00484笔成交', 'kind': 'other'}, {'text': '用券后', 'kind': 'word'}, {'text': '¥101.00', 'kind': 'other'}, {'text': '优惠券', 'kind': 'word'}, {'text': '¥5领取', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "106.00484笔成交用券后 ¥101.00优惠券 ¥5领取",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券",
      "translation": "惠淘价¥339，领券预计减10元，满699减30店铺券。', 'tokens': [{'text': '309惠淘价价格', 'kind': 'word'}, {'text': '¥339领券后预计减10元', 'kind': 'word'}, {'text': '满699减30店铺优惠券', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货",
      "translation": "醉鹅娘 x 诗芮鱼子酱西伯利亚30g，2人推荐代发货。', 'tokens': [{'text': '醉鹅娘了不起鹅', 'kind': 'word'}, {'text': 'x', 'kind': 'other'}, {'text': '诗芮鱼子酱西伯利亚30g', 'kind': 'word'}, {'text': '礼盒装', 'kind': 'word'}, {'text': '2人赞过帮我选发货', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名...",
      "translation": "四川成都快递：免运费，月销3，7天内发货，坏单包赔。', 'tokens': [{'text': '四川成都快递', 'kind': 'word'}, {'text': '：免运费', 'kind': 'word'}, {'text': '月销3', 'kind': 'word'}, {'text': '服务7天内发货', 'kind': 'word'}, {'text': '·坏单包赔·订单险生产日期厂名...', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名...",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "返回101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱...",
      "translation": "领券立减5元，收藏加购送开罐礼，新人送50g鲟鱼子酱。', 'tokens': [{'text': '返回101领券下单立减5元', 'kind': 'word'}, {'text': '188元收藏加购送开罐礼', 'kind': 'word'}, {'text': '新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱...', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "返回101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱...",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1...",
      "translation": "106.00 1697笔成交，领券后¥98.00 领取7年生成品鱼子酱罐头。', 'tokens': [{'text': '106.001697笔成交', 'kind': 'other'}, {'text': '用券后', 'kind': 'word'}, {'text': '¥98.00', 'kind': 'other'}, {'text': '优惠券', 'kind': 'word'}, {'text': '¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1...', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1...",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "106.00484笔成交用券后 ¥101.00优惠券 ¥5领取",
      "translation": "106.00 484笔成交，领券后¥101.00。', 'tokens': [{'text': '106.00484笔成交', 'kind': 'other'}, {'text': '用券后', 'kind': 'word'}, {'text': '¥101.00', 'kind': 'other'}, {'text': '优惠券', 'kind': 'word'}, {'text': '¥5领取', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "106.00484笔成交用券后 ¥101.00优惠券 ¥5领取",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券",
      "translation": "惠淘价¥339，领券预计减10元，满699减30店铺券。', 'tokens': [{'text': '309惠淘价价格', 'kind': 'word'}, {'text': '¥339领券后预计减10元', 'kind': 'word'}, {'text': '满699减30店铺优惠券', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货",
      "translation": "醉鹅娘 x 诗芮鱼子酱西伯利亚30g，2人推荐代发货。', 'tokens': [{'text': '醉鹅娘了不起鹅', 'kind': 'word'}, {'text': 'x', 'kind': 'other'}, {'text': '诗芮鱼子酱西伯利亚30g', 'kind': 'word'}, {'text': '礼盒装', 'kind': 'word'}, {'text': '2人赞过帮我选发货', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名...",
      "translation": "四川成都快递：免运费，月销3，7天内发货，坏单包赔。', 'tokens': [{'text': '四川成都快递', 'kind': 'word'}, {'text': '：免运费', 'kind': 'word'}, {'text': '月销3', 'kind': 'word'}, {'text': '服务7天内发货', 'kind': 'word'}, {'text': '·坏单包赔·订单险生产日期厂名...', 'kind': 'word'}]",
      "tokens": [
        {
          "text": "四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名...",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "加入购物车领券购买用券后价 ¥299",
      "translation": "加入购物车，领券购买后价¥299。', 'tokens': [{'text': '加入购物车', 'kind': 'word'}, {'text': '领券购买', 'kind': 'word'}, {'text': '用券后价', 'kind': 'word'}, {'text': '¥299', 'kind': 'other'}]",
      "tokens": [
        {
          "text": "加入购物车领券购买用券后价 ¥299",
          "kind": "other",
          "meaning": null
        }
      ]
    }
  ],
  "glossary": [],
  "pronunciationHints": []
}
```

### Glossary Enrichment Output
```json
{
  "entries": [
    {
      "text": "粉丝福利购2626醉鹅娘精品葡萄酒店5 Yesterday 19:25 from 微博视频怎么能让一碟菜从20块钱变成200块钱呢？醉鹅娘超话 #醉鹅娘品味小知识# @鲜城 【10元券】微博专享限时领券醉鹅娘的微博视频在礼盒后面有一个品鉴方法1010元券】微博专享限时领券用券后价：¥299.00领券20.3K views 4846 Weibo Video Discover Message Me 15:3415:34 Weibo Weibo 粉丝福利购2626醉鹅娘精品葡萄酒店510使用期限2019.06.24-2019.07.31立即领券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮2笔成交现价：¥309用券后 ¥299.00更多宝贝推荐优惠券 ¥5优惠券 ¥5顺风包邮101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回加入购物车领券购买用券后价 ¥299",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "醉鹅娘精品葡萄酒店",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "微博视频",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "怎么能让一碟菜从",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "块钱变成",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "块钱呢",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "醉鹅娘超话",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "醉鹅娘品味小知识",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "鲜城",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "元券",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "微博专享限时领券",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "醉鹅娘的微博视频在礼盒后面有一个品鉴方法",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "微博专享限时领券用券后价",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "领券",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "使用期限",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "立即领券",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "醉鹅娘了不起鹅",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "诗芮鱼子酱西伯利亚",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "礼盒装包邮",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "笔成交现价",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "用券后",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "更多宝贝推荐",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "优惠券",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "顺风包邮",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "领券下单立减",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "元",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "元收藏加购送开罐礼新人礼送",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "笔成交用券后",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "领取鱼子酱",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "领取",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "惠淘价价格",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "领券后预计减",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "元满",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "减",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "店铺优惠券",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "礼盒装",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "人赞过帮我选发货",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "四川成都快递",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "免运费月销",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "服务",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "天内发货",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "坏单包赔",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "订单险生产日期厂名",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "返回",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "加入购物车领券购买用券后价",
      "literalMeaning": null,
      "exampleSentence": null
    }
  ]
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "15:3315:3415:34 Search Weibo Weibo Following hot 粉丝福利购2626醉鹅娘醉鹅娘精品葡萄酒店5 Yesterday 19:25 from 微博视频怎么能让一碟菜从20块钱变成200块钱呢？醉鹅娘超话 #醉鹅娘品味小知识# @鲜城 【10元券】微博专享限时领券醉鹅娘的微博视频在礼盒后面有一个品鉴方法1010元券】微博专享限时领券用券后价：¥299.00领券20.3K views 4846 Weibo Video Discover Message Me 15:3415:34 Weibo Weibo 粉丝福利购2626醉鹅娘精品葡萄酒店510使用期限2019.06.24-2019.07.31立即领券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮2笔成交现价：¥309用券后 ¥299.00更多宝贝推荐优惠券 ¥5优惠券 ¥5顺风包邮101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回加入购物车领券购买用券后价 ¥299",
  "language": "zh-Hans",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "粉丝福利购",
      "pinyin": "fěn sī fú lì gòu",
      "translation": "微博关注热门商品。', 'tokens': [{'text': 'Weibo', 'kind': 'word'}, {'text': 'Following', 'kind': 'word'}, {'text': 'hot', 'kind': 'word'}, {'text': '粉丝福利购', 'kind': 'word'}]",
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "粉丝福利购",
          "pinyin": "fěn sī fú lì gòu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "醉鹅娘精品葡萄酒店",
      "pinyin": "zuì é niáng jīng pǐn pú táo jiǔ diàn",
      "translation": "醉鹅娘精品葡萄酒店5。', 'tokens': [{'text': '醉鹅娘精品葡萄酒店5', 'kind': 'word'}]",
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "醉鹅娘精品葡萄酒店",
          "pinyin": "zuì é niáng jīng pǐn pú táo jiǔ diàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "微博视频",
      "pinyin": "wēi bó shì pín",
      "translation": "昨天19:25 来自微博视频。', 'tokens': [{'text': 'Yesterday', 'kind': 'word'}, {'text': '19:25', 'kind': 'other'}, {'text': 'from', 'kind': 'word'}, {'text': '微博视频', 'kind': 'word'}]",
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "微博视频",
          "pinyin": "wēi bó shì pín",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s4",
      "hanzi": "怎么能让一碟菜从块钱变成块钱呢？",
      "pinyin": "zěn me néng ràng yī dié cài cóng kuài qián biàn chéng kuài qián ne？",
      "translation": null,
      "tokens": [
        {
          "id": "s4-t1",
          "hanzi": "怎么能让一碟菜从",
          "pinyin": "zěn me néng ràng yī dié cài cóng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t2",
          "hanzi": "块钱变成",
          "pinyin": "kuài qián biàn chéng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t3",
          "hanzi": "块钱呢",
          "pinyin": "kuài qián ne",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t4",
          "hanzi": "？",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s5",
      "hanzi": "醉鹅娘超话醉鹅娘品味小知识",
      "pinyin": "zuì é niáng chāo huà zuì é niáng pǐn wèi xiǎo zhī shí",
      "translation": "醉鹅娘超话 #醉鹅娘品味小知识#。', 'tokens': [{'text': '醉鹅娘超话', 'kind': 'word'}, {'text': '#醉鹅娘品味小知识#', 'kind': 'other'}]",
      "tokens": [
        {
          "id": "s5-t1",
          "hanzi": "醉鹅娘超话",
          "pinyin": "zuì é niáng chāo huà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t2",
          "hanzi": "醉鹅娘品味小知识",
          "pinyin": "zuì é niáng pǐn wèi xiǎo zhī shí",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s6",
      "hanzi": "鲜城元券微博专享限时领券",
      "pinyin": "xiān chéng yuán quàn wēi bó zhuān xiǎng xiàn shí lǐng quàn",
      "translation": "@鲜城 【10元券】微博专享限时领券。', 'tokens': [{'text': '@鲜城', 'kind': 'other'}, {'text': '【10元券】', 'kind': 'other'}, {'text': '微博专享限时领券', 'kind': 'word'}]",
      "tokens": [
        {
          "id": "s6-t1",
          "hanzi": "鲜城",
          "pinyin": "xiān chéng",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t2",
          "hanzi": "元券",
          "pinyin": "yuán quàn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t3",
          "hanzi": "微博专享限时领券",
          "pinyin": "wēi bó zhuān xiǎng xiàn shí lǐng quàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s7",
      "hanzi": "醉鹅娘的微博视频在礼盒后面有一个品鉴方法元券",
      "pinyin": "zuì é niáng de wēi bó shì pín zài lǐ hé hòu miàn yǒu yí gè pǐn jiàn fāng fǎ yuán quàn",
      "translation": null,
      "tokens": [
        {
          "id": "s7-t1",
          "hanzi": "醉鹅娘的微博视频在礼盒后面有一个品鉴方法",
          "pinyin": "zuì é niáng de wēi bó shì pín zài lǐ hé hòu miàn yǒu yí gè pǐn jiàn fāng fǎ",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t2",
          "hanzi": "元券",
          "pinyin": "yuán quàn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s8",
      "hanzi": "微博专享限时领券用券后价：领券",
      "pinyin": "wēi bó zhuān xiǎng xiàn shí lǐng quàn yòng quàn hòu jià： lǐng quàn",
      "translation": "领券后价¥299.00，20.3K次观看。', 'tokens': [{'text': '微博专享限时领券', 'kind': 'word'}, {'text': '用券后价', 'kind': 'word'}, {'text': '¥299.00', 'kind': 'other'}, {'text': '领券', 'kind': 'word'}, {'text': '20.3K views', 'kind': 'other'}]",
      "tokens": [
        {
          "id": "s8-t1",
          "hanzi": "微博专享限时领券用券后价",
          "pinyin": "wēi bó zhuān xiǎng xiàn shí lǐng quàn yòng quàn hòu jià",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t2",
          "hanzi": "：",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t3",
          "hanzi": "领券",
          "pinyin": "lǐng quàn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s9",
      "hanzi": "粉丝福利购醉鹅娘精品葡萄酒店",
      "pinyin": "fěn sī fú lì gòu zuì é niáng jīng pǐn pú táo jiǔ diàn",
      "translation": "15:34 微博 微博 粉丝福利购2626醉鹅娘精品葡萄酒店5。', 'tokens': [{'text': '15:3415:34', 'kind': 'other'}, {'text': 'Weibo Weibo', 'kind': 'word'}, {'text': '粉丝福利购2626醉鹅娘精品葡萄酒店5', 'kind': 'word'}]",
      "tokens": [
        {
          "id": "s9-t1",
          "hanzi": "粉丝福利购",
          "pinyin": "fěn sī fú lì gòu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t2",
          "hanzi": "醉鹅娘精品葡萄酒店",
          "pinyin": "zuì é niáng jīng pǐn pú táo jiǔ diàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s10",
      "hanzi": "使用期限-立即领券",
      "pinyin": "shǐ yòng qī xiàn- lì jí lǐng quàn",
      "translation": "有效期2019.06.24-2019.07.31 立即领券。', 'tokens': [{'text': '10使用期限', 'kind': 'word'}, {'text': '2019.06.24-2019.07.31', 'kind': 'other'}, {'text': '立即领券', 'kind': 'word'}]",
      "tokens": [
        {
          "id": "s10-t1",
          "hanzi": "使用期限",
          "pinyin": "shǐ yòng qī xiàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t2",
          "hanzi": "-",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t3",
          "hanzi": "立即领券",
          "pinyin": "lì jí lǐng quàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s11",
      "hanzi": "醉鹅娘了不起鹅诗芮鱼子酱西伯利亚礼盒装包邮",
      "pinyin": "zuì é niáng liǎo bù qǐ é shī ruì yú zi jiàng xī bó lì yà lǐ hé zhuāng bāo yóu",
      "translation": "醉鹅娘 x",
      "tokens": [
        {
          "id": "s11-t1",
          "hanzi": "醉鹅娘了不起鹅",
          "pinyin": "zuì é niáng liǎo bù qǐ é",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t2",
          "hanzi": "诗芮鱼子酱西伯利亚",
          "pinyin": "shī ruì yú zi jiàng xī bó lì yà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t3",
          "hanzi": "礼盒装包邮",
          "pinyin": "lǐ hé zhuāng bāo yóu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s12",
      "hanzi": "笔成交现价：用券后更多宝贝推荐",
      "pinyin": "bǐ chéng jiāo xiàn jià： yòng quàn hòu gèng duō bǎo bèi tuī jiàn",
      "translation": "2笔成交现价¥309，领券后¥299.00 更多推荐。', 'tokens': [{'text': '2笔成交', 'kind': 'word'}, {'text': '现价：¥309', 'kind': 'other'}, {'text': '用券后', 'kind': 'word'}, {'text': '¥299.00', 'kind': 'other'}, {'text': '更多宝贝推荐', 'kind': 'word'}]",
      "tokens": [
        {
          "id": "s12-t1",
          "hanzi": "笔成交现价",
          "pinyin": "bǐ chéng jiāo xiàn jià",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s12-t2",
          "hanzi": "：",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s12-t3",
          "hanzi": "用券后",
          "pinyin": "yòng quàn hòu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s12-t4",
          "hanzi": "更多宝贝推荐",
          "pinyin": "gèng duō bǎo bèi tuī jiàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s13",
      "hanzi": "优惠券顺风包邮领券下单立减元",
      "pinyin": "yōu huì quàn shùn fēng bāo yóu lǐng quàn xià dān lì jiǎn yuán",
      "translation": "优惠券¥5，顺邮101 领券立减5元。', 'tokens': [{'text': '优惠券', 'kind': 'word'}, {'text': '¥5', 'kind': 'other'}, {'text': '顺风包邮101', 'kind': 'word'}, {'text': '领券下单立减5元', 'kind': 'word'}]",
      "tokens": [
        {
          "id": "s13-t1",
          "hanzi": "优惠券",
          "pinyin": "yōu huì quàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t2",
          "hanzi": "顺风包邮",
          "pinyin": "shùn fēng bāo yóu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t3",
          "hanzi": "领券下单立减",
          "pinyin": "lǐng quàn xià dān lì jiǎn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t4",
          "hanzi": "元",
          "pinyin": "yuán",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s14",
      "hanzi": "元收藏加购送开罐礼新人礼送鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱",
      "pinyin": "yuán shōu cáng jiā gòu sòng kāi guàn lǐ xīn rén lǐ sòng xún yú ròu kǎ lù gā hēi yú zi jiàng xī bó lì yà xún yú zǐ jiàng",
      "translation": "收藏加购送开罐礼，新人送50g鲟鱼子酱。', 'tokens': [{'text': '188元收藏加购送开罐礼', 'kind': 'word'}, {'text': '新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱...', 'kind': 'word'}]",
      "tokens": [
        {
          "id": "s14-t1",
          "hanzi": "元收藏加购送开罐礼新人礼送",
          "pinyin": "yuán shōu cáng jiā gòu sòng kāi guàn lǐ xīn rén lǐ sòng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s14-t2",
          "hanzi": "鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱",
          "pinyin": "xún yú ròu kǎ lù gā hēi yú zi jiàng xī bó lì yà xún yú zǐ jiàng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s15",
      "hanzi": "笔成交用券后优惠券领取鱼子酱年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头",
      "pinyin": "bǐ chéng jiāo yòng quàn hòu yōu huì quàn lǐng qǔ yú zi jiàng nián shēng xī bó lì yà xún yú zǐ jiàng jí shí hēi yú zi jiàng guàn tou",
      "translation": null,
      "tokens": [
        {
          "id": "s15-t1",
          "hanzi": "笔成交用券后",
          "pinyin": "bǐ chéng jiāo yòng quàn hòu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t2",
          "hanzi": "优惠券",
          "pinyin": "yōu huì quàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t3",
          "hanzi": "领取鱼子酱",
          "pinyin": "lǐng qǔ yú zi jiàng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s15-t4",
          "hanzi": "年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头",
          "pinyin": "nián shēng xī bó lì yà xún yú zǐ jiàng jí shí hēi yú zi jiàng guàn tou",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s16",
      "hanzi": "笔成交用券后优惠券领取",
      "pinyin": "bǐ chéng jiāo yòng quàn hòu yōu huì quàn lǐng qǔ",
      "translation": "106.00 484笔成交，领券后¥101.00。', 'tokens': [{'text': '106.00484笔成交', 'kind': 'other'}, {'text': '用券后', 'kind': 'word'}, {'text': '¥101.00', 'kind': 'other'}, {'text': '优惠券', 'kind': 'word'}, {'text': '¥5领取', 'kind': 'word'}]",
      "tokens": [
        {
          "id": "s16-t1",
          "hanzi": "笔成交用券后",
          "pinyin": "bǐ chéng jiāo yòng quàn hòu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s16-t2",
          "hanzi": "优惠券",
          "pinyin": "yōu huì quàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s16-t3",
          "hanzi": "领取",
          "pinyin": "lǐng qǔ",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s17",
      "hanzi": "惠淘价价格领券后预计减元满减店铺优惠券",
      "pinyin": "huì táo jià jià gé lǐng quàn hòu yù jì jiǎn yuán mǎn jiǎn diàn pù yōu huì quàn",
      "translation": "惠淘价¥339，领券预计减10元，满699减30店铺券。', 'tokens': [{'text': '309惠淘价价格', 'kind': 'word'}, {'text': '¥339领券后预计减10元', 'kind': 'word'}, {'text': '满699减30店铺优惠券', 'kind': 'word'}]",
      "tokens": [
        {
          "id": "s17-t1",
          "hanzi": "惠淘价价格",
          "pinyin": "huì táo jià jià gé",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s17-t2",
          "hanzi": "领券后预计减",
          "pinyin": "lǐng quàn hòu yù jì jiǎn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s17-t3",
          "hanzi": "元满",
          "pinyin": "yuán mǎn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s17-t4",
          "hanzi": "减",
          "pinyin": "jiǎn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s17-t5",
          "hanzi": "店铺优惠券",
          "pinyin": "diàn pù yōu huì quàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s18",
      "hanzi": "醉鹅娘了不起鹅诗芮鱼子酱西伯利亚礼盒装人赞过帮我选发货",
      "pinyin": "zuì é niáng liǎo bù qǐ é shī ruì yú zi jiàng xī bó lì yà lǐ hé zhuāng rén zàn guò bāng wǒ xuǎn fā huò",
      "translation": "醉鹅娘 x",
      "tokens": [
        {
          "id": "s18-t1",
          "hanzi": "醉鹅娘了不起鹅",
          "pinyin": "zuì é niáng liǎo bù qǐ é",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t2",
          "hanzi": "诗芮鱼子酱西伯利亚",
          "pinyin": "shī ruì yú zi jiàng xī bó lì yà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t3",
          "hanzi": "礼盒装",
          "pinyin": "lǐ hé zhuāng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t4",
          "hanzi": "人赞过帮我选发货",
          "pinyin": "rén zàn guò bāng wǒ xuǎn fā huò",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s19",
      "hanzi": "四川成都快递：免运费月销服务天内发货·坏单包赔·订单险生产日期厂名",
      "pinyin": "sì chuān chéng dū kuài dì： miǎn yùn fèi yuè xiāo fú wù tiān nèi fā huò· huài dān bāo péi· dìng dān xiǎn shēng chǎn rì qī chǎng míng",
      "translation": "四川成都快递：免运费，月销3，7天内发货，坏单包赔。', 'tokens': [{'text': '四川成都快递', 'kind': 'word'}, {'text': '：免运费', 'kind': 'word'}, {'text': '月销3', 'kind': 'word'}, {'text': '服务7天内发货', 'kind': 'word'}, {'text': '·坏单包赔·订单险生产日期厂名...', 'kind': 'word'}]",
      "tokens": [
        {
          "id": "s19-t1",
          "hanzi": "四川成都快递",
          "pinyin": "sì chuān chéng dū kuài dì",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t2",
          "hanzi": "：",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t3",
          "hanzi": "免运费月销",
          "pinyin": "miǎn yùn fèi yuè xiāo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t4",
          "hanzi": "服务",
          "pinyin": "fú wù",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t5",
          "hanzi": "天内发货",
          "pinyin": "tiān nèi fā huò",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t6",
          "hanzi": "·",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t7",
          "hanzi": "坏单包赔",
          "pinyin": "huài dān bāo péi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t8",
          "hanzi": "·",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s19-t9",
          "hanzi": "订单险生产日期厂名",
          "pinyin": "dìng dān xiǎn shēng chǎn rì qī chǎng míng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s20",
      "hanzi": "返回领券下单立减元元收藏加购送开罐礼新人礼送鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱",
      "pinyin": "fǎn huí lǐng quàn xià dān lì jiǎn yuán yuán shōu cáng jiā gòu sòng kāi guàn lǐ xīn rén lǐ sòng xún yú ròu kǎ lù gā hēi yú zi jiàng xī bó lì yà xún yú zǐ jiàng",
      "translation": "领券立减5元，收藏加购送开罐礼，新人送50g鲟鱼子酱。', 'tokens': [{'text': '返回101领券下单立减5元', 'kind': 'word'}, {'text': '188元收藏加购送开罐礼', 'kind': 'word'}, {'text': '新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱...', 'kind': 'word'}]",
      "tokens": [
        {
          "id": "s20-t1",
          "hanzi": "返回",
          "pinyin": "fǎn huí",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s20-t2",
          "hanzi": "领券下单立减",
          "pinyin": "lǐng quàn xià dān lì jiǎn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s20-t3",
          "hanzi": "元",
          "pinyin": "yuán",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s20-t4",
          "hanzi": "元收藏加购送开罐礼新人礼送",
          "pinyin": "yuán shōu cáng jiā gòu sòng kāi guàn lǐ xīn rén lǐ sòng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s20-t5",
          "hanzi": "鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱",
          "pinyin": "xún yú ròu kǎ lù gā hēi yú zi jiàng xī bó lì yà xún yú zǐ jiàng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s21",
      "hanzi": "笔成交用券后优惠券领取鱼子酱年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头",
      "pinyin": "bǐ chéng jiāo yòng quàn hòu yōu huì quàn lǐng qǔ yú zi jiàng nián shēng xī bó lì yà xún yú zǐ jiàng jí shí hēi yú zi jiàng guàn tou",
      "translation": null,
      "tokens": [
        {
          "id": "s21-t1",
          "hanzi": "笔成交用券后",
          "pinyin": "bǐ chéng jiāo yòng quàn hòu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t2",
          "hanzi": "优惠券",
          "pinyin": "yōu huì quàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t3",
          "hanzi": "领取鱼子酱",
          "pinyin": "lǐng qǔ yú zi jiàng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t4",
          "hanzi": "年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头",
          "pinyin": "nián shēng xī bó lì yà xún yú zǐ jiàng jí shí hēi yú zi jiàng guàn tou",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s22",
      "hanzi": "笔成交用券后优惠券领取",
      "pinyin": "bǐ chéng jiāo yòng quàn hòu yōu huì quàn lǐng qǔ",
      "translation": "106.00 484笔成交，领券后¥101.00。', 'tokens': [{'text': '106.00484笔成交', 'kind': 'other'}, {'text': '用券后', 'kind': 'word'}, {'text': '¥101.00', 'kind': 'other'}, {'text': '优惠券', 'kind': 'word'}, {'text': '¥5领取', 'kind': 'word'}]",
      "tokens": [
        {
          "id": "s22-t1",
          "hanzi": "笔成交用券后",
          "pinyin": "bǐ chéng jiāo yòng quàn hòu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t2",
          "hanzi": "优惠券",
          "pinyin": "yōu huì quàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t3",
          "hanzi": "领取",
          "pinyin": "lǐng qǔ",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s23",
      "hanzi": "惠淘价价格领券后预计减元满减店铺优惠券",
      "pinyin": "huì táo jià jià gé lǐng quàn hòu yù jì jiǎn yuán mǎn jiǎn diàn pù yōu huì quàn",
      "translation": "惠淘价¥339，领券预计减10元，满699减30店铺券。', 'tokens': [{'text': '309惠淘价价格', 'kind': 'word'}, {'text': '¥339领券后预计减10元', 'kind': 'word'}, {'text': '满699减30店铺优惠券', 'kind': 'word'}]",
      "tokens": [
        {
          "id": "s23-t1",
          "hanzi": "惠淘价价格",
          "pinyin": "huì táo jià jià gé",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s23-t2",
          "hanzi": "领券后预计减",
          "pinyin": "lǐng quàn hòu yù jì jiǎn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s23-t3",
          "hanzi": "元满",
          "pinyin": "yuán mǎn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s23-t4",
          "hanzi": "减",
          "pinyin": "jiǎn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s23-t5",
          "hanzi": "店铺优惠券",
          "pinyin": "diàn pù yōu huì quàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s24",
      "hanzi": "醉鹅娘了不起鹅诗芮鱼子酱西伯利亚礼盒装人赞过帮我选发货",
      "pinyin": "zuì é niáng liǎo bù qǐ é shī ruì yú zi jiàng xī bó lì yà lǐ hé zhuāng rén zàn guò bāng wǒ xuǎn fā huò",
      "translation": "醉鹅娘 x",
      "tokens": [
        {
          "id": "s24-t1",
          "hanzi": "醉鹅娘了不起鹅",
          "pinyin": "zuì é niáng liǎo bù qǐ é",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s24-t2",
          "hanzi": "诗芮鱼子酱西伯利亚",
          "pinyin": "shī ruì yú zi jiàng xī bó lì yà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s24-t3",
          "hanzi": "礼盒装",
          "pinyin": "lǐ hé zhuāng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s24-t4",
          "hanzi": "人赞过帮我选发货",
          "pinyin": "rén zàn guò bāng wǒ xuǎn fā huò",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s25",
      "hanzi": "四川成都快递：免运费月销服务天内发货·坏单包赔·订单险生产日期厂名",
      "pinyin": "sì chuān chéng dū kuài dì： miǎn yùn fèi yuè xiāo fú wù tiān nèi fā huò· huài dān bāo péi· dìng dān xiǎn shēng chǎn rì qī chǎng míng",
      "translation": "四川成都快递：免运费，月销3，7天内发货，坏单包赔。', 'tokens': [{'text': '四川成都快递', 'kind': 'word'}, {'text': '：免运费', 'kind': 'word'}, {'text': '月销3', 'kind': 'word'}, {'text': '服务7天内发货', 'kind': 'word'}, {'text': '·坏单包赔·订单险生产日期厂名...', 'kind': 'word'}]",
      "tokens": [
        {
          "id": "s25-t1",
          "hanzi": "四川成都快递",
          "pinyin": "sì chuān chéng dū kuài dì",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s25-t2",
          "hanzi": "：",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s25-t3",
          "hanzi": "免运费月销",
          "pinyin": "miǎn yùn fèi yuè xiāo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s25-t4",
          "hanzi": "服务",
          "pinyin": "fú wù",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s25-t5",
          "hanzi": "天内发货",
          "pinyin": "tiān nèi fā huò",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s25-t6",
          "hanzi": "·",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s25-t7",
          "hanzi": "坏单包赔",
          "pinyin": "huài dān bāo péi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s25-t8",
          "hanzi": "·",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s25-t9",
          "hanzi": "订单险生产日期厂名",
          "pinyin": "dìng dān xiǎn shēng chǎn rì qī chǎng míng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s26",
      "hanzi": "加入购物车领券购买用券后价",
      "pinyin": "jiā rù gòu wù chē lǐng quàn gòu mǎi yòng quàn hòu jià",
      "translation": "加入购物车，领券购买后价¥299。', 'tokens': [{'text': '加入购物车', 'kind': 'word'}, {'text': '领券购买', 'kind': 'word'}, {'text': '用券后价', 'kind': 'word'}, {'text': '¥299', 'kind': 'other'}]",
      "tokens": [
        {
          "id": "s26-t1",
          "hanzi": "加入购物车领券购买用券后价",
          "pinyin": "jiā rù gòu wù chē lǐng quàn gòu mǎi yòng quàn hòu jià",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "粉丝福利购",
      "pinyin": "fěn sī fú lì gòu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "醉鹅娘精品葡萄酒店",
      "pinyin": "zuì é niáng jīng pǐn pú táo jiǔ diàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "微博视频",
      "pinyin": "wēi bó shì pín",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "怎么能让一碟菜从",
      "pinyin": "zěn me néng ràng yī dié cài cóng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "块钱变成",
      "pinyin": "kuài qián biàn chéng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "块钱呢",
      "pinyin": "kuài qián ne",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "醉鹅娘超话",
      "pinyin": "zuì é niáng chāo huà",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "醉鹅娘品味小知识",
      "pinyin": "zuì é niáng pǐn wèi xiǎo zhī shí",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "鲜城",
      "pinyin": "xiān chéng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "元券",
      "pinyin": "yuán quàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "微博专享限时领券",
      "pinyin": "wēi bó zhuān xiǎng xiàn shí lǐng quàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "醉鹅娘的微博视频在礼盒后面有一个品鉴方法",
      "pinyin": "zuì é niáng de wēi bó shì pín zài lǐ hé hòu miàn yǒu yí gè pǐn jiàn fāng fǎ",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "微博专享限时领券用券后价",
      "pinyin": "wēi bó zhuān xiǎng xiàn shí lǐng quàn yòng quàn hòu jià",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "领券",
      "pinyin": "lǐng quàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "使用期限",
      "pinyin": "shǐ yòng qī xiàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "立即领券",
      "pinyin": "lì jí lǐng quàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "醉鹅娘了不起鹅",
      "pinyin": "zuì é niáng liǎo bù qǐ é",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "诗芮鱼子酱西伯利亚",
      "pinyin": "shī ruì yú zi jiàng xī bó lì yà",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "礼盒装包邮",
      "pinyin": "lǐ hé zhuāng bāo yóu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "笔成交现价",
      "pinyin": "bǐ chéng jiāo xiàn jià",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "用券后",
      "pinyin": "yòng quàn hòu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "更多宝贝推荐",
      "pinyin": "gèng duō bǎo bèi tuī jiàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "优惠券",
      "pinyin": "yōu huì quàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "顺风包邮",
      "pinyin": "shùn fēng bāo yóu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "领券下单立减",
      "pinyin": "lǐng quàn xià dān lì jiǎn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "元",
      "pinyin": "yuán",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "元收藏加购送开罐礼新人礼送",
      "pinyin": "yuán shōu cáng jiā gòu sòng kāi guàn lǐ xīn rén lǐ sòng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱",
      "pinyin": "xún yú ròu kǎ lù gā hēi yú zi jiàng xī bó lì yà xún yú zǐ jiàng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "笔成交用券后",
      "pinyin": "bǐ chéng jiāo yòng quàn hòu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "领取鱼子酱",
      "pinyin": "lǐng qǔ yú zi jiàng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头",
      "pinyin": "nián shēng xī bó lì yà xún yú zǐ jiàng jí shí hēi yú zi jiàng guàn tou",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "领取",
      "pinyin": "lǐng qǔ",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "惠淘价价格",
      "pinyin": "huì táo jià jià gé",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "领券后预计减",
      "pinyin": "lǐng quàn hòu yù jì jiǎn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "元满",
      "pinyin": "yuán mǎn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "减",
      "pinyin": "jiǎn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "店铺优惠券",
      "pinyin": "diàn pù yōu huì quàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "礼盒装",
      "pinyin": "lǐ hé zhuāng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "人赞过帮我选发货",
      "pinyin": "rén zàn guò bāng wǒ xuǎn fā huò",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "四川成都快递",
      "pinyin": "sì chuān chéng dū kuài dì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "免运费月销",
      "pinyin": "miǎn yùn fèi yuè xiāo",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "服务",
      "pinyin": "fú wù",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "天内发货",
      "pinyin": "tiān nèi fā huò",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "坏单包赔",
      "pinyin": "huài dān bāo péi",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "订单险生产日期厂名",
      "pinyin": "dìng dān xiǎn shēng chǎn rì qī chǎng míng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "返回",
      "pinyin": "fǎn huí",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "加入购物车领券购买用券后价",
      "pinyin": "jiā rù gòu wù chē lǐng quàn gòu mǎi yòng quàn hòu jià",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "粉丝福利购",
  "pinyin": "fěnsī fúlì gòu",
  "meaning": "Fan welfare purchase; a promotion or sale for fans.",
  "notes": "Commonly used in marketing to attract customers by offering special deals to fans.",
  "examples": [],
  "pinyinSource": "text_model_hint"
}
```

## 11. 1730196408827jp.png | auto | baidu/qianfan-ocr-fast:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `ja`
- Analyze endpoint: status=200, latency=387.98s
- Explain endpoint: status=502, latency=198.31s

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=True, attempts=2, latency=281.42s, prompt_tokens=4265, completion_tokens=29082, total_tokens=33347, t/s=103.34
- `text analysis` via `nvidia/nemotron-3-nano-30b-a3b:free`: ok=True, attempts=1, latency=64.40s, prompt_tokens=958, completion_tokens=14519, total_tokens=15477, t/s=225.47
- `glossary enrichment` via `nvidia/nemotron-3-nano-30b-a3b:free`: ok=True, attempts=1, latency=42.15s, prompt_tokens=925, completion_tokens=8666, total_tokens=9591, t/s=205.60

### Vision Output
```json
{
  "documentText": "ヘブンバーンズレッド公式 @heavenburnsred · Follow\n公式4コマ漫画【ヘブン劇場】\n第108話「のろけ」\nシャロの撮影技術はすごい！\n今までのお話はこちら→x.com/heavenburnsred...\n作画:津留崎優 @hatori_niwatoriさん\n#ヘブン #ヘブン劇場\nのろけ\nシャロ\n撮影技術\nすごい！\n今までのお話はこちら→x.com/heavenburnsred...\n作画:津留崎優 @hatori_niwatoriさん\n#ヘブン #ヘブン劇場\nのろけ\nシャロ\n撮影技術\nすごい！\nガーディアンテイルズ公式 @GuardianTalesJP · Follow\n【かんたべりーでいず！】\nガーディアンテイルズの4コマ漫画\n#かんたべりーでいずの第140話「コンビニは今日も平和です」を公開！\n今後もさまざまな英雄たちの日常をお送りしていきます。\n作者：純粋な不純物(@parang9494)先生\n#ガーディアンテイルズ #ガデテイル\nかんたべりーでいず！\nコンビニは今日も平和です\n今後もさまざまな英雄たちの日常をお送りしていきます。\n作者：純粋な不純物(@parang9494)先生\n#ガーディアンテイルズ #ガデテイル\nかんたべりーでいず！\nコンビニは今日も平和です",
  "language": "ja",
  "readingLines": [],
  "pronunciationHints": [],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [
    {
      "hanzi": "ヘブンバーンズレッド公式 @heavenburnsred · Follow",
      "translation": "Heaven Burns Red official account @heavenburnsred · Follow",
      "tokens": [
        {
          "text": "ヘブンバーンズレッド公式 @heavenburnsred · Follow",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "公式4コマ漫画【ヘブン劇場】",
      "translation": "Official 4-panel manga [Heaven Theater]",
      "tokens": [
        {
          "text": "公式4コマ漫画【ヘブン劇場】",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "第108話「のろけ」",
      "translation": "Episode 108 'Noreke'",
      "tokens": [
        {
          "text": "第108話「のろけ」",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "シャロの撮影技術はすごい！",
      "translation": "Sharo's photography technique is amazing!",
      "tokens": [
        {
          "text": "シャロの撮影技術はすごい！",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "今までのお話はこちら→x.com/heavenburnsred...",
      "translation": "All previous stories are here → x.com/heavenburnsred...",
      "tokens": [
        {
          "text": "今までのお話はこちら→x.com/heavenburnsred...",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "作画:津留崎優 @hatori_niwatoriさん",
      "translation": "Art: Yū Tsuruzaki @hatori_niwatori",
      "tokens": [
        {
          "text": "作画:津留崎優 @hatori_niwatoriさん",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "#ヘブン #ヘブン劇場",
      "translation": "#Heaven #Heaven Theater",
      "tokens": [
        {
          "text": "#ヘブン #ヘブン劇場",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "のろけ",
      "translation": "Noreke",
      "tokens": [
        {
          "text": "のろけ",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "シャロ",
      "translation": "Sharo",
      "tokens": [
        {
          "text": "シャロ",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "撮影技術",
      "translation": "Photography technique",
      "tokens": [
        {
          "text": "撮影技術",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "すごい！",
      "translation": "Amazing!",
      "tokens": [
        {
          "text": "すごい！",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "今までのお話はこちら→x.com/heavenburnsred...",
      "translation": "All previous stories are here → x.com/heavenburnsred...",
      "tokens": [
        {
          "text": "今までのお話はこちら→x.com/heavenburnsred...",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "作画:津留崎優 @hatori_niwatoriさん",
      "translation": "Art: Yū Tsuruzaki @hatori_niwatori",
      "tokens": [
        {
          "text": "作画:津留崎優 @hatori_niwatoriさん",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "#ヘブン #ヘブン劇場",
      "translation": "#Heaven #Heaven Theater",
      "tokens": [
        {
          "text": "#ヘブン #ヘブン劇場",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "のろけ",
      "translation": "Noreke",
      "tokens": [
        {
          "text": "のろけ",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "シャロ",
      "translation": "Sharo",
      "tokens": [
        {
          "text": "シャロ",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "撮影技術",
      "translation": "Photography technique",
      "tokens": [
        {
          "text": "撮影技術",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "すごい！",
      "translation": "Amazing!",
      "tokens": [
        {
          "text": "すごい！",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "ガーディアンテイルズ公式 @GuardianTalesJP · Follow",
      "translation": "Guardian Tales official account @GuardianTalesJP · Follow",
      "tokens": [
        {
          "text": "ガーディアンテイルズ公式 @GuardianTalesJP · Follow",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "【かんたべりーでいず！】",
      "translation": "[Kandaberiiz!]",
      "tokens": [
        {
          "text": "【かんたべりーでいず！】",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "ガーディアンテイルズの4コマ漫画",
      "translation": "Guardian Tales 4-panel manga",
      "tokens": [
        {
          "text": "ガーディアンテイルズの4コマ漫画",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "#かんたべりーでいずの第140話「コンビニは今日も平和です」を公開！",
      "translation": "#Kandaberiiz episode 140 'Convenience store is peaceful today' released!",
      "tokens": [
        {
          "text": "#かんたべりーでいずの第140話「コンビニは今日も平和です」を公開！",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます。",
      "translation": "We will continue to share the daily lives of various heroes.",
      "tokens": [
        {
          "text": "今後もさまざまな英雄たちの日常をお送りしていきます。",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "作者：純粋な不純物(@parang9494)先生",
      "translation": "Author: Pure Impurity (@parang9494)",
      "tokens": [
        {
          "text": "作者：純粋な不純物(@parang9494)先生",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "#ガーディアンテイルズ #ガデテイル",
      "translation": "#GuardianTales #GadeTail",
      "tokens": [
        {
          "text": "#ガーディアンテイルズ #ガデテイル",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "かんたべりーでいず！",
      "translation": "Kandaberiiz!",
      "tokens": [
        {
          "text": "かんたべりーでいず！",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "コンビニは今日も平和です",
      "translation": "The convenience store is peaceful today.",
      "tokens": [
        {
          "text": "コンビニは今日も平和です",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます。",
      "translation": "We will continue to share the daily lives of various heroes.",
      "tokens": [
        {
          "text": "今後もさまざまな英雄たちの日常をお送りしていきます。",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "作者：純粋な不純物(@parang9494)先生",
      "translation": "Author: Pure Impurity (@parang9494)",
      "tokens": [
        {
          "text": "作者：純粋な不純物(@parang9494)先生",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "#ガーディアンテイルズ #ガデテイル",
      "translation": "#GuardianTales #GadeTail",
      "tokens": [
        {
          "text": "#ガーディアンテイルズ #ガデテイル",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "かんたべりーでいず！",
      "translation": "Kandaberiiz!",
      "tokens": [
        {
          "text": "かんたべりーでいず！",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "コンビニは今日も平和です",
      "translation": "The convenience store is peaceful today.",
      "tokens": [
        {
          "text": "コンビニは今日も平和です",
          "kind": "word",
          "meaning": null
        }
      ]
    }
  ],
  "glossary": [
    {
      "text": "heaven burns red",
      "meaning": null
    },
    {
      "text": "4-panel manga",
      "meaning": null
    },
    {
      "text": "heaven theater",
      "meaning": null
    },
    {
      "text": "episode",
      "meaning": null
    },
    {
      "text": "noreke",
      "meaning": null
    },
    {
      "text": "sharo",
      "meaning": null
    },
    {
      "text": "photography technique",
      "meaning": null
    },
    {
      "text": "amazing",
      "meaning": null
    },
    {
      "text": "author",
      "meaning": null
    },
    {
      "text": "artist",
      "meaning": null
    },
    {
      "text": "hashtag",
      "meaning": null
    },
    {
      "text": "convenience store",
      "meaning": null
    },
    {
      "text": "peaceful",
      "meaning": null
    },
    {
      "text": "hero",
      "meaning": null
    },
    {
      "text": "daily life",
      "meaning": null
    },
    {
      "text": "pure impurity",
      "meaning": null
    },
    {
      "text": "guardian tales",
      "meaning": null
    },
    {
      "text": "kandaberiiz",
      "meaning": null
    },
    {
      "text": "release",
      "meaning": null
    },
    {
      "text": "daily lives of heroes",
      "meaning": null
    }
  ],
  "pronunciationHints": [
    {
      "phrase": "公式",
      "preferredPinyin": "kouji",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "漫画",
      "preferredPinyin": "manga",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "劇場",
      "preferredPinyin": "gekijou",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "話",
      "preferredPinyin": "hanashi",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "撮影技術",
      "preferredPinyin": "shooting gijutsu",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "作画",
      "preferredPinyin": "sakuga",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "英雄",
      "preferredPinyin": "eiyuu",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "日常",
      "preferredPinyin": "ninchi",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "純粋",
      "preferredPinyin": "junsui",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "不純物",
      "preferredPinyin": "fujunbutsu",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "作者",
      "preferredPinyin": "sahja",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    }
  ]
}
```

### Glossary Enrichment Output
```json
{
  "entries": [
    {
      "text": "ヘブンバーンズレッド公式",
      "literalMeaning": "official Heaven Burns Red",
      "exampleSentence": "ヘブンバーンズレッド公式です。"
    },
    {
      "text": "公式",
      "literalMeaning": "official",
      "exampleSentence": "公式です。"
    },
    {
      "text": "コマ漫画",
      "literalMeaning": "comic strip",
      "exampleSentence": "コマ漫画が好きです。"
    },
    {
      "text": "ヘブン劇場",
      "literalMeaning": "Heaven Theater",
      "exampleSentence": "ヘブン劇場で上映中です。"
    },
    {
      "text": "第",
      "literalMeaning": "chapter/episode (ordinal marker)",
      "exampleSentence": "第1話です。"
    },
    {
      "text": "話",
      "literalMeaning": "story/episode",
      "exampleSentence": "面白い話です。"
    },
    {
      "text": "のろけ",
      "literalMeaning": "gushing (about someone)",
      "exampleSentence": "のろけが止まらない。"
    },
    {
      "text": "シャロの撮影技術はすごい",
      "literalMeaning": "Sharo's photography technique is amazing",
      "exampleSentence": "シャロの撮影技術はすごいです。"
    },
    {
      "text": "今までのお話はこちら",
      "literalMeaning": "the previous stories are here",
      "exampleSentence": "今までのお話はこちらです。"
    },
    {
      "text": "作画",
      "literalMeaning": "artwork (drawing)",
      "exampleSentence": "作画が完成しました。"
    },
    {
      "text": "津留崎優",
      "literalMeaning": "Yū Tsuruzaki",
      "exampleSentence": "津留崎優さんが描いた。"
    },
    {
      "text": "さん",
      "literalMeaning": "Mr./Ms.",
      "exampleSentence": "田中さんです。"
    },
    {
      "text": "ヘブン",
      "literalMeaning": "Heaven",
      "exampleSentence": "ヘブンが好きです。"
    },
    {
      "text": "シャロ",
      "literalMeaning": "Sharo",
      "exampleSentence": "シャロは可愛い。"
    },
    {
      "text": "撮影技術",
      "literalMeaning": "photography technique",
      "exampleSentence": "撮影技術が上手です。"
    },
    {
      "text": "すごい",
      "literalMeaning": "awesome",
      "exampleSentence": "すごいですね。"
    },
    {
      "text": "ガーディアンテイルズ公式",
      "literalMeaning": "official Guardian Tales",
      "exampleSentence": "ガーディアンテイルズ公式です。"
    },
    {
      "text": "かんたべりーでいず",
      "literalMeaning": "title phrase",
      "exampleSentence": "かんたべりーでいず！"
    },
    {
      "text": "ガーディアンテイルズの",
      "literalMeaning": "Guardian Tales'",
      "exampleSentence": "ガーディアンテイルズの物語です。"
    },
    {
      "text": "かんたべりーでいずの第",
      "literalMeaning": "title phrase (chapter)",
      "exampleSentence": "かんたべりーでいずの第1話です。"
    },
    {
      "text": "コンビニは今日も平和です",
      "literalMeaning": "the store is peaceful today",
      "exampleSentence": "コンビニは今日も平和です。"
    },
    {
      "text": "を公開",
      "literalMeaning": "to publish",
      "exampleSentence": "情報を公開します。"
    },
    {
      "text": "今後もさまざまな英雄たちの日常をお送りしていきます",
      "literalMeaning": "will continue to deliver the daily lives of various heroes",
      "exampleSentence": "今後もさまざまな英雄たちの日常をお送りしていきます。"
    },
    {
      "text": "作者",
      "literalMeaning": "author",
      "exampleSentence": "作者は田中さんです。"
    },
    {
      "text": "純粋な不純物",
      "literalMeaning": "pure impurity",
      "exampleSentence": "純粋な不純物です。"
    },
    {
      "text": "先生",
      "literalMeaning": "teacher/professor",
      "exampleSentence": "先生です。"
    },
    {
      "text": "ガーディアンテイルズ",
      "literalMeaning": "Guardian Tales",
      "exampleSentence": "ガーディアンテイルズが好きです。"
    },
    {
      "text": "ガデテイル",
      "literalMeaning": "Gade Tail",
      "exampleSentence": "ガデテイルは別名です。"
    }
  ]
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "ヘブンバーンズレッド公式 @heavenburnsred · Follow\n公式4コマ漫画【ヘブン劇場】\n第108話「のろけ」\nシャロの撮影技術はすごい！\n今までのお話はこちら→x.com/heavenburnsred...\n作画:津留崎優 @hatori_niwatoriさん\n#ヘブン #ヘブン劇場\nのろけ\nシャロ\n撮影技術\nすごい！\n今までのお話はこちら→x.com/heavenburnsred...\n作画:津留崎優 @hatori_niwatoriさん\n#ヘブン #ヘブン劇場\nのろけ\nシャロ\n撮影技術\nすごい！\nガーディアンテイルズ公式 @GuardianTalesJP · Follow\n【かんたべりーでいず！】\nガーディアンテイルズの4コマ漫画\n#かんたべりーでいずの第140話「コンビニは今日も平和です」を公開！\n今後もさまざまな英雄たちの日常をお送りしていきます。\n作者：純粋な不純物(@parang9494)先生\n#ガーディアンテイルズ #ガデテイル\nかんたべりーでいず！\nコンビニは今日も平和です\n今後もさまざまな英雄たちの日常をお送りしていきます。\n作者：純粋な不純物(@parang9494)先生\n#ガーディアンテイルズ #ガデテイル\nかんたべりーでいず！\nコンビニは今日も平和です",
  "language": "ja",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "ヘブンバーンズレッド公式",
      "pinyin": "hebunbaanzureddo公式",
      "translation": "Heaven Burns Red official account @heavenburnsred · Follow",
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "ヘブンバーンズレッド公式",
          "pinyin": "hebunbaanzureddo公式",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "公式コマ漫画ヘブン劇場",
      "pinyin": "kouji koma漫画 hebun劇場",
      "translation": "Official 4-panel manga [Heaven Theater]",
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "公式",
          "pinyin": "kouji",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s2-t2",
          "hanzi": "コマ漫画",
          "pinyin": "koma漫画",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t3",
          "hanzi": "ヘブン劇場",
          "pinyin": "hebun劇場",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "第話のろけ",
      "pinyin": "第 hanashi noroke",
      "translation": "Episode 108 'Noreke'",
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "第",
          "pinyin": "第",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t2",
          "hanzi": "話",
          "pinyin": "hanashi",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s3-t3",
          "hanzi": "のろけ",
          "pinyin": "noroke",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s4",
      "hanzi": "シャロの撮影技術はすごい！",
      "pinyin": "sharono撮影技術hasugoi！",
      "translation": "Sharo's photography technique is amazing!",
      "tokens": [
        {
          "id": "s4-t1",
          "hanzi": "シャロの撮影技術はすごい",
          "pinyin": "sharono撮影技術hasugoi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s5",
      "hanzi": "今までのお話はこちら",
      "pinyin": "今madenoo話hakochira",
      "translation": "All previous stories are here → x.com/heavenburnsred...",
      "tokens": [
        {
          "id": "s5-t1",
          "hanzi": "今までのお話はこちら",
          "pinyin": "今madenoo話hakochira",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s6",
      "hanzi": "作画:津留崎優さん",
      "pinyin": "sakuga: 津留崎優 san",
      "translation": "Art: Yū Tsuruzaki @hatori_niwatori",
      "tokens": [
        {
          "id": "s6-t1",
          "hanzi": "作画",
          "pinyin": "sakuga",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s6-t2",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t3",
          "hanzi": "津留崎優",
          "pinyin": "津留崎優",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t4",
          "hanzi": "さん",
          "pinyin": "san",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s7",
      "hanzi": "ヘブンヘブン劇場",
      "pinyin": "hebun hebun劇場",
      "translation": "#Heaven #Heaven Theater",
      "tokens": [
        {
          "id": "s7-t1",
          "hanzi": "ヘブン",
          "pinyin": "hebun",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t2",
          "hanzi": "ヘブン劇場",
          "pinyin": "hebun劇場",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s8",
      "hanzi": "のろけ",
      "pinyin": "noroke",
      "translation": "Noreke",
      "tokens": [
        {
          "id": "s8-t1",
          "hanzi": "のろけ",
          "pinyin": "noroke",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s9",
      "hanzi": "シャロ",
      "pinyin": "sharo",
      "translation": "Sharo",
      "tokens": [
        {
          "id": "s9-t1",
          "hanzi": "シャロ",
          "pinyin": "sharo",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s10",
      "hanzi": "撮影技術",
      "pinyin": "shooting gijutsu",
      "translation": "Photography technique",
      "tokens": [
        {
          "id": "s10-t1",
          "hanzi": "撮影技術",
          "pinyin": "shooting gijutsu",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "text_model_hint"
        }
      ]
    },
    {
      "id": "s11",
      "hanzi": "すごい！",
      "pinyin": "sugoi！",
      "translation": "Amazing!",
      "tokens": [
        {
          "id": "s11-t1",
          "hanzi": "すごい",
          "pinyin": "sugoi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s12",
      "hanzi": "今までのお話はこちら",
      "pinyin": "今madenoo話hakochira",
      "translation": "All previous stories are here → x.com/heavenburnsred...",
      "tokens": [
        {
          "id": "s12-t1",
          "hanzi": "今までのお話はこちら",
          "pinyin": "今madenoo話hakochira",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s13",
      "hanzi": "作画:津留崎優さん",
      "pinyin": "sakuga: 津留崎優 san",
      "translation": "Art: Yū Tsuruzaki @hatori_niwatori",
      "tokens": [
        {
          "id": "s13-t1",
          "hanzi": "作画",
          "pinyin": "sakuga",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s13-t2",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t3",
          "hanzi": "津留崎優",
          "pinyin": "津留崎優",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t4",
          "hanzi": "さん",
          "pinyin": "san",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s14",
      "hanzi": "ヘブンヘブン劇場",
      "pinyin": "hebun hebun劇場",
      "translation": "#Heaven #Heaven Theater",
      "tokens": [
        {
          "id": "s14-t1",
          "hanzi": "ヘブン",
          "pinyin": "hebun",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s14-t2",
          "hanzi": "ヘブン劇場",
          "pinyin": "hebun劇場",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s15",
      "hanzi": "のろけ",
      "pinyin": "noroke",
      "translation": "Noreke",
      "tokens": [
        {
          "id": "s15-t1",
          "hanzi": "のろけ",
          "pinyin": "noroke",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s16",
      "hanzi": "シャロ",
      "pinyin": "sharo",
      "translation": "Sharo",
      "tokens": [
        {
          "id": "s16-t1",
          "hanzi": "シャロ",
          "pinyin": "sharo",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s17",
      "hanzi": "撮影技術",
      "pinyin": "shooting gijutsu",
      "translation": "Photography technique",
      "tokens": [
        {
          "id": "s17-t1",
          "hanzi": "撮影技術",
          "pinyin": "shooting gijutsu",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "text_model_hint"
        }
      ]
    },
    {
      "id": "s18",
      "hanzi": "すごい！",
      "pinyin": "sugoi！",
      "translation": "Amazing!",
      "tokens": [
        {
          "id": "s18-t1",
          "hanzi": "すごい",
          "pinyin": "sugoi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s18-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s19",
      "hanzi": "ガーディアンテイルズ公式",
      "pinyin": "gaadianteiruzu公式",
      "translation": "Guardian Tales official account @GuardianTalesJP · Follow",
      "tokens": [
        {
          "id": "s19-t1",
          "hanzi": "ガーディアンテイルズ公式",
          "pinyin": "gaadianteiruzu公式",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s20",
      "hanzi": "かんたべりーでいず！",
      "pinyin": "kantaberiideizu！",
      "translation": "[Kandaberiiz!]",
      "tokens": [
        {
          "id": "s20-t1",
          "hanzi": "かんたべりーでいず",
          "pinyin": "kantaberiideizu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s20-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s21",
      "hanzi": "ガーディアンテイルズのコマ漫画",
      "pinyin": "gaadianteiruzuno koma漫画",
      "translation": "Guardian Tales 4-panel manga",
      "tokens": [
        {
          "id": "s21-t1",
          "hanzi": "ガーディアンテイルズの",
          "pinyin": "gaadianteiruzuno",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s21-t2",
          "hanzi": "コマ漫画",
          "pinyin": "koma漫画",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s22",
      "hanzi": "かんたべりーでいずの第話コンビニは今日も平和ですを公開！",
      "pinyin": "kantaberiideizuno第 hanashi konbiniha今日mo平和desu wo公開！",
      "translation": "#Kandaberiiz episode 140 'Convenience store is peaceful today' released!",
      "tokens": [
        {
          "id": "s22-t1",
          "hanzi": "かんたべりーでいずの第",
          "pinyin": "kantaberiideizuno第",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t2",
          "hanzi": "話",
          "pinyin": "hanashi",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s22-t3",
          "hanzi": "コンビニは今日も平和です",
          "pinyin": "konbiniha今日mo平和desu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t4",
          "hanzi": "を公開",
          "pinyin": "wo公開",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s22-t5",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s23",
      "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます。",
      "pinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu。",
      "translation": "We will continue to share the daily lives of various heroes.",
      "tokens": [
        {
          "id": "s23-t1",
          "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます",
          "pinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s23-t2",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s24",
      "hanzi": "作者：純粋な不純物()先生",
      "pinyin": "sahja： 純粋na不純物() 先生",
      "translation": "Author: Pure Impurity (@parang9494)",
      "tokens": [
        {
          "id": "s24-t1",
          "hanzi": "作者",
          "pinyin": "sahja",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s24-t2",
          "hanzi": "：",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s24-t3",
          "hanzi": "純粋な不純物",
          "pinyin": "純粋na不純物",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s24-t4",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s24-t5",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s24-t6",
          "hanzi": "先生",
          "pinyin": "先生",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s25",
      "hanzi": "ガーディアンテイルズガデテイル",
      "pinyin": "gaadianteiruzu gadeteiru",
      "translation": "#GuardianTales #GadeTail",
      "tokens": [
        {
          "id": "s25-t1",
          "hanzi": "ガーディアンテイルズ",
          "pinyin": "gaadianteiruzu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s25-t2",
          "hanzi": "ガデテイル",
          "pinyin": "gadeteiru",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s26",
      "hanzi": "かんたべりーでいず！",
      "pinyin": "kantaberiideizu！",
      "translation": "Kandaberiiz!",
      "tokens": [
        {
          "id": "s26-t1",
          "hanzi": "かんたべりーでいず",
          "pinyin": "kantaberiideizu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s26-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s27",
      "hanzi": "コンビニは今日も平和です",
      "pinyin": "konbiniha今日mo平和desu",
      "translation": "The convenience store is peaceful today.",
      "tokens": [
        {
          "id": "s27-t1",
          "hanzi": "コンビニは今日も平和です",
          "pinyin": "konbiniha今日mo平和desu",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s28",
      "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます。",
      "pinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu。",
      "translation": "We will continue to share the daily lives of various heroes.",
      "tokens": [
        {
          "id": "s28-t1",
          "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます",
          "pinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s28-t2",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s29",
      "hanzi": "作者：純粋な不純物()先生",
      "pinyin": "sahja： 純粋na不純物() 先生",
      "translation": "Author: Pure Impurity (@parang9494)",
      "tokens": [
        {
          "id": "s29-t1",
          "hanzi": "作者",
          "pinyin": "sahja",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s29-t2",
          "hanzi": "：",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s29-t3",
          "hanzi": "純粋な不純物",
          "pinyin": "純粋na不純物",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s29-t4",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s29-t5",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s29-t6",
          "hanzi": "先生",
          "pinyin": "先生",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s30",
      "hanzi": "ガーディアンテイルズガデテイル",
      "pinyin": "gaadianteiruzu gadeteiru",
      "translation": "#GuardianTales #GadeTail",
      "tokens": [
        {
          "id": "s30-t1",
          "hanzi": "ガーディアンテイルズ",
          "pinyin": "gaadianteiruzu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s30-t2",
          "hanzi": "ガデテイル",
          "pinyin": "gadeteiru",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s31",
      "hanzi": "かんたべりーでいず！",
      "pinyin": "kantaberiideizu！",
      "translation": "Kandaberiiz!",
      "tokens": [
        {
          "id": "s31-t1",
          "hanzi": "かんたべりーでいず",
          "pinyin": "kantaberiideizu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s31-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s32",
      "hanzi": "コンビニは今日も平和です",
      "pinyin": "konbiniha今日mo平和desu",
      "translation": "The convenience store is peaceful today.",
      "tokens": [
        {
          "id": "s32-t1",
          "hanzi": "コンビニは今日も平和です",
          "pinyin": "konbiniha今日mo平和desu",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "ヘブンバーンズレッド公式",
      "pinyin": "hebunbaanzureddo公式",
      "meaning": "official Heaven Burns Red",
      "exampleSentence": "ヘブンバーンズレッド公式です。",
      "exampleSentencePinyin": "hebunbaanzureddo公式 desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "公式",
      "pinyin": "kouji",
      "meaning": "official",
      "exampleSentence": "公式です。",
      "exampleSentencePinyin": "kouji desu。",
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "コマ漫画",
      "pinyin": "koma漫画",
      "meaning": "comic strip",
      "exampleSentence": "コマ漫画が好きです。",
      "exampleSentencePinyin": "koma漫画 ga好kidesu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ヘブン劇場",
      "pinyin": "hebun劇場",
      "meaning": "Heaven Theater",
      "exampleSentence": "ヘブン劇場で上映中です。",
      "exampleSentencePinyin": "hebun劇場 de上映中desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "第",
      "pinyin": "第",
      "meaning": "chapter/episode (ordinal marker)",
      "exampleSentence": "第1話です。",
      "exampleSentencePinyin": "第 1話desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "話",
      "pinyin": "hanashi",
      "meaning": "story/episode",
      "exampleSentence": "面白い話です。",
      "exampleSentencePinyin": "面白i hanashi desu。",
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "のろけ",
      "pinyin": "noroke",
      "meaning": "gushing (about someone)",
      "exampleSentence": "のろけが止まらない。",
      "exampleSentencePinyin": "noroke ga止maranai。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "シャロの撮影技術はすごい",
      "pinyin": "sharono撮影技術hasugoi",
      "meaning": "Sharo's photography technique is amazing",
      "exampleSentence": "シャロの撮影技術はすごいです。",
      "exampleSentencePinyin": "sharono撮影技術hasugoi desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "今までのお話はこちら",
      "pinyin": "今madenoo話hakochira",
      "meaning": "the previous stories are here",
      "exampleSentence": "今までのお話はこちらです。",
      "exampleSentencePinyin": "今madenoo話hakochira desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "作画",
      "pinyin": "sakuga",
      "meaning": "artwork (drawing)",
      "exampleSentence": "作画が完成しました。",
      "exampleSentencePinyin": "sakuga ga完成shimashita。",
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "津留崎優",
      "pinyin": "津留崎優",
      "meaning": "Yū Tsuruzaki",
      "exampleSentence": "津留崎優さんが描いた。",
      "exampleSentencePinyin": "津留崎優 sanga描ita。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "さん",
      "pinyin": "san",
      "meaning": "Mr./Ms.",
      "exampleSentence": "田中さんです。",
      "exampleSentencePinyin": "田中 san desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ヘブン",
      "pinyin": "hebun",
      "meaning": "Heaven",
      "exampleSentence": "ヘブンが好きです。",
      "exampleSentencePinyin": "hebun ga好kidesu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "シャロ",
      "pinyin": "sharo",
      "meaning": "Sharo",
      "exampleSentence": "シャロは可愛い。",
      "exampleSentencePinyin": "sharo ha可愛i。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "撮影技術",
      "pinyin": "shooting gijutsu",
      "meaning": "photography technique",
      "exampleSentence": "撮影技術が上手です。",
      "exampleSentencePinyin": "shooting gijutsu ga上手desu。",
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "すごい",
      "pinyin": "sugoi",
      "meaning": "awesome",
      "exampleSentence": "すごいですね。",
      "exampleSentencePinyin": "sugoi desune。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーディアンテイルズ公式",
      "pinyin": "gaadianteiruzu公式",
      "meaning": "official Guardian Tales",
      "exampleSentence": "ガーディアンテイルズ公式です。",
      "exampleSentencePinyin": "gaadianteiruzu公式 desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "かんたべりーでいず",
      "pinyin": "kantaberiideizu",
      "meaning": "title phrase",
      "exampleSentence": "かんたべりーでいず！",
      "exampleSentencePinyin": "kantaberiideizu！",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーディアンテイルズの",
      "pinyin": "gaadianteiruzuno",
      "meaning": "Guardian Tales'",
      "exampleSentence": "ガーディアンテイルズの物語です。",
      "exampleSentencePinyin": "gaadianteiruzuno 物語desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "かんたべりーでいずの第",
      "pinyin": "kantaberiideizuno第",
      "meaning": "title phrase (chapter)",
      "exampleSentence": "かんたべりーでいずの第1話です。",
      "exampleSentencePinyin": "kantaberiideizuno第 1話desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "コンビニは今日も平和です",
      "pinyin": "konbiniha今日mo平和desu",
      "meaning": "the store is peaceful today",
      "exampleSentence": "コンビニは今日も平和です。",
      "exampleSentencePinyin": "konbiniha今日mo平和desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "を公開",
      "pinyin": "wo公開",
      "meaning": "to publish",
      "exampleSentence": "情報を公開します。",
      "exampleSentencePinyin": "情報 wo公開 shimasu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます",
      "pinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu",
      "meaning": "will continue to deliver the daily lives of various heroes",
      "exampleSentence": "今後もさまざまな英雄たちの日常をお送りしていきます。",
      "exampleSentencePinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "作者",
      "pinyin": "sahja",
      "meaning": "author",
      "exampleSentence": "作者は田中さんです。",
      "exampleSentencePinyin": "sahja ha田中sandesu。",
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "純粋な不純物",
      "pinyin": "純粋na不純物",
      "meaning": "pure impurity",
      "exampleSentence": "純粋な不純物です。",
      "exampleSentencePinyin": "純粋na不純物 desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "先生",
      "pinyin": "先生",
      "meaning": "teacher/professor",
      "exampleSentence": "先生です。",
      "exampleSentencePinyin": "先生 desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーディアンテイルズ",
      "pinyin": "gaadianteiruzu",
      "meaning": "Guardian Tales",
      "exampleSentence": "ガーディアンテイルズが好きです。",
      "exampleSentencePinyin": "gaadianteiruzu ga好kidesu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガデテイル",
      "pinyin": "gadeteiru",
      "meaning": "Gade Tail",
      "exampleSentence": "ガデテイルは別名です。",
      "exampleSentencePinyin": "gadeteiru ha別名desu。",
      "pinyinSource": "library"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "detail": "Selection explanation service is currently unavailable."
}
```

## 12. 1730196408827jp.png | ja | baidu/qianfan-ocr-fast:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `ja`
- Analyze endpoint: status=200, latency=317.76s
- Explain endpoint: status=200, latency=8.60s

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=True, attempts=1, latency=6.50s, prompt_tokens=2079, completion_tokens=310, total_tokens=2389, t/s=47.68
- `text analysis` via `nvidia/nemotron-3-nano-30b-a3b:free`: ok=True, attempts=1, latency=282.56s, prompt_tokens=846, completion_tokens=65536, total_tokens=66382, t/s=231.94
- `glossary enrichment` via `nvidia/nemotron-3-nano-30b-a3b:free`: ok=True, attempts=1, latency=28.69s, prompt_tokens=799, completion_tokens=6495, total_tokens=7294, t/s=226.38

### Vision Output
```json
{
  "documentText": "ヘブンバーンズレッド公式 @heavenburnsred · Follow\n公式4コマ漫画【ヘブン劇場】\n第108話「のろけ」\nシャロの撮影技術はすごい！\n今までのお話はこちら→x.com/heavenburnsred...\n作画:津留崎優 @hatori_niwatoriさん\n#ヘブン #ヘブン劇場\n\nガーディアンテイルズ公式 @GuardianTalesJP · Follow\n【かんたべりーでいず！】\nガーディアンテイルズの4コマ漫画\n#かんたべりーでいずの第140話「コンビニは今日も平和です」を公開！\n今後もさまざまな英雄たちの日常をお送りしていきます。\n作者：純粋な不純物(@parang9494)先生\n#ガーディアンテイルズ #ガデテイル\n\n1:00 PM · Sep 15, 2024\n4.1K\nReply\nCopy link\nRead 29 replies\n\n5:00 PM · Sep 6, 2024\n1K\nReply\nCopy link\nRead 5 replies",
  "language": "ja",
  "readingLines": [],
  "pronunciationHints": [],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [],
  "glossary": [],
  "pronunciationHints": []
}
```

### Glossary Enrichment Output
```json
{
  "entries": [
    {
      "text": "ヘブンバーンズレッド公式",
      "literalMeaning": "official Heaven Burns Red",
      "exampleSentence": "ヘブンバーンズレッド公式が新作を発表した。"
    },
    {
      "text": "公式",
      "literalMeaning": "official",
      "exampleSentence": "公式サイトが更新された。"
    },
    {
      "text": "コマ漫画",
      "literalMeaning": "panel comic",
      "exampleSentence": "コマ漫画を読んだ。"
    },
    {
      "text": "ヘブン劇場",
      "literalMeaning": "Heaven Theater",
      "exampleSentence": "ヘブン劇場の映像が公開された。"
    },
    {
      "text": "第",
      "literalMeaning": "the (ordinal prefix)",
      "exampleSentence": "第1話を読んだ。"
    },
    {
      "text": "話",
      "literalMeaning": "story",
      "exampleSentence": "面白い話だ。"
    },
    {
      "text": "のろけ",
      "literalMeaning": "flattery",
      "exampleSentence": "のろけが多い。"
    },
    {
      "text": "シャロの撮影技術はすごい",
      "literalMeaning": "Sharo's photography technique is amazing",
      "exampleSentence": "シャロの撮影技術はすごいと評判だ。"
    },
    {
      "text": "今までのお話はこちら",
      "literalMeaning": "the previous stories are here",
      "exampleSentence": "今までのお話はこちらです。"
    },
    {
      "text": "作画",
      "literalMeaning": "illustration",
      "exampleSentence": "作画が綺麗だ。"
    },
    {
      "text": "津留崎優",
      "literalMeaning": "Yū Tsuruzaki",
      "exampleSentence": "津留崎優が作画を担当した。"
    },
    {
      "text": "さん",
      "literalMeaning": "Mr./Ms.",
      "exampleSentence": "津留崎優さんは人気がある。"
    },
    {
      "text": "ヘブン",
      "literalMeaning": "Heaven",
      "exampleSentence": "ヘブンは人気がある。"
    },
    {
      "text": "ガーディアンテイルズ公式",
      "literalMeaning": "official Guardian Tales",
      "exampleSentence": "ガーディアンテイルズ公式が発表した。"
    },
    {
      "text": "かんたべりーでいず",
      "literalMeaning": "canteburydeiz",
      "exampleSentence": "かんたべりーでいずが好きだ。"
    },
    {
      "text": "ガーディアンテイルズの",
      "literalMeaning": "of Guardian Tales",
      "exampleSentence": "ガーディアンテイルズの漫画が人気だ。"
    },
    {
      "text": "かんたべりーでいずの第",
      "literalMeaning": "of canteburydeiz's chapter",
      "exampleSentence": "かんたべりーでいずの第140話が公開された。"
    },
    {
      "text": "コンビニは今日も平和です",
      "literalMeaning": "The convenience store is peaceful today too",
      "exampleSentence": "コンビニは今日も平和です。"
    },
    {
      "text": "を公開",
      "literalMeaning": "to release",
      "exampleSentence": "新作をを公開した。"
    },
    {
      "text": "今後もさまざまな英雄たちの日常をお送りしていきます",
      "literalMeaning": "We will continue to deliver various heroes' daily lives",
      "exampleSentence": "今後もさまざまな英雄たちの日常をお送りしていきます。"
    },
    {
      "text": "作者",
      "literalMeaning": "author",
      "exampleSentence": "作者は純粋な不純物です。"
    },
    {
      "text": "純粋な不純物",
      "literalMeaning": "pure impurity",
      "exampleSentence": "純粋な不純物が描かれる。"
    },
    {
      "text": "先生",
      "literalMeaning": "teacher",
      "exampleSentence": "作者は先生です。"
    },
    {
      "text": "ガーディアンテイルズ",
      "literalMeaning": "Guardian Tales",
      "exampleSentence": "ガーディアンテイルズが人気だ。"
    },
    {
      "text": "ガデテイル",
      "literalMeaning": "Gadetail",
      "exampleSentence": "ガデテイルは別名だ。"
    }
  ]
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "ヘブンバーンズレッド公式 @heavenburnsred · Follow\n公式4コマ漫画【ヘブン劇場】\n第108話「のろけ」\nシャロの撮影技術はすごい！\n今までのお話はこちら→x.com/heavenburnsred...\n作画:津留崎優 @hatori_niwatoriさん\n#ヘブン #ヘブン劇場\n\nガーディアンテイルズ公式 @GuardianTalesJP · Follow\n【かんたべりーでいず！】\nガーディアンテイルズの4コマ漫画\n#かんたべりーでいずの第140話「コンビニは今日も平和です」を公開！\n今後もさまざまな英雄たちの日常をお送りしていきます。\n作者：純粋な不純物(@parang9494)先生\n#ガーディアンテイルズ #ガデテイル\n\n1:00 PM · Sep 15, 2024\n4.1K\nReply\nCopy link\nRead 29 replies\n\n5:00 PM · Sep 6, 2024\n1K\nReply\nCopy link\nRead 5 replies",
  "language": "ja",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "ヘブンバーンズレッド公式",
      "pinyin": "hebunbaanzureddo公式",
      "translation": null,
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "ヘブンバーンズレッド公式",
          "pinyin": "hebunbaanzureddo公式",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "公式コマ漫画ヘブン劇場",
      "pinyin": "公式 koma漫画 hebun劇場",
      "translation": null,
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "公式",
          "pinyin": "公式",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t2",
          "hanzi": "コマ漫画",
          "pinyin": "koma漫画",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t3",
          "hanzi": "ヘブン劇場",
          "pinyin": "hebun劇場",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "第話のろけ",
      "pinyin": "第 話 noroke",
      "translation": null,
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "第",
          "pinyin": "第",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t2",
          "hanzi": "話",
          "pinyin": "話",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t3",
          "hanzi": "のろけ",
          "pinyin": "noroke",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s4",
      "hanzi": "シャロの撮影技術はすごい！",
      "pinyin": "sharono撮影技術hasugoi！",
      "translation": null,
      "tokens": [
        {
          "id": "s4-t1",
          "hanzi": "シャロの撮影技術はすごい",
          "pinyin": "sharono撮影技術hasugoi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s5",
      "hanzi": "今までのお話はこちら",
      "pinyin": "今madenoo話hakochira",
      "translation": null,
      "tokens": [
        {
          "id": "s5-t1",
          "hanzi": "今までのお話はこちら",
          "pinyin": "今madenoo話hakochira",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s6",
      "hanzi": "作画:津留崎優さん",
      "pinyin": "作画: 津留崎優 san",
      "translation": null,
      "tokens": [
        {
          "id": "s6-t1",
          "hanzi": "作画",
          "pinyin": "作画",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t2",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t3",
          "hanzi": "津留崎優",
          "pinyin": "津留崎優",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t4",
          "hanzi": "さん",
          "pinyin": "san",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s7",
      "hanzi": "ヘブンヘブン劇場",
      "pinyin": "hebun hebun劇場",
      "translation": null,
      "tokens": [
        {
          "id": "s7-t1",
          "hanzi": "ヘブン",
          "pinyin": "hebun",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t2",
          "hanzi": "ヘブン劇場",
          "pinyin": "hebun劇場",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s8",
      "hanzi": "ガーディアンテイルズ公式",
      "pinyin": "gaadianteiruzu公式",
      "translation": null,
      "tokens": [
        {
          "id": "s8-t1",
          "hanzi": "ガーディアンテイルズ公式",
          "pinyin": "gaadianteiruzu公式",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s9",
      "hanzi": "かんたべりーでいず！",
      "pinyin": "kantaberiideizu！",
      "translation": null,
      "tokens": [
        {
          "id": "s9-t1",
          "hanzi": "かんたべりーでいず",
          "pinyin": "kantaberiideizu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s10",
      "hanzi": "ガーディアンテイルズのコマ漫画",
      "pinyin": "gaadianteiruzuno koma漫画",
      "translation": null,
      "tokens": [
        {
          "id": "s10-t1",
          "hanzi": "ガーディアンテイルズの",
          "pinyin": "gaadianteiruzuno",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t2",
          "hanzi": "コマ漫画",
          "pinyin": "koma漫画",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s11",
      "hanzi": "かんたべりーでいずの第話コンビニは今日も平和ですを公開！",
      "pinyin": "kantaberiideizuno第 話 konbiniha今日mo平和desu wo公開！",
      "translation": null,
      "tokens": [
        {
          "id": "s11-t1",
          "hanzi": "かんたべりーでいずの第",
          "pinyin": "kantaberiideizuno第",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t2",
          "hanzi": "話",
          "pinyin": "話",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t3",
          "hanzi": "コンビニは今日も平和です",
          "pinyin": "konbiniha今日mo平和desu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t4",
          "hanzi": "を公開",
          "pinyin": "wo公開",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t5",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s12",
      "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます。",
      "pinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu。",
      "translation": null,
      "tokens": [
        {
          "id": "s12-t1",
          "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます",
          "pinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s12-t2",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s13",
      "hanzi": "作者：純粋な不純物()先生",
      "pinyin": "作者： 純粋na不純物() 先生",
      "translation": null,
      "tokens": [
        {
          "id": "s13-t1",
          "hanzi": "作者",
          "pinyin": "作者",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t2",
          "hanzi": "：",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t3",
          "hanzi": "純粋な不純物",
          "pinyin": "純粋na不純物",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t4",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t5",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t6",
          "hanzi": "先生",
          "pinyin": "先生",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s14",
      "hanzi": "ガーディアンテイルズガデテイル",
      "pinyin": "gaadianteiruzu gadeteiru",
      "translation": null,
      "tokens": [
        {
          "id": "s14-t1",
          "hanzi": "ガーディアンテイルズ",
          "pinyin": "gaadianteiruzu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s14-t2",
          "hanzi": "ガデテイル",
          "pinyin": "gadeteiru",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "ヘブンバーンズレッド公式",
      "pinyin": "hebunbaanzureddo公式",
      "meaning": "official Heaven Burns Red",
      "exampleSentence": "ヘブンバーンズレッド公式が新作を発表した。",
      "exampleSentencePinyin": "hebunbaanzureddo公式 ga新作wo発表shita。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "公式",
      "pinyin": "公式",
      "meaning": "official",
      "exampleSentence": "公式サイトが更新された。",
      "exampleSentencePinyin": "公式 saitoga更新sareta。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "コマ漫画",
      "pinyin": "koma漫画",
      "meaning": "panel comic",
      "exampleSentence": "コマ漫画を読んだ。",
      "exampleSentencePinyin": "koma漫画 wo読nda。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ヘブン劇場",
      "pinyin": "hebun劇場",
      "meaning": "Heaven Theater",
      "exampleSentence": "ヘブン劇場の映像が公開された。",
      "exampleSentencePinyin": "hebun劇場 no映像ga公開sareta。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "第",
      "pinyin": "第",
      "meaning": "the (ordinal prefix)",
      "exampleSentence": "第1話を読んだ。",
      "exampleSentencePinyin": "第 1話wo読nda。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "話",
      "pinyin": "話",
      "meaning": "story",
      "exampleSentence": "面白い話だ。",
      "exampleSentencePinyin": "面白i 話 da。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "のろけ",
      "pinyin": "noroke",
      "meaning": "flattery",
      "exampleSentence": "のろけが多い。",
      "exampleSentencePinyin": "noroke ga多i。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "シャロの撮影技術はすごい",
      "pinyin": "sharono撮影技術hasugoi",
      "meaning": "Sharo's photography technique is amazing",
      "exampleSentence": "シャロの撮影技術はすごいと評判だ。",
      "exampleSentencePinyin": "sharono撮影技術hasugoi to評判da。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "今までのお話はこちら",
      "pinyin": "今madenoo話hakochira",
      "meaning": "the previous stories are here",
      "exampleSentence": "今までのお話はこちらです。",
      "exampleSentencePinyin": "今madenoo話hakochira desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "作画",
      "pinyin": "作画",
      "meaning": "illustration",
      "exampleSentence": "作画が綺麗だ。",
      "exampleSentencePinyin": "作画 ga綺麗da。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "津留崎優",
      "pinyin": "津留崎優",
      "meaning": "Yū Tsuruzaki",
      "exampleSentence": "津留崎優が作画を担当した。",
      "exampleSentencePinyin": "津留崎優 ga作画wo担当shita。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "さん",
      "pinyin": "san",
      "meaning": "Mr./Ms.",
      "exampleSentence": "津留崎優さんは人気がある。",
      "exampleSentencePinyin": "津留崎優 san ha人気gaaru。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ヘブン",
      "pinyin": "hebun",
      "meaning": "Heaven",
      "exampleSentence": "ヘブンは人気がある。",
      "exampleSentencePinyin": "hebun ha人気gaaru。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーディアンテイルズ公式",
      "pinyin": "gaadianteiruzu公式",
      "meaning": "official Guardian Tales",
      "exampleSentence": "ガーディアンテイルズ公式が発表した。",
      "exampleSentencePinyin": "gaadianteiruzu公式 ga発表shita。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "かんたべりーでいず",
      "pinyin": "kantaberiideizu",
      "meaning": "canteburydeiz",
      "exampleSentence": "かんたべりーでいずが好きだ。",
      "exampleSentencePinyin": "kantaberiideizu ga好kida。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーディアンテイルズの",
      "pinyin": "gaadianteiruzuno",
      "meaning": "of Guardian Tales",
      "exampleSentence": "ガーディアンテイルズの漫画が人気だ。",
      "exampleSentencePinyin": "gaadianteiruzuno 漫画ga人気da。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "かんたべりーでいずの第",
      "pinyin": "kantaberiideizuno第",
      "meaning": "of canteburydeiz's chapter",
      "exampleSentence": "かんたべりーでいずの第140話が公開された。",
      "exampleSentencePinyin": "kantaberiideizuno第 1 4 0話ga公開sareta。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "コンビニは今日も平和です",
      "pinyin": "konbiniha今日mo平和desu",
      "meaning": "The convenience store is peaceful today too",
      "exampleSentence": "コンビニは今日も平和です。",
      "exampleSentencePinyin": "konbiniha今日mo平和desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "を公開",
      "pinyin": "wo公開",
      "meaning": "to release",
      "exampleSentence": "新作をを公開した。",
      "exampleSentencePinyin": "新作wo wo公開 shita。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます",
      "pinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu",
      "meaning": "We will continue to deliver various heroes' daily lives",
      "exampleSentence": "今後もさまざまな英雄たちの日常をお送りしていきます。",
      "exampleSentencePinyin": "今後mosamazamana英雄tachino日常woo送rishiteikimasu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "作者",
      "pinyin": "作者",
      "meaning": "author",
      "exampleSentence": "作者は純粋な不純物です。",
      "exampleSentencePinyin": "作者 ha純粋na不純物desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "純粋な不純物",
      "pinyin": "純粋na不純物",
      "meaning": "pure impurity",
      "exampleSentence": "純粋な不純物が描かれる。",
      "exampleSentencePinyin": "純粋na不純物 ga描kareru。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "先生",
      "pinyin": "先生",
      "meaning": "teacher",
      "exampleSentence": "作者は先生です。",
      "exampleSentencePinyin": "作者ha 先生 desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーディアンテイルズ",
      "pinyin": "gaadianteiruzu",
      "meaning": "Guardian Tales",
      "exampleSentence": "ガーディアンテイルズが人気だ。",
      "exampleSentencePinyin": "gaadianteiruzu ga人気da。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガデテイル",
      "pinyin": "gadeteiru",
      "meaning": "Gadetail",
      "exampleSentence": "ガデテイルは別名だ。",
      "exampleSentencePinyin": "gadeteiru ha別名da。",
      "pinyinSource": "library"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "ヘブンバーンズレッド公式",
  "pinyin": "hebunbaanzureddo公式",
  "meaning": "official(of the game 'Heaven Burns Red')",
  "notes": "Refers to the official website, account, or materials of the game 'Heaven Burns Red'.",
  "examples": [
    "ヘブンバーンズレッド公式のTwitterアカウントが更新された。",
    "公式サイトによると、新イベントが近日公開予定です。",
    "ヘブンバーンズレッド公式のグッズが販売中です。"
  ],
  "pinyinSource": "library"
}
```

## 13. o08000924109524428441jp.jpg | auto | baidu/qianfan-ocr-fast:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `ja`
- Analyze endpoint: status=502, latency=563.82s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=False, attempts=3, latency=563.82s, prompt_tokens=8361, completion_tokens=42538, total_tokens=50899, t/s=75.45
  error: Could not reach OpenRouter.

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 14. o08000924109524428441jp.jpg | ja | baidu/qianfan-ocr-fast:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `ja`
- Analyze endpoint: status=502, latency=0.69s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=False, attempts=1, latency=0.69s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Rate limit exceeded: free-models-per-min. ","code":429,"metadata":{"headers":{"X-RateLimit-Limit":"20","X-RateLimit-Remaining":"0","X-RateLimit-Reset":"1777080300000"},"provider_name":null}},"user_id":"user_33l3f2lCVirQHMjQT2ZEc5ZZQPg"}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 15. The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | auto | baidu/qianfan-ocr-fast:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=0.76s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=False, attempts=1, latency=0.76s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Rate limit exceeded: free-models-per-min. ","code":429,"metadata":{"headers":{"X-RateLimit-Limit":"20","X-RateLimit-Remaining":"0","X-RateLimit-Reset":"1777080300000"},"provider_name":null}},"user_id":"user_33l3f2lCVirQHMjQT2ZEc5ZZQPg"}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 16. The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | baidu/qianfan-ocr-fast:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=0.62s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=False, attempts=1, latency=0.61s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Rate limit exceeded: free-models-per-min. ","code":429,"metadata":{"headers":{"X-RateLimit-Limit":"20","X-RateLimit-Remaining":"0","X-RateLimit-Reset":"1777080300000"},"provider_name":null}},"user_id":"user_33l3f2lCVirQHMjQT2ZEc5ZZQPg"}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 17. weibo_6_toutiao_comparison.jpg | auto | baidu/qianfan-ocr-fast:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=1.82s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=False, attempts=1, latency=1.82s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Rate limit exceeded: free-models-per-min. ","code":429,"metadata":{"headers":{"X-RateLimit-Limit":"20","X-RateLimit-Remaining":"0","X-RateLimit-Reset":"1777080300000"},"provider_name":null}},"user_id":"user_33l3f2lCVirQHMjQT2ZEc5ZZQPg"}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 18. weibo_6_toutiao_comparison.jpg | zh | baidu/qianfan-ocr-fast:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=200, latency=429.05s
- Explain endpoint: status=200, latency=7.21s

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=True, attempts=1, latency=13.26s, prompt_tokens=3359, completion_tokens=1245, total_tokens=4604, t/s=93.92
- `text analysis` via `nvidia/nemotron-3-nano-30b-a3b:free`: ok=True, attempts=1, latency=99.74s, prompt_tokens=2491, completion_tokens=24680, total_tokens=27171, t/s=247.45
- `glossary enrichment` via `nvidia/nemotron-3-nano-30b-a3b:free`: ok=True, attempts=1, latency=316.05s, prompt_tokens=951, completion_tokens=65536, total_tokens=66487, t/s=207.36

### Vision Output
```json
{
  "documentText": "头条\nToutiao\n10:544G\n微头条发布\n热榜\n#怀念单田芳# #台风山竹# #被讹小伙要起... #朱旭去世# 韩路出品前天19:37·知名车评人老司机App联... 我们现在3200米海拔的四川轿顶山，大雾，本来想着气爽来看贡嘎雪山，如今成了0度99%湿度还没电的湿湿哒之旅😂😂😂 Mavic2近地起降场补光，像不像UFO抓地球人时候那感觉😂😂😂\n头条\nToutiao\n10:554G\nSearch\nFollowing hot\n斯道5 min ago Edited 章子怡徐峥争论引发热议，每个导师侧重点不一样，理性讨论挺好。网友表示章子怡老师你能不能让徐峥大叔把话说完，老是打断人家这样很不好徐璐阚清子的表演你喜欢吗～\n央视新闻38 min ago from 微博 weibo.com Edited\nWeibo\nMessage Discover Me",
  "language": "zh-Hans",
  "readingLines": [
    "头条\nToutiao\n10:544G\n微头条发布\n热榜\n#怀念单田芳# #台风山竹# #被讹小伙要起... #朱旭去世# 韩路出品前天19:37·知名车评人老司机App联... 我们现在3200米海拔的四川轿顶山，大雾，本来想着气爽来看贡嘎雪山，如今成了0度99%湿度还没电的湿湿哒之旅😂😂😂 Mavic2近地起降场补光，像不像UFO抓地球人时候那感觉😂😂😂",
    "头条\nToutiao\n10:554G\nSearch\nFollowing hot\n斯道5 min ago Edited 章子怡徐峥争论引发热议，每个导师侧重点不一样，理性讨论挺好。网友表示章子怡老师你能不能让徐峥大叔把话说完，老是打断人家这样很不好徐璐阚清子的表演你喜欢吗～\n央视新闻38 min ago from 微博 weibo.com Edited\nWeibo\nMessage Discover Me"
  ],
  "pronunciationHints": [
    {
      "phrase": "头条",
      "preferredPinyin": "tóu tiáo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Toutiao",
      "preferredPinyin": "tuóu táo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "微头条",
      "preferredPinyin": "wēi tóu tiáo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "发布",
      "preferredPinyin": "fā bù",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "热榜",
      "preferredPinyin": "rè bǎng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "怀念单田芳",
      "preferredPinyin": "huái niàn dān tián fāng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "台风山竹",
      "preferredPinyin": "tái fēng shān zhú",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "被讹小伙要起",
      "preferredPinyin": "bèi é hǎo hǎo yào qǐ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "朱旭去世",
      "preferredPinyin": "zhū xù qū sǐ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "韩路出品",
      "preferredPinyin": "hán lù chū pǐn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "知名车评人",
      "preferredPinyin": "zhī míng chē píng rén",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "老司机App联",
      "preferredPinyin": "lǎo jī xíng app lián",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "四川轿顶山",
      "preferredPinyin": "sì chuān jiào dǐng shān",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "贡嘎雪山",
      "preferredPinyin": "gòng gǎ xuě shān",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "湿湿哒之旅",
      "preferredPinyin": "shī shī dā zhī lǚ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Mavic2近地起降场补光",
      "preferredPinyin": "má vī 2 jìn dì qǐ jiàng chǎng bǔ guāng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "UFO抓地球人",
      "preferredPinyin": "u fó zhuā dì qiú rén",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "斯道",
      "preferredPinyin": "sī dào",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "章子怡徐峥争论",
      "preferredPinyin": "zhāng zǐ yí xú zhēng zhēng lùn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "理性讨论挺好",
      "preferredPinyin": "lǐ xìng tǎo lùn hěn hǎo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "徐璐阚清子的表演",
      "preferredPinyin": "xú lù kàn qīng zǐ de biǎo yǎn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "央视新闻",
      "preferredPinyin": "cì yì xīn wén",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "微博",
      "preferredPinyin": "wēi bo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "weibo.com",
      "preferredPinyin": "wēi bo . com",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Message",
      "preferredPinyin": "mèi xìn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Discover",
      "preferredPinyin": "fā xiàn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Me",
      "preferredPinyin": "wǒ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    }
  ],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [
    {
      "hanzi": "头条",
      "translation": "Top headline",
      "tokens": [
        {
          "text": "头条",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Toutiao",
      "translation": "Top headline",
      "tokens": [
        {
          "text": "Toutiao",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "10:544G",
      "translation": "10:544G",
      "tokens": [
        {
          "text": "10:544G",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "微头条发布",
      "translation": "Micro-headline published",
      "tokens": [
        {
          "text": "微头条",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "发布",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "热榜",
      "translation": "Trending list",
      "tokens": [
        {
          "text": "热榜",
          "kind": "phrase",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "#怀念单田芳# #台风山竹# #被讹小伙要起...",
      "translation": "Hashtags: nostalgic Dan Tian Fang, typhoon bamboo, misreported guy wants to rise",
      "tokens": [
        {
          "text": "#怀念单田芳#",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "#台风山竹#",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "#被讹小伙要起...",
          "kind": "phrase",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "韩路出品前天19:37·知名车评人老司机App联...",
      "translation": "Han Lu production, two days ago at 19:37, featuring a known car reviewer and old driver app link",
      "tokens": [
        {
          "text": "韩路出品",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "前天19:37·知名车评人",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "老司机App联",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "...",
          "kind": "punctuation",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "我们现在3200米海拔的四川轿顶山，大雾，本来想着气爽来看贡嘎雪山，如今成了0度99%湿度还没电的湿湿哒之旅😂😂😂",
      "translation": "At 3,200m on Sichuan's Jiao Ding Mountain, foggy, now 0°C, 99% humidity, out of power, damp trip 😂",
      "tokens": [
        {
          "text": "我们现在3200米海拔的四川轿顶山",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "，",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "大雾",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "，",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "本来想着气爽来看贡嘎雪山",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "，",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "如今成了0度99%湿度还没电的湿湿哒之旅",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "😂😂😂",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Mavic2近地起降场补光，像不像UFO抓地球人时候那感觉😂😂😂",
      "translation": "Mavic 2 low‑altitude takeoff and landing site lighting, looks like a UFO catching humans, that feeling 😂😂😂",
      "tokens": [
        {
          "text": "Mavic2近地起降场补光",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "，",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "像不像UFO抓地球人时候那感觉",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "😂😂😂",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "斯道5 min ago Edited 章子怡徐峥争论引发热议，每个导师侧重点不一样，理性讨论挺好。",
      "translation": "Si Dao 5 min ago edited, Zhang Zi Yi and Xu Zheng debate sparked discussion, discussion is good.",
      "tokens": [
        {
          "text": "斯道5 min ago Edited",
          "kind": "other",
          "meaning": null
        },
        {
          "text": "章子怡徐峥争论引发热议",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "，",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "每个导师侧重点不一样",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "，",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "理性讨论挺好",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "。",
          "kind": "punctuation",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "网友表示章子怡老师你能不能让徐峥大叔把话说完，老是打断人家这样很不好徐璐阚清子的表演你喜欢吗～",
      "translation": "Can Zhang Zi Yi teacher let Xu Zheng uncle finish speaking? He interrupts, which is bad; like performance?",
      "tokens": [
        {
          "text": "网友表示",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "章子怡老师你能不能让徐峥大叔把话说完",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "，",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "老是打断人家这样很不好",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "徐璐阚清子的表演你喜欢吗",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "～",
          "kind": "punctuation",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "央视新闻38 min ago from 微博 weibo.com Edited",
      "translation": "CCTV News 38 min ago from Weibo weibo.com Edited",
      "tokens": [
        {
          "text": "央视新闻38 min ago from 微博 weibo.com Edited",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Weibo",
      "translation": "Weibo",
      "tokens": [
        {
          "text": "Weibo",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Message Discover Me",
      "translation": "Message Discover Me",
      "tokens": [
        {
          "text": "Message",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "Discover",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "Me",
          "kind": "word",
          "meaning": null
        }
      ]
    }
  ],
  "glossary": [
    {
      "text": "头条",
      "meaning": "top headline"
    },
    {
      "text": "微头条",
      "meaning": "micro-headline"
    },
    {
      "text": "发布",
      "meaning": "release"
    },
    {
      "text": "热榜",
      "meaning": "trending list"
    },
    {
      "text": "知名车评人",
      "meaning": "well-known car reviewer"
    },
    {
      "text": "老司机App联",
      "meaning": "old driver app link"
    },
    {
      "text": "四川轿顶山",
      "meaning": "Sichuan Jiao Ding Mountain"
    },
    {
      "text": "贡嘎雪山",
      "meaning": "Mount Gongga"
    },
    {
      "text": "斯道",
      "meaning": "Si Dao"
    },
    {
      "text": "央视新闻",
      "meaning": "CCTV News"
    },
    {
      "text": "微博",
      "meaning": "Weibo"
    }
  ],
  "pronunciationHints": [
    {
      "phrase": "头条",
      "preferredPinyin": "tóu tiáo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Toutiao",
      "preferredPinyin": "tuóu táo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "微头条",
      "preferredPinyin": "wēi tóu tiáo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "发布",
      "preferredPinyin": "fā bù",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "热榜",
      "preferredPinyin": "rè bǎng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "怀念单田芳",
      "preferredPinyin": "huái niàn dān tián fāng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "台风山竹",
      "preferredPinyin": "tái fēng shān zhú",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "被讹小伙要起",
      "preferredPinyin": "bèi é hǎo hǎo yào qǐ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "朱旭去世",
      "preferredPinyin": "zhū xù qū sǐ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "韩路出品",
      "preferredPinyin": "hán lù chū pǐn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "知名车评人",
      "preferredPinyin": "zhī míng chē píng rén",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "老司机App联",
      "preferredPinyin": "lǎo jī xíng app lián",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "四川轿顶山",
      "preferredPinyin": "sì chuān jiào dǐng shān",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "贡嘎雪山",
      "preferredPinyin": "gòng gǎ xuě shān",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "湿湿哒之旅",
      "preferredPinyin": "shī shī dā zhī lǚ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Mavic2近地起降场补光",
      "preferredPinyin": "má vī 2 jìn dì qǐ jiàng chǎng bǔ guāng",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "UFO抓地球人",
      "preferredPinyin": "u fó zhuā dì qiú rén",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "斯道",
      "preferredPinyin": "sī dào",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "章子怡徐峥争论",
      "preferredPinyin": "zhāng zǐ yí xú zhēng zhēng lùn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "理性讨论挺好",
      "preferredPinyin": "lǐ xìng tǎo lùn hěn hǎo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "徐璐阚清子的表演",
      "preferredPinyin": "xú lù kàn qīng zǐ de biǎo yǎn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "央视新闻",
      "preferredPinyin": "cì yì xīn wén",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "微博",
      "preferredPinyin": "wēi bo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "weibo.com",
      "preferredPinyin": "wēi bo . com",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Message",
      "preferredPinyin": "mèi xìn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Discover",
      "preferredPinyin": "fā xiàn",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    },
    {
      "phrase": "Me",
      "preferredPinyin": "wǒ",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.9
    }
  ]
}
```

### Glossary Enrichment Output
```json
{
  "entries": []
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "头条\nToutiao\n10:544G\n微头条发布\n热榜\n#怀念单田芳# #台风山竹# #被讹小伙要起... #朱旭去世# 韩路出品前天19:37·知名车评人老司机App联... 我们现在3200米海拔的四川轿顶山，大雾，本来想着气爽来看贡嘎雪山，如今成了0度99%湿度还没电的湿湿哒之旅😂😂😂 Mavic2近地起降场补光，像不像UFO抓地球人时候那感觉😂😂😂\n头条\nToutiao\n10:554G\nSearch\nFollowing hot\n斯道5 min ago Edited 章子怡徐峥争论引发热议，每个导师侧重点不一样，理性讨论挺好。网友表示章子怡老师你能不能让徐峥大叔把话说完，老是打断人家这样很不好徐璐阚清子的表演你喜欢吗～\n央视新闻38 min ago from 微博 weibo.com Edited\nWeibo\nMessage Discover Me",
  "language": "zh-Hans",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "头条",
      "pinyin": "tóu tiáo",
      "translation": "Top headline",
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "头条",
          "pinyin": "tóu tiáo",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "text_model_hint"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "微头条发布",
      "pinyin": "wēi tóu tiáo fā bù",
      "translation": "Micro-headline published",
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "微头条",
          "pinyin": "wēi tóu tiáo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s2-t2",
          "hanzi": "发布",
          "pinyin": "fā bù",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "text_model_hint"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "热榜",
      "pinyin": "rè bǎng",
      "translation": "Trending list",
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "热榜",
          "pinyin": "rè bǎng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "text_model_hint"
        }
      ]
    },
    {
      "id": "s4",
      "hanzi": "#怀念单田芳##台风山竹##被讹小伙要起...",
      "pinyin": "# huái niàn dān tián fāng # # tái fēng shān zhú # # bèi é xiǎo huǒ yào qǐ ...",
      "translation": "Hashtags: nostalgic Dan Tian Fang, typhoon bamboo, misreported guy wants to rise",
      "tokens": [
        {
          "id": "s4-t1",
          "hanzi": "#怀念单田芳#",
          "pinyin": "# huái niàn dān tián fāng #",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t2",
          "hanzi": "#台风山竹#",
          "pinyin": "# tái fēng shān zhú #",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t3",
          "hanzi": "#被讹小伙要起...",
          "pinyin": "# bèi é xiǎo huǒ yào qǐ ...",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s5",
      "hanzi": "韩路出品前天19:37·知名车评人老司机App联",
      "pinyin": "hán lù chū pǐn qián tiān 19:37· zhī míng chē píng rén lǎo jī xíng app lián",
      "translation": "Han Lu production, two days ago at 19:37, featuring a known car reviewer and old driver app link",
      "tokens": [
        {
          "id": "s5-t1",
          "hanzi": "韩路出品",
          "pinyin": "hán lù chū pǐn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s5-t2",
          "hanzi": "前天19:37·知名车评人",
          "pinyin": "qián tiān 19:37· zhī míng chē píng rén",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t3",
          "hanzi": "老司机App联",
          "pinyin": "lǎo jī xíng app lián",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "text_model_hint"
        }
      ]
    },
    {
      "id": "s6",
      "hanzi": "我们现在3200米海拔的四川轿顶山，大雾，本来想着气爽来看贡嘎雪山，如今成了0度99%湿度还没电的湿湿哒之旅",
      "pinyin": "wǒ men xiàn zài 3200 mǐ hǎi bá de sì chuān jiào dǐng shān， dà wù， běn lái xiǎng zhe qì shuǎng lái kàn gòng gā xuě shān， rú jīn chéng le 0 dù 99% shī dù hái méi diàn de shī shī dá zhī lǚ",
      "translation": "At 3,200m on Sichuan's Jiao Ding Mountain, foggy, now 0°C, 99% humidity, out of power, damp trip 😂",
      "tokens": [
        {
          "id": "s6-t1",
          "hanzi": "我们现在3200米海拔的四川轿顶山",
          "pinyin": "wǒ men xiàn zài 3200 mǐ hǎi bá de sì chuān jiào dǐng shān",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t2",
          "hanzi": "，",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t3",
          "hanzi": "大雾",
          "pinyin": "dà wù",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t4",
          "hanzi": "，",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t5",
          "hanzi": "本来想着气爽来看贡嘎雪山",
          "pinyin": "běn lái xiǎng zhe qì shuǎng lái kàn gòng gā xuě shān",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t6",
          "hanzi": "，",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t7",
          "hanzi": "如今成了0度99%湿度还没电的湿湿哒之旅",
          "pinyin": "rú jīn chéng le 0 dù 99% shī dù hái méi diàn de shī shī dá zhī lǚ",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s7",
      "hanzi": "Mavic2近地起降场补光，像不像UFO抓地球人时候那感觉",
      "pinyin": "má vī 2 jìn dì qǐ jiàng chǎng bǔ guāng， xiàng bú xiàng UFO zhuā dì qiú rén shí hòu nà gǎn jué",
      "translation": "Mavic 2 low‑altitude takeoff and landing site lighting, looks like a UFO catching humans, that feeling 😂😂😂",
      "tokens": [
        {
          "id": "s7-t1",
          "hanzi": "Mavic2近地起降场补光",
          "pinyin": "má vī 2 jìn dì qǐ jiàng chǎng bǔ guāng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s7-t2",
          "hanzi": "，",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t3",
          "hanzi": "像不像UFO抓地球人时候那感觉",
          "pinyin": "xiàng bú xiàng UFO zhuā dì qiú rén shí hòu nà gǎn jué",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s8",
      "hanzi": "斯道5 min ago Edited章子怡徐峥争论引发热议，每个导师侧重点不一样，理性讨论挺好。",
      "pinyin": "sī dào 5 min ago Edited zhāng zi yí xú zhēng zhēng lùn yǐn fā rè yì， měi gè dǎo shī cè zhòng diǎn bù yí yàng， lǐ xìng tǎo lùn hěn hǎo。",
      "translation": "Si Dao 5 min ago edited, Zhang Zi Yi and Xu Zheng debate sparked discussion, discussion is good.",
      "tokens": [
        {
          "id": "s8-t1",
          "hanzi": "斯道5 min ago Edited",
          "pinyin": "sī dào 5 min ago Edited",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t2",
          "hanzi": "章子怡徐峥争论引发热议",
          "pinyin": "zhāng zi yí xú zhēng zhēng lùn yǐn fā rè yì",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t3",
          "hanzi": "，",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t4",
          "hanzi": "每个导师侧重点不一样",
          "pinyin": "měi gè dǎo shī cè zhòng diǎn bù yí yàng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t5",
          "hanzi": "，",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t6",
          "hanzi": "理性讨论挺好",
          "pinyin": "lǐ xìng tǎo lùn hěn hǎo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s8-t7",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s9",
      "hanzi": "网友表示章子怡老师你能不能让徐峥大叔把话说完，老是打断人家这样很不好徐璐阚清子的表演你喜欢吗",
      "pinyin": "wǎng yǒu biǎo shì zhāng zi yí lǎo shī nǐ néng bù néng ràng xú zhēng dà shū bǎ huà shuō wán， lǎo shì dǎ duàn rén jiā zhè yàng hěn bù hǎo xú lù hǎn qīng zi de biǎo yǎn nǐ xǐ huān ma",
      "translation": "Can Zhang Zi Yi teacher let Xu Zheng uncle finish speaking?",
      "tokens": [
        {
          "id": "s9-t1",
          "hanzi": "网友表示",
          "pinyin": "wǎng yǒu biǎo shì",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t2",
          "hanzi": "章子怡老师你能不能让徐峥大叔把话说完",
          "pinyin": "zhāng zi yí lǎo shī nǐ néng bù néng ràng xú zhēng dà shū bǎ huà shuō wán",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t3",
          "hanzi": "，",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t4",
          "hanzi": "老是打断人家这样很不好",
          "pinyin": "lǎo shì dǎ duàn rén jiā zhè yàng hěn bù hǎo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t5",
          "hanzi": "徐璐阚清子的表演你喜欢吗",
          "pinyin": "xú lù hǎn qīng zi de biǎo yǎn nǐ xǐ huān ma",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s10",
      "hanzi": "央视新闻38 min ago from 微博 weibo.com Edited",
      "pinyin": "yāng shì xīn wén 38 min ago from wēi bó weibo.com Edited",
      "translation": "CCTV News 38 min ago from Weibo weibo.com Edited",
      "tokens": [
        {
          "id": "s10-t1",
          "hanzi": "央视新闻38 min ago from 微博 weibo.com Edited",
          "pinyin": "yāng shì xīn wén 38 min ago from wēi bó weibo.com Edited",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "头条",
      "pinyin": "tóu tiáo",
      "meaning": "top headline",
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "微头条",
      "pinyin": "wēi tóu tiáo",
      "meaning": "micro-headline",
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "发布",
      "pinyin": "fā bù",
      "meaning": "release",
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "热榜",
      "pinyin": "rè bǎng",
      "meaning": "trending list",
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "#怀念单田芳#",
      "pinyin": "# huái niàn dān tián fāng #",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "#台风山竹#",
      "pinyin": "# tái fēng shān zhú #",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "#被讹小伙要起...",
      "pinyin": "# bèi é xiǎo huǒ yào qǐ ...",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "韩路出品",
      "pinyin": "hán lù chū pǐn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "前天19:37·知名车评人",
      "pinyin": "qián tiān 19:37· zhī míng chē píng rén",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "老司机App联",
      "pinyin": "lǎo jī xíng app lián",
      "meaning": "old driver app link",
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "我们现在3200米海拔的四川轿顶山",
      "pinyin": "wǒ men xiàn zài 3200 mǐ hǎi bá de sì chuān jiào dǐng shān",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "大雾",
      "pinyin": "dà wù",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "本来想着气爽来看贡嘎雪山",
      "pinyin": "běn lái xiǎng zhe qì shuǎng lái kàn gòng gā xuě shān",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "如今成了0度99%湿度还没电的湿湿哒之旅",
      "pinyin": "rú jīn chéng le 0 dù 99% shī dù hái méi diàn de shī shī dá zhī lǚ",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "Mavic2近地起降场补光",
      "pinyin": "má vī 2 jìn dì qǐ jiàng chǎng bǔ guāng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "像不像UFO抓地球人时候那感觉",
      "pinyin": "xiàng bú xiàng UFO zhuā dì qiú rén shí hòu nà gǎn jué",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "章子怡徐峥争论引发热议",
      "pinyin": "zhāng zi yí xú zhēng zhēng lùn yǐn fā rè yì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "每个导师侧重点不一样",
      "pinyin": "měi gè dǎo shī cè zhòng diǎn bù yí yàng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "理性讨论挺好",
      "pinyin": "lǐ xìng tǎo lùn hěn hǎo",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "网友表示",
      "pinyin": "wǎng yǒu biǎo shì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "章子怡老师你能不能让徐峥大叔把话说完",
      "pinyin": "zhāng zi yí lǎo shī nǐ néng bù néng ràng xú zhēng dà shū bǎ huà shuō wán",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "老是打断人家这样很不好",
      "pinyin": "lǎo shì dǎ duàn rén jiā zhè yàng hěn bù hǎo",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "徐璐阚清子的表演你喜欢吗",
      "pinyin": "xú lù hǎn qīng zi de biǎo yǎn nǐ xǐ huān ma",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "知名车评人",
      "pinyin": "zhī míng chē píng rén",
      "meaning": "well-known car reviewer",
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "四川轿顶山",
      "pinyin": "sì chuān jiào dǐng shān",
      "meaning": "Sichuan Jiao Ding Mountain",
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "贡嘎雪山",
      "pinyin": "gòng gǎ xuě shān",
      "meaning": "Mount Gongga",
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "斯道",
      "pinyin": "sī dào",
      "meaning": "Si Dao",
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "央视新闻",
      "pinyin": "cì yì xīn wén",
      "meaning": "CCTV News",
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "微博",
      "pinyin": "wēi bo",
      "meaning": "Weibo",
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "text_model_hint"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "头条",
  "pinyin": "tóu tiáo",
  "meaning": "mainheadline; leading story",
  "notes": null,
  "examples": [],
  "pinyinSource": "text_model_hint"
}
```

## 19. weibo_kol_1.jpg | auto | baidu/qianfan-ocr-fast:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=200, latency=84.88s
- Explain endpoint: status=200, latency=315.62s

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=True, attempts=1, latency=10.78s, prompt_tokens=4129, completion_tokens=892, total_tokens=5021, t/s=82.75
- `text analysis` via `nvidia/nemotron-3-nano-30b-a3b:free`: ok=True, attempts=1, latency=54.74s, prompt_tokens=1545, completion_tokens=13240, total_tokens=14785, t/s=241.85
- `glossary enrichment` via `nvidia/nemotron-3-nano-30b-a3b:free`: ok=True, attempts=1, latency=19.33s, prompt_tokens=1629, completion_tokens=4743, total_tokens=6372, t/s=245.38

### Vision Output
```json
{
  "documentText": "15:3315:3415:34 Search Weibo Weibo Following hot 粉丝福利购2626醉鹅娘醉鹅娘精品葡萄酒店5 Yesterday 19:25 from 微博视频怎么能让一碟菜从20块钱变成200块钱呢？醉鹅娘超话 #醉鹅娘品味小知识# @鲜城 【10元券】微博专享限时领券醉鹅娘的微博视频在礼盒后面有一个品鉴方法1010元券】微博专享限时领券用券后价：¥299.00领券20.3K views 4846 Weibo Video Discover Message Me 15:3415:34 Weibo Weibo 粉丝福利购2626醉鹅娘精品葡萄酒店510使用期限2019.06.24-2019.07.31立即领券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮2笔成交现价：¥309用券后 ¥299.00更多宝贝推荐优惠券 ¥5优惠券 ¥5顺风包邮101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回加入购物车领券购买用券后价 ¥299",
  "language": "zh-Hans",
  "readingLines": [],
  "pronunciationHints": [],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [
    {
      "hanzi": "粉丝福利购 2626 醉鹅娘精品葡萄酒店5",
      "translation": "Fan benefit purchase 2626 Zui E Niang premium wine hotel 5",
      "tokens": [
        {
          "text": "粉丝福利购",
          "kind": "word",
          "meaning": "fan benefit purchase"
        },
        {
          "text": "2626",
          "kind": "word",
          "meaning": "number"
        },
        {
          "text": "醉鹅娘",
          "kind": "word",
          "meaning": "Zui E Niang"
        },
        {
          "text": "精品葡萄酒店",
          "kind": "word",
          "meaning": "premium wine hotel"
        },
        {
          "text": "5",
          "kind": "word",
          "meaning": "number"
        }
      ]
    },
    {
      "hanzi": "昨天 19:25 来自 微博视频 怎么能让一盘菜从20块钱变成200块钱呢？",
      "translation": "Yesterday at 19:25 from Weibo Video: How can a dish go from 20 yuan to 200 yuan?",
      "tokens": [
        {
          "text": "昨天",
          "kind": "word",
          "meaning": "yesterday"
        },
        {
          "text": "19:25",
          "kind": "word",
          "meaning": "time"
        },
        {
          "text": "来自",
          "kind": "word",
          "meaning": "from"
        },
        {
          "text": "微博视频",
          "kind": "word",
          "meaning": "Weibo Video"
        },
        {
          "text": "怎么能",
          "kind": "word",
          "meaning": "how can"
        },
        {
          "text": "让一盘菜",
          "kind": "word",
          "meaning": "make a dish"
        },
        {
          "text": "从20块钱",
          "kind": "word",
          "meaning": "from 20 yuan"
        },
        {
          "text": "变成200块钱",
          "kind": "word",
          "meaning": "to 200 yuan"
        },
        {
          "text": "呢？",
          "kind": "word",
          "meaning": "?"
        }
      ]
    },
    {
      "hanzi": "醉鹅娘超话 #醉鹅娘品味小知识# @鲜城 10元券 微博专享限时领券",
      "translation": "Zui E Niang super topic #Zui E Niang taste tips# @Fresh City 10 yuan coupon exclusive limited-time coupon",
      "tokens": [
        {
          "text": "醉鹅娘超话",
          "kind": "word",
          "meaning": "Zui E Niang super topic"
        },
        {
          "text": "#醉鹅娘品味小知识#",
          "kind": "word",
          "meaning": "Zui E Niang taste tips"
        },
        {
          "text": "@鲜城",
          "kind": "word",
          "meaning": "@Fresh City"
        },
        {
          "text": "10元券",
          "kind": "word",
          "meaning": "10 yuan coupon"
        },
        {
          "text": "微博专享限时领券",
          "kind": "word",
          "meaning": "exclusive limited-time coupon on Weibo"
        }
      ]
    },
    {
      "hanzi": "用券后价 ¥299.00 20.3K views 4846 Weibo Video Discover Message Me",
      "translation": "After coupon price ¥299.00, 20.3K views, 4846 Weibo Video Discover Message Me",
      "tokens": [
        {
          "text": "用券后价",
          "kind": "word",
          "meaning": "after coupon price"
        },
        {
          "text": "¥299.00",
          "kind": "word",
          "meaning": "¥299.00"
        },
        {
          "text": "20.3K",
          "kind": "word",
          "meaning": "20.3K"
        },
        {
          "text": "views",
          "kind": "word",
          "meaning": "views"
        },
        {
          "text": "4846",
          "kind": "word",
          "meaning": "4846"
        },
        {
          "text": "Weibo Video",
          "kind": "word",
          "meaning": "Weibo Video"
        },
        {
          "text": "Discover",
          "kind": "word",
          "meaning": "Discover"
        },
        {
          "text": "Message",
          "kind": "word",
          "meaning": "Message"
        },
        {
          "text": "Me",
          "kind": "word",
          "meaning": "Me"
        }
      ]
    },
    {
      "hanzi": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮 2笔成交 现价 ¥309 用券后 ¥299.00",
      "translation": "Zui E Niang goose x Poetry Rui caviar Siberian 30g gift box, shipping, price ¥309 after coupon ¥299",
      "tokens": [
        {
          "text": "醉鹅娘了不起鹅",
          "kind": "word",
          "meaning": "Zui E Niang goose"
        },
        {
          "text": "x",
          "kind": "word",
          "meaning": "x"
        },
        {
          "text": "诗芮鱼子酱",
          "kind": "word",
          "meaning": "Poetry Rui caviar"
        },
        {
          "text": "西伯利亚30g",
          "kind": "word",
          "meaning": "Siberian 30g"
        },
        {
          "text": "礼盒装",
          "kind": "word",
          "meaning": "gift box"
        },
        {
          "text": "包邮",
          "kind": "word",
          "meaning": "shipping"
        },
        {
          "text": "2笔成交",
          "kind": "word",
          "meaning": "2 sales"
        },
        {
          "text": "现价",
          "kind": "word",
          "meaning": "price"
        },
        {
          "text": "¥309",
          "kind": "word",
          "meaning": "¥309"
        },
        {
          "text": "用券后",
          "kind": "word",
          "meaning": "after coupon"
        },
        {
          "text": "¥299.00",
          "kind": "word",
          "meaning": "¥299"
        }
      ]
    },
    {
      "hanzi": "使用期限2019.06.24-2019.07.31立即领券",
      "translation": "Usage period 2019.06.24-2019.07.31 claim coupon now",
      "tokens": [
        {
          "text": "使用期限",
          "kind": "word",
          "meaning": "usage period"
        },
        {
          "text": "2019.06.24-2019.07.31",
          "kind": "word",
          "meaning": "2019.06.24-2019.07.31"
        },
        {
          "text": "立即领券",
          "kind": "word",
          "meaning": "claim coupon now"
        }
      ]
    },
    {
      "hanzi": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回",
      "translation": "Zui E Niang goose x Poetry Rui caviar Siberian 30g gift box, 2 people liked, Chengdu shipping, free, monthly sales 3",
      "tokens": [
        {
          "text": "醉鹅娘了不起鹅",
          "kind": "word",
          "meaning": "Zui E Niang goose"
        },
        {
          "text": "x",
          "kind": "word",
          "meaning": "x"
        },
        {
          "text": "诗芮鱼子酱",
          "kind": "word",
          "meaning": "Poetry Rui caviar"
        },
        {
          "text": "西伯利亚30g",
          "kind": "word",
          "meaning": "Siberian 30g"
        },
        {
          "text": "礼盒装2人",
          "kind": "word",
          "meaning": "gift box for 2 people"
        },
        {
          "text": "赞过",
          "kind": "word",
          "meaning": "liked"
        },
        {
          "text": "帮我选发货",
          "kind": "word",
          "meaning": "choose shipping"
        },
        {
          "text": "四川成都快递",
          "kind": "word",
          "meaning": "Chengdu shipping"
        },
        {
          "text": "免运费",
          "kind": "word",
          "meaning": "free"
        },
        {
          "text": "月销3",
          "kind": "word",
          "meaning": "monthly sales 3"
        }
      ]
    },
    {
      "hanzi": "加入购物车领券购买用券后价 ¥299",
      "translation": "Add to cart claim coupon purchase after coupon price ¥299",
      "tokens": [
        {
          "text": "加入购物车",
          "kind": "word",
          "meaning": "add to cart"
        },
        {
          "text": "领券",
          "kind": "word",
          "meaning": "claim coupon"
        },
        {
          "text": "购买",
          "kind": "word",
          "meaning": "purchase"
        },
        {
          "text": "用券后价",
          "kind": "word",
          "meaning": "after coupon price"
        },
        {
          "text": "¥299",
          "kind": "word",
          "meaning": "¥299"
        }
      ]
    }
  ],
  "glossary": [
    {
      "text": "粉丝福利购",
      "meaning": "fan benefit purchase"
    },
    {
      "text": "醉鹅娘",
      "meaning": "Zui E Niang"
    },
    {
      "text": "精品葡萄酒店",
      "meaning": "premium wine hotel"
    },
    {
      "text": "优惠券",
      "meaning": "coupon"
    },
    {
      "text": "领券",
      "meaning": "claim coupon"
    },
    {
      "text": "视频",
      "meaning": "video"
    },
    {
      "text": "观看量",
      "meaning": "views"
    },
    {
      "text": "价格",
      "meaning": "price"
    },
    {
      "text": "使用期限",
      "meaning": "usage period"
    },
    {
      "text": "礼盒装",
      "meaning": "gift box"
    },
    {
      "text": "免运费",
      "meaning": "free shipping"
    },
    {
      "text": "月销",
      "meaning": "monthly sales"
    },
    {
      "text": "服务",
      "meaning": "service"
    },
    {
      "text": "发货",
      "meaning": "delivery"
    },
    {
      "text": "快递",
      "meaning": "courier"
    },
    {
      "text": "成都",
      "meaning": "Chengdu"
    },
    {
      "text": "退货",
      "meaning": "return"
    },
    {
      "text": "保险",
      "meaning": "insurance"
    },
    {
      "text": "生产日期",
      "meaning": "production date"
    },
    {
      "text": "厂名",
      "meaning": "manufacturer"
    }
  ],
  "pronunciationHints": [
    {
      "phrase": "醉鹅娘",
      "preferredPinyin": "Zui E Niang",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    }
  ]
}
```

### Glossary Enrichment Output
```json
{
  "entries": [
    {
      "text": "粉丝福利购",
      "literalMeaning": "fan benefit purchase",
      "exampleSentence": "这个活动是粉丝福利购。"
    },
    {
      "text": "醉鹅娘",
      "literalMeaning": "drunken goose lady",
      "exampleSentence": "醉鹅娘的酒店很有名。"
    },
    {
      "text": "精品葡萄酒店",
      "literalMeaning": "premium wine hotel",
      "exampleSentence": "我们去精品葡萄酒店品尝。"
    },
    {
      "text": "昨天",
      "literalMeaning": "yesterday",
      "exampleSentence": "昨天我去了超市。"
    },
    {
      "text": "来自",
      "literalMeaning": "from",
      "exampleSentence": "这件衣服来自中国。"
    },
    {
      "text": "微博视频",
      "literalMeaning": "Weibo video",
      "exampleSentence": "他在微博视频上发布了新片段。"
    },
    {
      "text": "怎么能",
      "literalMeaning": "how can",
      "exampleSentence": "怎么能这样做？"
    },
    {
      "text": "让一盘菜",
      "literalMeaning": "make a dish",
      "exampleSentence": "让一盘菜变得好吃。"
    },
    {
      "text": "从",
      "literalMeaning": "from",
      "exampleSentence": "这本书是从图书馆借的。"
    },
    {
      "text": "块钱",
      "literalMeaning": "yuan",
      "exampleSentence": "这件衣服只要几块钱。"
    },
    {
      "text": "变成",
      "literalMeaning": "become",
      "exampleSentence": "它慢慢变成了雨。"
    },
    {
      "text": "呢",
      "literalMeaning": "?",
      "exampleSentence": "你要干嘛呢？"
    },
    {
      "text": "醉鹅娘超话",
      "literalMeaning": "drunken goose lady hashtag",
      "exampleSentence": "他在醉鹅娘超话里发了动态。"
    },
    {
      "text": "醉鹅娘品味小知识",
      "literalMeaning": "drunken goose lady taste small knowledge",
      "exampleSentence": "这篇文章是醉鹅娘品味小知识。"
    },
    {
      "text": "鲜城",
      "literalMeaning": "Fresh City",
      "exampleSentence": "我在鲜城点了外卖。"
    },
    {
      "text": "元券",
      "literalMeaning": "yuan coupon",
      "exampleSentence": "这个元券可以抵扣钱。"
    },
    {
      "text": "微博专享限时领券",
      "literalMeaning": "Weibo exclusive limited-time coupon",
      "exampleSentence": "微博专享限时领券活动开始了。"
    },
    {
      "text": "用券后价",
      "literalMeaning": "price after coupon",
      "exampleSentence": "用券后价是299元。"
    },
    {
      "text": "醉鹅娘了不起鹅",
      "literalMeaning": "drunken goose lady amazing goose",
      "exampleSentence": "醉鹅娘了不起鹅的产品很受欢迎。"
    },
    {
      "text": "诗芮鱼子酱",
      "literalMeaning": "Shi Rui caviar",
      "exampleSentence": "诗芮鱼子酱口感鲜美。"
    },
    {
      "text": "西伯利亚",
      "literalMeaning": "Siberia",
      "exampleSentence": "西伯利亚的鱼子酱很贵。"
    },
    {
      "text": "礼盒装",
      "literalMeaning": "gift box packaging",
      "exampleSentence": "这个产品是礼盒装的。"
    },
    {
      "text": "包邮",
      "literalMeaning": "free shipping",
      "exampleSentence": "买这个商品包邮。"
    },
    {
      "text": "笔成交",
      "literalMeaning": "transaction count",
      "exampleSentence": "这笔成交记录很高。"
    },
    {
      "text": "现价",
      "literalMeaning": "current price",
      "exampleSentence": "现价是299元。"
    },
    {
      "text": "用券后",
      "literalMeaning": "after coupon",
      "exampleSentence": "用券后价格是299元。"
    },
    {
      "text": "使用期限",
      "literalMeaning": "validity period",
      "exampleSentence": "使用期限到7月31日。"
    },
    {
      "text": "立即领券",
      "literalMeaning": "claim coupon now",
      "exampleSentence": "立即领券可以立减5元。"
    },
    {
      "text": "人",
      "literalMeaning": "person",
      "exampleSentence": "这位人很友好。"
    },
    {
      "text": "赞过",
      "literalMeaning": "liked before",
      "exampleSentence": "他的帖子被赞过很多次。"
    },
    {
      "text": "帮我选发货",
      "literalMeaning": "help me choose shipping",
      "exampleSentence": "帮我选发货的快递。"
    },
    {
      "text": "四川成都快递",
      "literalMeaning": "Chengdu courier from Sichuan",
      "exampleSentence": "四川成都快递免运费。"
    },
    {
      "text": "免运费",
      "literalMeaning": "free shipping",
      "exampleSentence": "这个商品免运费。"
    },
    {
      "text": "月销",
      "literalMeaning": "monthly sales",
      "exampleSentence": "月销量超过1000件。"
    },
    {
      "text": "加入购物车",
      "literalMeaning": "add to cart",
      "exampleSentence": "请加入购物车。"
    },
    {
      "text": "领券",
      "literalMeaning": "claim coupon",
      "exampleSentence": "现在领券可以减5元。"
    },
    {
      "text": "购买",
      "literalMeaning": "purchase",
      "exampleSentence": "用户进行购买。"
    },
    {
      "text": "优惠券",
      "literalMeaning": "discount coupon",
      "exampleSentence": "使用优惠券后价格更低。"
    },
    {
      "text": "视频",
      "literalMeaning": "video",
      "exampleSentence": "这个视频很有趣。"
    },
    {
      "text": "观看量",
      "literalMeaning": "view count",
      "exampleSentence": "观看量达到20000次。"
    },
    {
      "text": "价格",
      "literalMeaning": "price",
      "exampleSentence": "价格是299元。"
    },
    {
      "text": "服务",
      "literalMeaning": "service",
      "exampleSentence": "提供良好服务。"
    },
    {
      "text": "发货",
      "literalMeaning": "ship goods",
      "exampleSentence": "发货后会有物流信息。"
    },
    {
      "text": "快递",
      "literalMeaning": "courier",
      "exampleSentence": "快递送达很快。"
    },
    {
      "text": "成都",
      "literalMeaning": "Chengdu",
      "exampleSentence": "我在成都生活。"
    },
    {
      "text": "退货",
      "literalMeaning": "return goods",
      "exampleSentence": "如果不满意可以退货。"
    },
    {
      "text": "保险",
      "literalMeaning": "insurance",
      "exampleSentence": "商品有保险覆盖。"
    },
    {
      "text": "生产日期",
      "literalMeaning": "production date",
      "exampleSentence": "生产日期是2020年。"
    },
    {
      "text": "厂名",
      "literalMeaning": "manufacturer name",
      "exampleSentence": "厂名标在包装上。"
    }
  ]
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "15:3315:3415:34 Search Weibo Weibo Following hot 粉丝福利购2626醉鹅娘醉鹅娘精品葡萄酒店5 Yesterday 19:25 from 微博视频怎么能让一碟菜从20块钱变成200块钱呢？醉鹅娘超话 #醉鹅娘品味小知识# @鲜城 【10元券】微博专享限时领券醉鹅娘的微博视频在礼盒后面有一个品鉴方法1010元券】微博专享限时领券用券后价：¥299.00领券20.3K views 4846 Weibo Video Discover Message Me 15:3415:34 Weibo Weibo 粉丝福利购2626醉鹅娘精品葡萄酒店510使用期限2019.06.24-2019.07.31立即领券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮2笔成交现价：¥309用券后 ¥299.00更多宝贝推荐优惠券 ¥5优惠券 ¥5顺风包邮101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回加入购物车领券购买用券后价 ¥299",
  "language": "zh-Hans",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "粉丝福利购醉鹅娘精品葡萄酒店",
      "pinyin": "fěn sī fú lì gòu Zui E Niang jīng pǐn pú táo jiǔ diàn",
      "translation": "Fan benefit purchase 2626 Zui E Niang premium wine hotel 5",
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "粉丝福利购",
          "pinyin": "fěn sī fú lì gòu",
          "meaning": "fan benefit purchase",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t2",
          "hanzi": "醉鹅娘",
          "pinyin": "Zui E Niang",
          "meaning": "Zui E Niang",
          "kind": "word",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s1-t3",
          "hanzi": "精品葡萄酒店",
          "pinyin": "jīng pǐn pú táo jiǔ diàn",
          "meaning": "premium wine hotel",
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "昨天来自微博视频怎么能让一盘菜从块钱变成块钱呢？",
      "pinyin": "zuó tiān lái zì wēi bó shì pín zěn me néng ràng yī pán cài cóng kuài qián biàn chéng kuài qián ne？",
      "translation": "Yesterday at 19:25 from Weibo Video: How can a dish go from 20 yuan to 200 yuan?",
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "昨天",
          "pinyin": "zuó tiān",
          "meaning": "yesterday",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t2",
          "hanzi": "来自",
          "pinyin": "lái zì",
          "meaning": "from",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t3",
          "hanzi": "微博视频",
          "pinyin": "wēi bó shì pín",
          "meaning": "Weibo Video",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t4",
          "hanzi": "怎么能",
          "pinyin": "zěn me néng",
          "meaning": "how can",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t5",
          "hanzi": "让一盘菜",
          "pinyin": "ràng yī pán cài",
          "meaning": "make a dish",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t6",
          "hanzi": "从",
          "pinyin": "cóng",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t7",
          "hanzi": "块钱",
          "pinyin": "kuài qián",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t8",
          "hanzi": "变成",
          "pinyin": "biàn chéng",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t9",
          "hanzi": "块钱",
          "pinyin": "kuài qián",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t10",
          "hanzi": "呢",
          "pinyin": "ne",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t11",
          "hanzi": "？",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "醉鹅娘超话醉鹅娘品味小知识鲜城元券微博专享限时领券",
      "pinyin": "zuì é niáng chāo huà zuì é niáng pǐn wèi xiǎo zhī shí xiān chéng yuán quàn wēi bó zhuān xiǎng xiàn shí lǐng quàn",
      "translation": "Zui E Niang super topic #Zui E Niang taste tips# @Fresh City 10 yuan coupon exclusive limited-time coupon",
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "醉鹅娘超话",
          "pinyin": "zuì é niáng chāo huà",
          "meaning": "Zui E Niang super topic",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t2",
          "hanzi": "醉鹅娘品味小知识",
          "pinyin": "zuì é niáng pǐn wèi xiǎo zhī shí",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t3",
          "hanzi": "鲜城",
          "pinyin": "xiān chéng",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t4",
          "hanzi": "元券",
          "pinyin": "yuán quàn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t5",
          "hanzi": "微博专享限时领券",
          "pinyin": "wēi bó zhuān xiǎng xiàn shí lǐng quàn",
          "meaning": "exclusive limited-time coupon on Weibo",
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s4",
      "hanzi": "用券后价",
      "pinyin": "yòng quàn hòu jià",
      "translation": "After coupon price ¥299.00, 20.3K views, 4846 Weibo Video Discover Message Me",
      "tokens": [
        {
          "id": "s4-t1",
          "hanzi": "用券后价",
          "pinyin": "yòng quàn hòu jià",
          "meaning": "after coupon price",
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s5",
      "hanzi": "醉鹅娘了不起鹅诗芮鱼子酱西伯利亚礼盒装包邮笔成交现价用券后",
      "pinyin": "zuì é niáng liǎo bù qǐ é shī ruì yú zi jiàng xī bó lì yà lǐ hé zhuāng bāo yóu bǐ chéng jiāo xiàn jià yòng quàn hòu",
      "translation": "Zui E Niang goose x Poetry Rui caviar Siberian 30g gift box, shipping, price ¥309 after coupon ¥299",
      "tokens": [
        {
          "id": "s5-t1",
          "hanzi": "醉鹅娘了不起鹅",
          "pinyin": "zuì é niáng liǎo bù qǐ é",
          "meaning": "Zui E Niang goose",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t2",
          "hanzi": "诗芮鱼子酱",
          "pinyin": "shī ruì yú zi jiàng",
          "meaning": "Poetry Rui caviar",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t3",
          "hanzi": "西伯利亚",
          "pinyin": "xī bó lì yà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t4",
          "hanzi": "礼盒装",
          "pinyin": "lǐ hé zhuāng",
          "meaning": "gift box",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t5",
          "hanzi": "包邮",
          "pinyin": "bāo yóu",
          "meaning": "shipping",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t6",
          "hanzi": "笔成交",
          "pinyin": "bǐ chéng jiāo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t7",
          "hanzi": "现价",
          "pinyin": "xiàn jià",
          "meaning": "price",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t8",
          "hanzi": "用券后",
          "pinyin": "yòng quàn hòu",
          "meaning": "after coupon",
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s6",
      "hanzi": "使用期限立即领券",
      "pinyin": "shǐ yòng qī xiàn lì jí lǐng quàn",
      "translation": "Usage period 2019.06.24-2019.07.31 claim coupon now",
      "tokens": [
        {
          "id": "s6-t1",
          "hanzi": "使用期限",
          "pinyin": "shǐ yòng qī xiàn",
          "meaning": "usage period",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t2",
          "hanzi": "立即领券",
          "pinyin": "lì jí lǐng quàn",
          "meaning": "claim coupon now",
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s7",
      "hanzi": "醉鹅娘了不起鹅诗芮鱼子酱西伯利亚礼盒装人赞过帮我选发货四川成都快递免运费月销",
      "pinyin": "zuì é niáng liǎo bù qǐ é shī ruì yú zi jiàng xī bó lì yà lǐ hé zhuāng rén zàn guò bāng wǒ xuǎn fā huò sì chuān chéng dū kuài dì miǎn yùn fèi yuè xiāo",
      "translation": "Zui E Niang goose x Poetry Rui caviar Siberian 30g gift box, 2 people liked, Chengdu shipping, free, monthly sales 3",
      "tokens": [
        {
          "id": "s7-t1",
          "hanzi": "醉鹅娘了不起鹅",
          "pinyin": "zuì é niáng liǎo bù qǐ é",
          "meaning": "Zui E Niang goose",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t2",
          "hanzi": "诗芮鱼子酱",
          "pinyin": "shī ruì yú zi jiàng",
          "meaning": "Poetry Rui caviar",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t3",
          "hanzi": "西伯利亚",
          "pinyin": "xī bó lì yà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t4",
          "hanzi": "礼盒装",
          "pinyin": "lǐ hé zhuāng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t5",
          "hanzi": "人",
          "pinyin": "rén",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t6",
          "hanzi": "赞过",
          "pinyin": "zàn guò",
          "meaning": "liked",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t7",
          "hanzi": "帮我选发货",
          "pinyin": "bāng wǒ xuǎn fā huò",
          "meaning": "choose shipping",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t8",
          "hanzi": "四川成都快递",
          "pinyin": "sì chuān chéng dū kuài dì",
          "meaning": "Chengdu shipping",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t9",
          "hanzi": "免运费",
          "pinyin": "miǎn yùn fèi",
          "meaning": "free",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t10",
          "hanzi": "月销",
          "pinyin": "yuè xiāo",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s8",
      "hanzi": "加入购物车领券购买用券后价",
      "pinyin": "jiā rù gòu wù chē lǐng quàn gòu mǎi yòng quàn hòu jià",
      "translation": "Add to cart claim coupon purchase after coupon price ¥299",
      "tokens": [
        {
          "id": "s8-t1",
          "hanzi": "加入购物车",
          "pinyin": "jiā rù gòu wù chē",
          "meaning": "add to cart",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t2",
          "hanzi": "领券",
          "pinyin": "lǐng quàn",
          "meaning": "claim coupon",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t3",
          "hanzi": "购买",
          "pinyin": "gòu mǎi",
          "meaning": "purchase",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t4",
          "hanzi": "用券后价",
          "pinyin": "yòng quàn hòu jià",
          "meaning": "after coupon price",
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "粉丝福利购",
      "pinyin": "fěn sī fú lì gòu",
      "meaning": "fan benefit purchase",
      "exampleSentence": "这个活动是粉丝福利购。",
      "exampleSentencePinyin": "zhè ge huó dòng shì fěn sī fú lì gòu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "醉鹅娘",
      "pinyin": "Zui E Niang",
      "meaning": "drunken goose lady",
      "exampleSentence": "醉鹅娘的酒店很有名。",
      "exampleSentencePinyin": "Zui E Niang de jiǔ diàn hěn yǒu míng 。",
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "精品葡萄酒店",
      "pinyin": "jīng pǐn pú táo jiǔ diàn",
      "meaning": "premium wine hotel",
      "exampleSentence": "我们去精品葡萄酒店品尝。",
      "exampleSentencePinyin": "wǒ men qù jīng pǐn pú táo jiǔ diàn pǐn cháng 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "昨天",
      "pinyin": "zuó tiān",
      "meaning": "yesterday",
      "exampleSentence": "昨天我去了超市。",
      "exampleSentencePinyin": "zuó tiān wǒ qù le chāo shì 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "来自",
      "pinyin": "lái zì",
      "meaning": "from",
      "exampleSentence": "这件衣服来自中国。",
      "exampleSentencePinyin": "zhè jiàn yī fú lái zì zhōng guó 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "微博视频",
      "pinyin": "wēi bó shì pín",
      "meaning": "Weibo video",
      "exampleSentence": "他在微博视频上发布了新片段。",
      "exampleSentencePinyin": "tā zài wēi bó shì pín shàng fā bù le xīn piàn duàn 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "怎么能",
      "pinyin": "zěn me néng",
      "meaning": "how can",
      "exampleSentence": "怎么能这样做？",
      "exampleSentencePinyin": "zěn me néng zhè yàng zuò ？",
      "pinyinSource": "library"
    },
    {
      "hanzi": "让一盘菜",
      "pinyin": "ràng yī pán cài",
      "meaning": "make a dish",
      "exampleSentence": "让一盘菜变得好吃。",
      "exampleSentencePinyin": "ràng yī pán cài biàn dé hǎo chī 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "从",
      "pinyin": "cóng",
      "meaning": "from",
      "exampleSentence": "这本书是从图书馆借的。",
      "exampleSentencePinyin": "zhè běn shū shì cóng tú shū guǎn jiè de 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "块钱",
      "pinyin": "kuài qián",
      "meaning": "yuan",
      "exampleSentence": "这件衣服只要几块钱。",
      "exampleSentencePinyin": "zhè jiàn yī fú zhǐ yào jǐ kuài qián。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "变成",
      "pinyin": "biàn chéng",
      "meaning": "become",
      "exampleSentence": "它慢慢变成了雨。",
      "exampleSentencePinyin": "tā màn màn biàn chéng le yǔ 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "呢",
      "pinyin": "ne",
      "meaning": "?",
      "exampleSentence": "你要干嘛呢？",
      "exampleSentencePinyin": "nǐ yào gàn má ne？",
      "pinyinSource": "library"
    },
    {
      "hanzi": "醉鹅娘超话",
      "pinyin": "zuì é niáng chāo huà",
      "meaning": "drunken goose lady hashtag",
      "exampleSentence": "他在醉鹅娘超话里发了动态。",
      "exampleSentencePinyin": "tā zài zuì é niáng chāo huà lǐ fā le dòng tài 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "醉鹅娘品味小知识",
      "pinyin": "zuì é niáng pǐn wèi xiǎo zhī shí",
      "meaning": "drunken goose lady taste small knowledge",
      "exampleSentence": "这篇文章是醉鹅娘品味小知识。",
      "exampleSentencePinyin": "zhè piān wén zhāng shì zuì é niáng pǐn wèi xiǎo zhī shí。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "鲜城",
      "pinyin": "xiān chéng",
      "meaning": "Fresh City",
      "exampleSentence": "我在鲜城点了外卖。",
      "exampleSentencePinyin": "wǒ zài xiān chéng diǎn le wài mài 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "元券",
      "pinyin": "yuán quàn",
      "meaning": "yuan coupon",
      "exampleSentence": "这个元券可以抵扣钱。",
      "exampleSentencePinyin": "zhè ge yuán quàn ké yǐ dǐ kòu qián 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "微博专享限时领券",
      "pinyin": "wēi bó zhuān xiǎng xiàn shí lǐng quàn",
      "meaning": "Weibo exclusive limited-time coupon",
      "exampleSentence": "微博专享限时领券活动开始了。",
      "exampleSentencePinyin": "wēi bó zhuān xiǎng xiàn shí lǐng quàn huó dòng kāi shǐ le 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "用券后价",
      "pinyin": "yòng quàn hòu jià",
      "meaning": "price after coupon",
      "exampleSentence": "用券后价是299元。",
      "exampleSentencePinyin": "yòng quàn hòu jià shì 299 yuán 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "醉鹅娘了不起鹅",
      "pinyin": "zuì é niáng liǎo bù qǐ é",
      "meaning": "drunken goose lady amazing goose",
      "exampleSentence": "醉鹅娘了不起鹅的产品很受欢迎。",
      "exampleSentencePinyin": "zuì é niáng liǎo bù qǐ é de chǎn pǐn hěn shòu huān yíng 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "诗芮鱼子酱",
      "pinyin": "shī ruì yú zi jiàng",
      "meaning": "Shi Rui caviar",
      "exampleSentence": "诗芮鱼子酱口感鲜美。",
      "exampleSentencePinyin": "shī ruì yú zi jiàng kǒu gǎn xiān měi 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "西伯利亚",
      "pinyin": "xī bó lì yà",
      "meaning": "Siberia",
      "exampleSentence": "西伯利亚的鱼子酱很贵。",
      "exampleSentencePinyin": "xī bó lì yà de yú zi jiàng hěn guì 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "礼盒装",
      "pinyin": "lǐ hé zhuāng",
      "meaning": "gift box packaging",
      "exampleSentence": "这个产品是礼盒装的。",
      "exampleSentencePinyin": "zhè ge chǎn pǐn shì lǐ hé zhuāng de 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "包邮",
      "pinyin": "bāo yóu",
      "meaning": "free shipping",
      "exampleSentence": "买这个商品包邮。",
      "exampleSentencePinyin": "mǎi zhè ge shāng pǐn bāo yóu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "笔成交",
      "pinyin": "bǐ chéng jiāo",
      "meaning": "transaction count",
      "exampleSentence": "这笔成交记录很高。",
      "exampleSentencePinyin": "zhè bǐ chéng jiāo jì lù hěn gāo 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "现价",
      "pinyin": "xiàn jià",
      "meaning": "current price",
      "exampleSentence": "现价是299元。",
      "exampleSentencePinyin": "xiàn jià shì 299 yuán 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "用券后",
      "pinyin": "yòng quàn hòu",
      "meaning": "after coupon",
      "exampleSentence": "用券后价格是299元。",
      "exampleSentencePinyin": "yòng quàn hòu jià gé shì 299 yuán 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "使用期限",
      "pinyin": "shǐ yòng qī xiàn",
      "meaning": "validity period",
      "exampleSentence": "使用期限到7月31日。",
      "exampleSentencePinyin": "shǐ yòng qī xiàn dào 7 yuè 31 rì 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "立即领券",
      "pinyin": "lì jí lǐng quàn",
      "meaning": "claim coupon now",
      "exampleSentence": "立即领券可以立减5元。",
      "exampleSentencePinyin": "lì jí lǐng quàn ké yǐ lì jiǎn 5 yuán 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "人",
      "pinyin": "rén",
      "meaning": "person",
      "exampleSentence": "这位人很友好。",
      "exampleSentencePinyin": "zhè wèi rén hěn yóu hǎo 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "赞过",
      "pinyin": "zàn guò",
      "meaning": "liked before",
      "exampleSentence": "他的帖子被赞过很多次。",
      "exampleSentencePinyin": "tā de tiě zi bèi zàn guò hěn duō cì 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "帮我选发货",
      "pinyin": "bāng wǒ xuǎn fā huò",
      "meaning": "help me choose shipping",
      "exampleSentence": "帮我选发货的快递。",
      "exampleSentencePinyin": "bāng wǒ xuǎn fā huò de kuài dì 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "四川成都快递",
      "pinyin": "sì chuān chéng dū kuài dì",
      "meaning": "Chengdu courier from Sichuan",
      "exampleSentence": "四川成都快递免运费。",
      "exampleSentencePinyin": "sì chuān chéng dū kuài dì miǎn yùn fèi 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "免运费",
      "pinyin": "miǎn yùn fèi",
      "meaning": "free shipping",
      "exampleSentence": "这个商品免运费。",
      "exampleSentencePinyin": "zhè ge shāng pǐn miǎn yùn fèi。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "月销",
      "pinyin": "yuè xiāo",
      "meaning": "monthly sales",
      "exampleSentence": "月销量超过1000件。",
      "exampleSentencePinyin": "yuè xiāo liàng chāo guò 1000 jiàn 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "加入购物车",
      "pinyin": "jiā rù gòu wù chē",
      "meaning": "add to cart",
      "exampleSentence": "请加入购物车。",
      "exampleSentencePinyin": "qǐng jiā rù gòu wù chē。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "领券",
      "pinyin": "lǐng quàn",
      "meaning": "claim coupon",
      "exampleSentence": "现在领券可以减5元。",
      "exampleSentencePinyin": "xiàn zài lǐng quàn ké yǐ jiǎn 5 yuán 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "购买",
      "pinyin": "gòu mǎi",
      "meaning": "purchase",
      "exampleSentence": "用户进行购买。",
      "exampleSentencePinyin": "yòng hù jìn xíng gòu mǎi。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "优惠券",
      "pinyin": "yōu huì quàn",
      "meaning": "discount coupon",
      "exampleSentence": "使用优惠券后价格更低。",
      "exampleSentencePinyin": "shǐ yòng yōu huì quàn hòu jià gé gèng dī 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "视频",
      "pinyin": "shì pín",
      "meaning": "video",
      "exampleSentence": "这个视频很有趣。",
      "exampleSentencePinyin": "zhè ge shì pín hěn yǒu qù 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "观看量",
      "pinyin": "guān kàn liàng",
      "meaning": "view count",
      "exampleSentence": "观看量达到20000次。",
      "exampleSentencePinyin": "guān kàn liàng dá dào 20000 cì 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "价格",
      "pinyin": "jià gé",
      "meaning": "price",
      "exampleSentence": "价格是299元。",
      "exampleSentencePinyin": "jià gé shì 299 yuán 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "服务",
      "pinyin": "fú wù",
      "meaning": "service",
      "exampleSentence": "提供良好服务。",
      "exampleSentencePinyin": "tí gōng liáng hǎo fú wù。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "发货",
      "pinyin": "fā huò",
      "meaning": "ship goods",
      "exampleSentence": "发货后会有物流信息。",
      "exampleSentencePinyin": "fā huò hòu huì yǒu wù liú xìn xī 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "快递",
      "pinyin": "kuài dì",
      "meaning": "courier",
      "exampleSentence": "快递送达很快。",
      "exampleSentencePinyin": "kuài dì sòng dá hěn kuài 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "成都",
      "pinyin": "chéng dū",
      "meaning": "Chengdu",
      "exampleSentence": "我在成都生活。",
      "exampleSentencePinyin": "wǒ zài chéng dū shēng huó 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "退货",
      "pinyin": "tuì huò",
      "meaning": "return goods",
      "exampleSentence": "如果不满意可以退货。",
      "exampleSentencePinyin": "rú guǒ bù mǎn yì ké yǐ tuì huò。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "保险",
      "pinyin": "bǎo xiǎn",
      "meaning": "insurance",
      "exampleSentence": "商品有保险覆盖。",
      "exampleSentencePinyin": "shāng pǐn yǒu bǎo xiǎn fù gài 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "生产日期",
      "pinyin": "shēng chǎn rì qī",
      "meaning": "production date",
      "exampleSentence": "生产日期是2020年。",
      "exampleSentencePinyin": "shēng chǎn rì qī shì 2020 nián 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "厂名",
      "pinyin": "chǎng míng",
      "meaning": "manufacturer name",
      "exampleSentence": "厂名标在包装上。",
      "exampleSentencePinyin": "chǎng míng biāo zài bāo zhuāng shàng 。",
      "pinyinSource": "library"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "粉丝福利购",
  "pinyin": "fěn sī fú lì gòu",
  "meaning": "fan welfare shopping (special benefits for fans)",
  "notes": "A marketing term used to describe exclusive discounts or perks offered to fans of a brand or celebrity.",
  "examples": [
    "粉丝福利购让粉丝们在新品发布会上抢购限量商品。",
    "这家店的粉丝福利购活动深受粉丝们喜爱。"
  ],
  "pinyinSource": "library"
}
```

## 20. weibo_kol_1.jpg | zh | baidu/qianfan-ocr-fast:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=200, latency=65.73s
- Explain endpoint: status=200, latency=7.16s

### Stages
- `vision extraction` via `baidu/qianfan-ocr-fast:free`: ok=True, attempts=1, latency=10.89s, prompt_tokens=4127, completion_tokens=892, total_tokens=5019, t/s=81.89
- `text analysis` via `nvidia/nemotron-3-nano-30b-a3b:free`: ok=True, attempts=1, latency=30.05s, prompt_tokens=1543, completion_tokens=8457, total_tokens=10000, t/s=281.44
- `glossary enrichment` via `nvidia/nemotron-3-nano-30b-a3b:free`: ok=True, attempts=1, latency=24.77s, prompt_tokens=1537, completion_tokens=6193, total_tokens=7730, t/s=250.06

### Vision Output
```json
{
  "documentText": "15:3315:3415:34 Search Weibo Weibo Following hot 粉丝福利购2626醉鹅娘醉鹅娘精品葡萄酒店5 Yesterday 19:25 from 微博视频怎么能让一碟菜从20块钱变成200块钱呢？醉鹅娘超话 #醉鹅娘品味小知识# @鲜城 【10元券】微博专享限时领券醉鹅娘的微博视频在礼盒后面有一个品鉴方法1010元券】微博专享限时领券用券后价：¥299.00领券20.3K views 4846 Weibo Video Discover Message Me 15:3415:34 Weibo Weibo 粉丝福利购2626醉鹅娘精品葡萄酒店510使用期限2019.06.24-2019.07.31立即领券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮2笔成交现价：¥309用券后 ¥299.00更多宝贝推荐优惠券 ¥5优惠券 ¥5顺风包邮101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回加入购物车领券购买用券后价 ¥299",
  "language": "zh-Hans",
  "readingLines": [],
  "pronunciationHints": [],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [
    {
      "hanzi": "怎么能让一碟菜从20块钱变成200块钱呢？",
      "translation": "How can a dish turn from 20 yuan to 200 yuan?",
      "tokens": [
        {
          "text": "怎么",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "能",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "让",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "一",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "碟",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "菜",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "从",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "20块钱",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "变",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "成",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "200块钱",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "呢",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "？",
          "kind": "punctuation",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "醉鹅娘超话 #醉鹅娘品味小知识#",
      "translation": "Crazy goose daughter topic #Crazy goose daughter little knowledge#",
      "tokens": [
        {
          "text": "醉鹅娘",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "超话",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "#",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "醉鹅娘品味小知识",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "#",
          "kind": "punctuation",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "【10元券】微博专享限时领券",
      "translation": "【10 yuan coupon】Exclusive limited-time coupon on Weibo",
      "tokens": [
        {
          "text": "【10元券】",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "微博",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "专享",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "限时",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "领券",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "用券后价：¥299.00",
      "translation": "Price after coupon: ¥299.00",
      "tokens": [
        {
          "text": "用券后价",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "：",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "¥299.00",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "粉丝福利购2626醉鹅娘精品葡萄酒店5",
      "translation": "Fans' welfare purchase: 2626 Crazy goose daughter premium wine hotel, item 5",
      "tokens": [
        {
          "text": "粉丝福利购",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "2626",
          "kind": "other",
          "meaning": null
        },
        {
          "text": "醉鹅娘",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "精品葡萄酒店",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "5",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "使用期限2019.06.24-2019.07.31立即领券",
      "translation": "Validity period: June 24 to July 31, 2019, claim coupon now",
      "tokens": [
        {
          "text": "使用期限",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "2019.06.24-2019.07.31",
          "kind": "other",
          "meaning": null
        },
        {
          "text": "立即领券",
          "kind": "phrase",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮",
      "translation": "Crazy goose daughter amazing goose × Poetry Rui caviar, 30g gift box, free shipping",
      "tokens": [
        {
          "text": "醉鹅娘了不起",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "鹅",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "x",
          "kind": "other",
          "meaning": null
        },
        {
          "text": "诗芮鱼子酱",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "西伯利亚",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "30g",
          "kind": "other",
          "meaning": null
        },
        {
          "text": "礼盒装",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "包邮",
          "kind": "phrase",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "现价：¥309用券后 ¥299.00",
      "translation": "Current price ¥309, after coupon ¥299.00",
      "tokens": [
        {
          "text": "现价",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "：",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "¥309",
          "kind": "other",
          "meaning": null
        },
        {
          "text": "用券后",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "¥299.00",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "更多宝贝推荐优惠券 ¥5优惠券 ¥5顺风包邮",
      "translation": "More items recommended: coupon ¥5, coupon ¥5 free shipping",
      "tokens": [
        {
          "text": "更多宝贝推荐",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "优惠券",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "¥5优惠券",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "¥5顺风包邮",
          "kind": "phrase",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "101领券下单立减5元",
      "translation": "Claim coupon, place order, save 5 yuan",
      "tokens": [
        {
          "text": "101领券下单立减5元",
          "kind": "phrase",
          "meaning": null
        }
      ]
    }
  ],
  "glossary": [
    {
      "text": "粉丝福利购",
      "meaning": null
    },
    {
      "text": "醉鹅娘",
      "meaning": null
    },
    {
      "text": "精品葡萄酒店",
      "meaning": null
    },
    {
      "text": "优惠券",
      "meaning": null
    },
    {
      "text": "领券",
      "meaning": null
    },
    {
      "text": "立减",
      "meaning": null
    },
    {
      "text": "使用期限",
      "meaning": null
    },
    {
      "text": "礼盒装",
      "meaning": null
    }
  ],
  "pronunciationHints": []
}
```

### Glossary Enrichment Output
```json
{
  "entries": [
    {
      "text": "怎么",
      "literalMeaning": "how",
      "exampleSentence": "怎么这么贵？"
    },
    {
      "text": "能",
      "literalMeaning": "can",
      "exampleSentence": "能帮忙吗？"
    },
    {
      "text": "让",
      "literalMeaning": "let",
      "exampleSentence": "让我试试。"
    },
    {
      "text": "一",
      "literalMeaning": "one",
      "exampleSentence": "这是一本书。"
    },
    {
      "text": "碟",
      "literalMeaning": "plate",
      "exampleSentence": "一碟菜。"
    },
    {
      "text": "菜",
      "literalMeaning": "dish",
      "exampleSentence": "这道菜很好吃。"
    },
    {
      "text": "从",
      "literalMeaning": "from",
      "exampleSentence": "从今天开始。"
    },
    {
      "text": "块钱",
      "literalMeaning": "some money",
      "exampleSentence": "块钱不多。"
    },
    {
      "text": "变",
      "literalMeaning": "change",
      "exampleSentence": "颜色变了。"
    },
    {
      "text": "成",
      "literalMeaning": "become",
      "exampleSentence": "变成了。"
    },
    {
      "text": "呢",
      "literalMeaning": "?",
      "exampleSentence": "怎么呢？"
    },
    {
      "text": "醉鹅娘",
      "literalMeaning": "drunk goose girl",
      "exampleSentence": "醉鹅娘的视频很火。"
    },
    {
      "text": "超话",
      "literalMeaning": "super topic",
      "exampleSentence": "超话里很热闹。"
    },
    {
      "text": "醉鹅娘品味小知识",
      "literalMeaning": "drunk goose girl tasting little knowledge",
      "exampleSentence": "醉鹅娘品味小知识分享。"
    },
    {
      "text": "元券",
      "literalMeaning": "yuan coupon",
      "exampleSentence": "元券可以抵扣。"
    },
    {
      "text": "微博",
      "literalMeaning": "Weibo",
      "exampleSentence": "微博上很热门。"
    },
    {
      "text": "专享",
      "literalMeaning": "exclusive",
      "exampleSentence": "专享优惠。"
    },
    {
      "text": "限时",
      "literalMeaning": "limited time",
      "exampleSentence": "限时促销。"
    },
    {
      "text": "领券",
      "literalMeaning": "redeem coupon",
      "exampleSentence": "领券后可用。"
    },
    {
      "text": "用券后价",
      "literalMeaning": "price after coupon",
      "exampleSentence": "用券后价更低。"
    },
    {
      "text": "粉丝福利购",
      "literalMeaning": "fan benefit purchase",
      "exampleSentence": "粉丝福利购活动。"
    },
    {
      "text": "精品葡萄酒店",
      "literalMeaning": "premium wine hotel",
      "exampleSentence": "精品葡萄酒店很受欢迎。"
    },
    {
      "text": "使用期限",
      "literalMeaning": "usage period",
      "exampleSentence": "使用期限到月底。"
    },
    {
      "text": "立即领券",
      "literalMeaning": "redeem immediately",
      "exampleSentence": "立即领券可享。"
    },
    {
      "text": "醉鹅娘了不起",
      "literalMeaning": "drunk goose girl is amazing",
      "exampleSentence": "醉鹅娘了不起的表演。"
    },
    {
      "text": "鹅",
      "literalMeaning": "goose",
      "exampleSentence": "一只鹅。"
    },
    {
      "text": "诗芮鱼子酱",
      "literalMeaning": "Poerui caviar",
      "exampleSentence": "诗芮鱼子酱很贵。"
    },
    {
      "text": "西伯利亚",
      "literalMeaning": "Siberia",
      "exampleSentence": "西伯利亚寒冷。"
    },
    {
      "text": "礼盒装",
      "literalMeaning": "gift box packed",
      "exampleSentence": "礼盒装送礼。"
    },
    {
      "text": "包邮",
      "literalMeaning": "free shipping",
      "exampleSentence": "包邮服务。"
    },
    {
      "text": "现价",
      "literalMeaning": "current price",
      "exampleSentence": "现价是多少？"
    },
    {
      "text": "用券后",
      "literalMeaning": "after coupon",
      "exampleSentence": "用券后价格。"
    },
    {
      "text": "更多宝贝推荐",
      "literalMeaning": "more product recommendations",
      "exampleSentence": "更多宝贝推荐供你。"
    },
    {
      "text": "优惠券",
      "literalMeaning": "discount coupon",
      "exampleSentence": "优惠券可用。"
    },
    {
      "text": "顺风包邮",
      "literalMeaning": "free shipping with tailwind",
      "exampleSentence": "顺风包邮免费。"
    },
    {
      "text": "领券下单立减",
      "literalMeaning": "redeem coupon, place order, discount",
      "exampleSentence": "领券下单立减5元。"
    },
    {
      "text": "元",
      "literalMeaning": "yuan",
      "exampleSentence": "一元钱。"
    },
    {
      "text": "立减",
      "literalMeaning": "direct reduction",
      "exampleSentence": "立减5元。"
    }
  ]
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "15:3315:3415:34 Search Weibo Weibo Following hot 粉丝福利购2626醉鹅娘醉鹅娘精品葡萄酒店5 Yesterday 19:25 from 微博视频怎么能让一碟菜从20块钱变成200块钱呢？醉鹅娘超话 #醉鹅娘品味小知识# @鲜城 【10元券】微博专享限时领券醉鹅娘的微博视频在礼盒后面有一个品鉴方法1010元券】微博专享限时领券用券后价：¥299.00领券20.3K views 4846 Weibo Video Discover Message Me 15:3415:34 Weibo Weibo 粉丝福利购2626醉鹅娘精品葡萄酒店510使用期限2019.06.24-2019.07.31立即领券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装包邮2笔成交现价：¥309用券后 ¥299.00更多宝贝推荐优惠券 ¥5优惠券 ¥5顺风包邮101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回101领券下单立减5元188元收藏加购送开罐礼新人礼送50g鲟鱼肉卡露伽黑鱼子酱西伯利亚鲟鱼籽酱... 106.001697笔成交用券后 ¥98.00优惠券 ¥5领取鱼子酱7年生西伯利亚鲟鱼籽酱即食黑鱼子酱罐头1... 106.00484笔成交用券后 ¥101.00优惠券 ¥5领取309惠淘价价格 ¥339领券后预计减10元满699减30店铺优惠券醉鹅娘了不起鹅 x 诗芮鱼子酱西伯利亚30g 礼盒装2人赞过帮我选发货四川成都快递：免运费月销3服务7天内发货·坏单包赔·订单险生产日期厂名... 返回加入购物车领券购买用券后价 ¥299",
  "language": "zh-Hans",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "怎么能让一碟菜从块钱变成块钱呢？",
      "pinyin": "zěn me néng ràng yī dié cài cóng kuài qián biàn chéng kuài qián ne？",
      "translation": "How can a dish turn from 20 yuan to 200 yuan?",
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "怎么",
          "pinyin": "zěn me",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t2",
          "hanzi": "能",
          "pinyin": "néng",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t3",
          "hanzi": "让",
          "pinyin": "ràng",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t4",
          "hanzi": "一",
          "pinyin": "yī",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t5",
          "hanzi": "碟",
          "pinyin": "dié",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t6",
          "hanzi": "菜",
          "pinyin": "cài",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t7",
          "hanzi": "从",
          "pinyin": "cóng",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t8",
          "hanzi": "块钱",
          "pinyin": "kuài qián",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t9",
          "hanzi": "变",
          "pinyin": "biàn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t10",
          "hanzi": "成",
          "pinyin": "chéng",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t11",
          "hanzi": "块钱",
          "pinyin": "kuài qián",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t12",
          "hanzi": "呢",
          "pinyin": "ne",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t13",
          "hanzi": "？",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "醉鹅娘超话醉鹅娘品味小知识",
      "pinyin": "zuì é niáng chāo huà zuì é niáng pǐn wèi xiǎo zhī shí",
      "translation": "Crazy goose daughter topic #Crazy goose daughter little knowledge#",
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "醉鹅娘",
          "pinyin": "zuì é niáng",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t2",
          "hanzi": "超话",
          "pinyin": "chāo huà",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t3",
          "hanzi": "醉鹅娘品味小知识",
          "pinyin": "zuì é niáng pǐn wèi xiǎo zhī shí",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "元券微博专享限时领券",
      "pinyin": "yuán quàn wēi bó zhuān xiǎng xiàn shí lǐng quàn",
      "translation": "【10 yuan coupon】Exclusive limited-time coupon on Weibo",
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "元券",
          "pinyin": "yuán quàn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t2",
          "hanzi": "微博",
          "pinyin": "wēi bó",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t3",
          "hanzi": "专享",
          "pinyin": "zhuān xiǎng",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t4",
          "hanzi": "限时",
          "pinyin": "xiàn shí",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t5",
          "hanzi": "领券",
          "pinyin": "lǐng quàn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s4",
      "hanzi": "用券后价",
      "pinyin": "yòng quàn hòu jià",
      "translation": "Price after coupon: ¥299.00",
      "tokens": [
        {
          "id": "s4-t1",
          "hanzi": "用券后价",
          "pinyin": "yòng quàn hòu jià",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s5",
      "hanzi": "粉丝福利购醉鹅娘精品葡萄酒店",
      "pinyin": "fěn sī fú lì gòu zuì é niáng jīng pǐn pú táo jiǔ diàn",
      "translation": "Fans' welfare purchase: 2626 Crazy goose daughter premium wine hotel, item 5",
      "tokens": [
        {
          "id": "s5-t1",
          "hanzi": "粉丝福利购",
          "pinyin": "fěn sī fú lì gòu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t2",
          "hanzi": "醉鹅娘",
          "pinyin": "zuì é niáng",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t3",
          "hanzi": "精品葡萄酒店",
          "pinyin": "jīng pǐn pú táo jiǔ diàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s6",
      "hanzi": "使用期限立即领券",
      "pinyin": "shǐ yòng qī xiàn lì jí lǐng quàn",
      "translation": "Validity period: June 24 to July 31, 2019, claim coupon now",
      "tokens": [
        {
          "id": "s6-t1",
          "hanzi": "使用期限",
          "pinyin": "shǐ yòng qī xiàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t2",
          "hanzi": "立即领券",
          "pinyin": "lì jí lǐng quàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s7",
      "hanzi": "醉鹅娘了不起鹅诗芮鱼子酱西伯利亚礼盒装包邮",
      "pinyin": "zuì é niáng liǎo bù qǐ é shī ruì yú zi jiàng xī bó lì yà lǐ hé zhuāng bāo yóu",
      "translation": "Crazy goose daughter amazing goose × Poetry Rui caviar, 30g gift box, free shipping",
      "tokens": [
        {
          "id": "s7-t1",
          "hanzi": "醉鹅娘了不起",
          "pinyin": "zuì é niáng liǎo bù qǐ",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t2",
          "hanzi": "鹅",
          "pinyin": "é",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t3",
          "hanzi": "诗芮鱼子酱",
          "pinyin": "shī ruì yú zi jiàng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t4",
          "hanzi": "西伯利亚",
          "pinyin": "xī bó lì yà",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t5",
          "hanzi": "礼盒装",
          "pinyin": "lǐ hé zhuāng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t6",
          "hanzi": "包邮",
          "pinyin": "bāo yóu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s8",
      "hanzi": "现价：用券后",
      "pinyin": "xiàn jià： yòng quàn hòu",
      "translation": "Current price ¥309, after coupon ¥299.00",
      "tokens": [
        {
          "id": "s8-t1",
          "hanzi": "现价",
          "pinyin": "xiàn jià",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t2",
          "hanzi": "：",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t3",
          "hanzi": "用券后",
          "pinyin": "yòng quàn hòu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s9",
      "hanzi": "更多宝贝推荐优惠券优惠券顺风包邮",
      "pinyin": "gèng duō bǎo bèi tuī jiàn yōu huì quàn yōu huì quàn shùn fēng bāo yóu",
      "translation": "More items recommended: coupon ¥5, coupon ¥5 free shipping",
      "tokens": [
        {
          "id": "s9-t1",
          "hanzi": "更多宝贝推荐",
          "pinyin": "gèng duō bǎo bèi tuī jiàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t2",
          "hanzi": "优惠券",
          "pinyin": "yōu huì quàn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t3",
          "hanzi": "优惠券",
          "pinyin": "yōu huì quàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t4",
          "hanzi": "顺风包邮",
          "pinyin": "shùn fēng bāo yóu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s10",
      "hanzi": "领券下单立减元",
      "pinyin": "lǐng quàn xià dān lì jiǎn yuán",
      "translation": "Claim coupon, place order, save 5 yuan",
      "tokens": [
        {
          "id": "s10-t1",
          "hanzi": "领券下单立减",
          "pinyin": "lǐng quàn xià dān lì jiǎn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t2",
          "hanzi": "元",
          "pinyin": "yuán",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "怎么",
      "pinyin": "zěn me",
      "meaning": "how",
      "exampleSentence": "怎么这么贵？",
      "exampleSentencePinyin": "zěn me zhè me guì ？",
      "pinyinSource": "library"
    },
    {
      "hanzi": "能",
      "pinyin": "néng",
      "meaning": "can",
      "exampleSentence": "能帮忙吗？",
      "exampleSentencePinyin": "néng bāng máng ma ？",
      "pinyinSource": "library"
    },
    {
      "hanzi": "让",
      "pinyin": "ràng",
      "meaning": "let",
      "exampleSentence": "让我试试。",
      "exampleSentencePinyin": "ràng wǒ shì shì 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "一",
      "pinyin": "yī",
      "meaning": "one",
      "exampleSentence": "这是一本书。",
      "exampleSentencePinyin": "zhè shì yī běn shū 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "碟",
      "pinyin": "dié",
      "meaning": "plate",
      "exampleSentence": "一碟菜。",
      "exampleSentencePinyin": "yī dié cài 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "菜",
      "pinyin": "cài",
      "meaning": "dish",
      "exampleSentence": "这道菜很好吃。",
      "exampleSentencePinyin": "zhè dào cài hěn hǎo chī 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "从",
      "pinyin": "cóng",
      "meaning": "from",
      "exampleSentence": "从今天开始。",
      "exampleSentencePinyin": "cóng jīn tiān kāi shǐ 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "块钱",
      "pinyin": "kuài qián",
      "meaning": "some money",
      "exampleSentence": "块钱不多。",
      "exampleSentencePinyin": "kuài qián bù duō 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "变",
      "pinyin": "biàn",
      "meaning": "change",
      "exampleSentence": "颜色变了。",
      "exampleSentencePinyin": "yán sè biàn le 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "成",
      "pinyin": "chéng",
      "meaning": "become",
      "exampleSentence": "变成了。",
      "exampleSentencePinyin": "biàn chéng le 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "呢",
      "pinyin": "ne",
      "meaning": "?",
      "exampleSentence": "怎么呢？",
      "exampleSentencePinyin": "zěn me ne？",
      "pinyinSource": "library"
    },
    {
      "hanzi": "醉鹅娘",
      "pinyin": "zuì é niáng",
      "meaning": "drunk goose girl",
      "exampleSentence": "醉鹅娘的视频很火。",
      "exampleSentencePinyin": "zuì é niáng de shì pín hěn huǒ 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "超话",
      "pinyin": "chāo huà",
      "meaning": "super topic",
      "exampleSentence": "超话里很热闹。",
      "exampleSentencePinyin": "chāo huà lǐ hěn rè nào 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "醉鹅娘品味小知识",
      "pinyin": "zuì é niáng pǐn wèi xiǎo zhī shí",
      "meaning": "drunk goose girl tasting little knowledge",
      "exampleSentence": "醉鹅娘品味小知识分享。",
      "exampleSentencePinyin": "zuì é niáng pǐn wèi xiǎo zhī shí fēn xiǎng 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "元券",
      "pinyin": "yuán quàn",
      "meaning": "yuan coupon",
      "exampleSentence": "元券可以抵扣。",
      "exampleSentencePinyin": "yuán quàn ké yǐ dǐ kòu 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "微博",
      "pinyin": "wēi bó",
      "meaning": "Weibo",
      "exampleSentence": "微博上很热门。",
      "exampleSentencePinyin": "wēi bó shàng hěn rè mén 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "专享",
      "pinyin": "zhuān xiǎng",
      "meaning": "exclusive",
      "exampleSentence": "专享优惠。",
      "exampleSentencePinyin": "zhuān xiǎng yōu huì 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "限时",
      "pinyin": "xiàn shí",
      "meaning": "limited time",
      "exampleSentence": "限时促销。",
      "exampleSentencePinyin": "xiàn shí cù xiāo 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "领券",
      "pinyin": "lǐng quàn",
      "meaning": "redeem coupon",
      "exampleSentence": "领券后可用。",
      "exampleSentencePinyin": "lǐng quàn hòu kě yòng 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "用券后价",
      "pinyin": "yòng quàn hòu jià",
      "meaning": "price after coupon",
      "exampleSentence": "用券后价更低。",
      "exampleSentencePinyin": "yòng quàn hòu jià gèng dī 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "粉丝福利购",
      "pinyin": "fěn sī fú lì gòu",
      "meaning": "fan benefit purchase",
      "exampleSentence": "粉丝福利购活动。",
      "exampleSentencePinyin": "fěn sī fú lì gòu huó dòng 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "精品葡萄酒店",
      "pinyin": "jīng pǐn pú táo jiǔ diàn",
      "meaning": "premium wine hotel",
      "exampleSentence": "精品葡萄酒店很受欢迎。",
      "exampleSentencePinyin": "jīng pǐn pú táo jiǔ diàn hěn shòu huān yíng 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "使用期限",
      "pinyin": "shǐ yòng qī xiàn",
      "meaning": "usage period",
      "exampleSentence": "使用期限到月底。",
      "exampleSentencePinyin": "shǐ yòng qī xiàn dào yuè dǐ 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "立即领券",
      "pinyin": "lì jí lǐng quàn",
      "meaning": "redeem immediately",
      "exampleSentence": "立即领券可享。",
      "exampleSentencePinyin": "lì jí lǐng quàn kě xiǎng 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "醉鹅娘了不起",
      "pinyin": "zuì é niáng liǎo bù qǐ",
      "meaning": "drunk goose girl is amazing",
      "exampleSentence": "醉鹅娘了不起的表演。",
      "exampleSentencePinyin": "zuì é niáng liǎo bù qǐ de biǎo yǎn 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "鹅",
      "pinyin": "é",
      "meaning": "goose",
      "exampleSentence": "一只鹅。",
      "exampleSentencePinyin": "yì zhī é。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "诗芮鱼子酱",
      "pinyin": "shī ruì yú zi jiàng",
      "meaning": "Poerui caviar",
      "exampleSentence": "诗芮鱼子酱很贵。",
      "exampleSentencePinyin": "shī ruì yú zi jiàng hěn guì 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "西伯利亚",
      "pinyin": "xī bó lì yà",
      "meaning": "Siberia",
      "exampleSentence": "西伯利亚寒冷。",
      "exampleSentencePinyin": "xī bó lì yà hán lěng 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "礼盒装",
      "pinyin": "lǐ hé zhuāng",
      "meaning": "gift box packed",
      "exampleSentence": "礼盒装送礼。",
      "exampleSentencePinyin": "lǐ hé zhuāng sòng lǐ 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "包邮",
      "pinyin": "bāo yóu",
      "meaning": "free shipping",
      "exampleSentence": "包邮服务。",
      "exampleSentencePinyin": "bāo yóu fú wù 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "现价",
      "pinyin": "xiàn jià",
      "meaning": "current price",
      "exampleSentence": "现价是多少？",
      "exampleSentencePinyin": "xiàn jià shì duō shǎo ？",
      "pinyinSource": "library"
    },
    {
      "hanzi": "用券后",
      "pinyin": "yòng quàn hòu",
      "meaning": "after coupon",
      "exampleSentence": "用券后价格。",
      "exampleSentencePinyin": "yòng quàn hòu jià gé 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "更多宝贝推荐",
      "pinyin": "gèng duō bǎo bèi tuī jiàn",
      "meaning": "more product recommendations",
      "exampleSentence": "更多宝贝推荐供你。",
      "exampleSentencePinyin": "gèng duō bǎo bèi tuī jiàn gōng nǐ 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "优惠券",
      "pinyin": "yōu huì quàn",
      "meaning": "discount coupon",
      "exampleSentence": "优惠券可用。",
      "exampleSentencePinyin": "yōu huì quàn kě yòng 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "顺风包邮",
      "pinyin": "shùn fēng bāo yóu",
      "meaning": "free shipping with tailwind",
      "exampleSentence": "顺风包邮免费。",
      "exampleSentencePinyin": "shùn fēng bāo yóu miǎn fèi 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "领券下单立减",
      "pinyin": "lǐng quàn xià dān lì jiǎn",
      "meaning": "redeem coupon, place order, discount",
      "exampleSentence": "领券下单立减5元。",
      "exampleSentencePinyin": "lǐng quàn xià dān lì jiǎn 5 yuán 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "元",
      "pinyin": "yuán",
      "meaning": "yuan",
      "exampleSentence": "一元钱。",
      "exampleSentencePinyin": "yī yuán qián 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "立减",
      "pinyin": "lì jiǎn",
      "meaning": "direct reduction",
      "exampleSentence": "立减5元。",
      "exampleSentencePinyin": "lì jiǎn 5 yuán 。",
      "pinyinSource": "library"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "怎么",
  "pinyin": "zěn me",
  "meaning": "how; way; manner",
  "notes": "Used to ask about the method or reason; often appears at the start of questions.",
  "examples": [
    "你怎么去图书馆？",
    "他怎么会在这里？"
  ],
  "pinyinSource": "library"
}
```

## 21. 1730196408827jp.png | auto | qwen/qwen3-vl-30b-a3b-instruct + inclusionai/ling-2.6-flash:free

- Expected primary language: `ja`
- Analyze endpoint: status=502, latency=0.63s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.62s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 22. 1730196408827jp.png | ja | qwen/qwen3-vl-30b-a3b-instruct + inclusionai/ling-2.6-flash:free

- Expected primary language: `ja`
- Analyze endpoint: status=502, latency=0.69s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.68s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 23. o08000924109524428441jp.jpg | auto | qwen/qwen3-vl-30b-a3b-instruct + inclusionai/ling-2.6-flash:free

- Expected primary language: `ja`
- Analyze endpoint: status=502, latency=0.39s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.38s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 24. o08000924109524428441jp.jpg | ja | qwen/qwen3-vl-30b-a3b-instruct + inclusionai/ling-2.6-flash:free

- Expected primary language: `ja`
- Analyze endpoint: status=502, latency=0.31s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.30s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 25. The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | auto | qwen/qwen3-vl-30b-a3b-instruct + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=0.49s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.48s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 26. The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | qwen/qwen3-vl-30b-a3b-instruct + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=0.39s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.39s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 27. weibo_6_toutiao_comparison.jpg | auto | qwen/qwen3-vl-30b-a3b-instruct + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=0.46s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.46s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 28. weibo_6_toutiao_comparison.jpg | zh | qwen/qwen3-vl-30b-a3b-instruct + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=0.45s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.45s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 29. weibo_kol_1.jpg | auto | qwen/qwen3-vl-30b-a3b-instruct + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=0.35s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.34s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 30. weibo_kol_1.jpg | zh | qwen/qwen3-vl-30b-a3b-instruct + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=0.29s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.29s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 31. 1730196408827jp.png | auto | qwen/qwen3-vl-30b-a3b-instruct + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `ja`
- Analyze endpoint: status=502, latency=0.59s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.59s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 32. 1730196408827jp.png | ja | qwen/qwen3-vl-30b-a3b-instruct + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `ja`
- Analyze endpoint: status=502, latency=0.50s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.49s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 33. o08000924109524428441jp.jpg | auto | qwen/qwen3-vl-30b-a3b-instruct + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `ja`
- Analyze endpoint: status=502, latency=0.51s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.51s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 34. o08000924109524428441jp.jpg | ja | qwen/qwen3-vl-30b-a3b-instruct + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `ja`
- Analyze endpoint: status=502, latency=0.30s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.30s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 35. The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | auto | qwen/qwen3-vl-30b-a3b-instruct + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=0.36s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.36s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 36. The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | qwen/qwen3-vl-30b-a3b-instruct + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=0.48s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.48s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 37. weibo_6_toutiao_comparison.jpg | auto | qwen/qwen3-vl-30b-a3b-instruct + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=0.43s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.42s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 38. weibo_6_toutiao_comparison.jpg | zh | qwen/qwen3-vl-30b-a3b-instruct + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=0.39s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.39s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 39. weibo_kol_1.jpg | auto | qwen/qwen3-vl-30b-a3b-instruct + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=0.43s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.43s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 40. weibo_kol_1.jpg | zh | qwen/qwen3-vl-30b-a3b-instruct + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=0.42s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `qwen/qwen3-vl-30b-a3b-instruct`: ok=False, attempts=1, latency=0.41s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: OpenRouter returned an error response: {"error":{"message":"Key limit exceeded (total limit). Manage it using https://openrouter.ai/settings/keys","code":403}}

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 41. 1730196408827jp.png | auto | nvidia/nemotron-nano-12b-v2-vl:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `ja`
- Analyze endpoint: status=200, latency=242.68s
- Explain endpoint: status=200, latency=1.31s

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=True, attempts=1, latency=80.41s, prompt_tokens=1682, completion_tokens=5097, total_tokens=6779, t/s=63.38
- `text analysis` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=156.48s, prompt_tokens=587, completion_tokens=32768, total_tokens=33355, t/s=209.41
- `glossary enrichment` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=5.78s, prompt_tokens=534, completion_tokens=1078, total_tokens=1612, t/s=186.55

### Vision Output
```json
{
  "documentText": "",
  "language": "ja",
  "readingLines": [
    "ヘブンバーンズレッド公式 @heavenburnsred Follow",
    "公式4コマ漫画【ヘブンバン劇場】 第108話「のろけ」",
    "シャロの撮影技術はすごい！",
    "今までのお話はこちら→x.com/heavenburnsred...",
    "作画:津留崎優 @hatori_niwatoriさん",
    "#ヘブンバン #ヘブンバン劇場",
    "1:00 PM · Sep 15, 2024",
    "4.1K",
    "Reply",
    "Copy link",
    "Read 29 replies",
    "ガーディアンテールズ公式 @GuardianTalesJP Follow",
    "【かんたべりーでぃいず！】 ガーディアンテールズの4コマ漫画 #かんたべりーでぃいずの第140話「コンビニは今日も平和です」を公開！",
    "作者：純粋な不純物(@parang9494)先生",
    "#ガーディアンテールズ #ガデテル",
    "5:00 PM · Sep 6, 2024",
    "1K",
    "Reply",
    "Copy link",
    "Read 5 replies"
  ],
  "pronunciationHints": [],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [],
  "glossary": [],
  "pronunciationHints": []
}
```

### Glossary Enrichment Output
```json
{
  "entries": [
    {
      "text": "ヘブンバーンズレッド公式', 'literalMeaning': 'Heaven Burns Red Official', 'exampleSentence': 'ヘブンバーンズレッド公式サイトで最新情報を確認してください。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "公式', 'literalMeaning': 'Official', 'exampleSentence': 'これは公式な発表です。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "コマ漫画', 'literalMeaning': 'Manga panel', 'exampleSentence': 'このコマ漫画は笑いを誘います。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ヘブンバン劇場', 'literalMeaning': 'Heaven Burns Theater', 'exampleSentence': 'ヘブンバン劇場でのイベントが開催されます。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "第', 'literalMeaning': 'Number', 'exampleSentence': '第1話は衝撃的な展開です。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "話', 'literalMeaning': 'Episode / Story', 'exampleSentence': '新しい話が始まりました。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "のろけ', 'literalMeaning': 'Lovelorn', 'exampleSentence': '彼女のことをのろけている様子。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "シャロの撮影技術はすごい', 'literalMeaning': 'Sharo’s photography skills are amazing', 'exampleSentence': 'シャロの撮影技術はすごいです。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "今までのお話はこちら', 'literalMeaning': 'Here are the stories so far', 'exampleSentence': '今までのお話はこちらをご覧ください。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "作画', 'literalMeaning': 'Drawing / Artwork', 'exampleSentence': 'この作画は美しいです。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "津留崎優', 'literalMeaning': 'Tsurusaki Yu', 'exampleSentence': '津留崎優が新しい作品を発表しました。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "さん', 'literalMeaning': 'Mr. / Ms.', 'exampleSentence': '田中さんはお会いできて嬉しいです。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ヘブンバン', 'literalMeaning': 'Heaven Burns', 'exampleSentence': 'ヘブンバンの魅力を再確認しました。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ガーディアンテールズ公式', 'literalMeaning': 'Guardian Tales Official', 'exampleSentence': 'ガーディアンテールズ公式Twitterをフォローしてください。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "かんたべりーでぃいず', 'literalMeaning': 'Kantabe Rīzu', 'exampleSentence': 'かんたべりーでぃいずの商品が発売です。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ガーディアンテールズの', 'literalMeaning': 'Of Guardian Tales', 'exampleSentence':",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "かんたべりーでぃいずの第', 'literalMeaning': 'The number of Kantabe Rīzu', 'exampleSentence': 'かんたべりーでぃいずの第3弾です。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "コンビニは今日も平和です', 'literalMeaning': 'The convenience store is peaceful today too', 'exampleSentence': 'コンビニは今日も平和です。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "を公開', 'literalMeaning': 'To publish / Release', 'exampleSentence': '本稿を公開いたします。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "作者', 'literalMeaning': 'Author', 'exampleSentence': '作者のインタビューを読む。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "純粋な不純物', 'literalMeaning': 'Pure impurity', 'exampleSentence': '純粋な不純物を含む化合物です。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "先生', 'literalMeaning': 'Teacher / Doctor', 'exampleSentence': '先生のご指導に感謝しています。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ガーディアンテールズ', 'literalMeaning': 'Guardian Tales', 'exampleSentence': 'ガーディアンテールズは人気ゲームです。'",
      "literalMeaning": null,
      "exampleSentence": null
    },
    {
      "text": "ガデテル', 'literalMeaning': 'Guarder', 'exampleSentence': 'ガデテルの機能を紹介しましょう。'",
      "literalMeaning": null,
      "exampleSentence": null
    }
  ]
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "",
  "language": "ja",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "ヘブンバーンズレッド公式",
      "pinyin": "hebunbaanzureddo公式",
      "translation": null,
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "ヘブンバーンズレッド公式",
          "pinyin": "hebunbaanzureddo公式",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "公式コマ漫画ヘブンバン劇場第話のろけ",
      "pinyin": "公式 koma漫画 hebunban劇場 第 話 noroke",
      "translation": null,
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "公式",
          "pinyin": "公式",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t2",
          "hanzi": "コマ漫画",
          "pinyin": "koma漫画",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t3",
          "hanzi": "ヘブンバン劇場",
          "pinyin": "hebunban劇場",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t4",
          "hanzi": "第",
          "pinyin": "第",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t5",
          "hanzi": "話",
          "pinyin": "話",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t6",
          "hanzi": "のろけ",
          "pinyin": "noroke",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "シャロの撮影技術はすごい！",
      "pinyin": "sharono撮影技術hasugoi！",
      "translation": null,
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "シャロの撮影技術はすごい",
          "pinyin": "sharono撮影技術hasugoi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s4",
      "hanzi": "今までのお話はこちら",
      "pinyin": "今madenoo話hakochira",
      "translation": null,
      "tokens": [
        {
          "id": "s4-t1",
          "hanzi": "今までのお話はこちら",
          "pinyin": "今madenoo話hakochira",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s5",
      "hanzi": "作画:津留崎優さん",
      "pinyin": "作画: 津留崎優 san",
      "translation": null,
      "tokens": [
        {
          "id": "s5-t1",
          "hanzi": "作画",
          "pinyin": "作画",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t2",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t3",
          "hanzi": "津留崎優",
          "pinyin": "津留崎優",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t4",
          "hanzi": "さん",
          "pinyin": "san",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s6",
      "hanzi": "ヘブンバンヘブンバン劇場",
      "pinyin": "hebunban hebunban劇場",
      "translation": null,
      "tokens": [
        {
          "id": "s6-t1",
          "hanzi": "ヘブンバン",
          "pinyin": "hebunban",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t2",
          "hanzi": "ヘブンバン劇場",
          "pinyin": "hebunban劇場",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s7",
      "hanzi": "ガーディアンテールズ公式",
      "pinyin": "gaadianteeruzu公式",
      "translation": null,
      "tokens": [
        {
          "id": "s7-t1",
          "hanzi": "ガーディアンテールズ公式",
          "pinyin": "gaadianteeruzu公式",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s8",
      "hanzi": "かんたべりーでぃいず！",
      "pinyin": "kantaberiidiizu！",
      "translation": null,
      "tokens": [
        {
          "id": "s8-t1",
          "hanzi": "かんたべりーでぃいず",
          "pinyin": "kantaberiidiizu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s9",
      "hanzi": "ガーディアンテールズのコマ漫画かんたべりーでぃいずの第話コンビニは今日も平和ですを公開！",
      "pinyin": "gaadianteeruzuno koma漫画 kantaberiidiizuno第 話 konbiniha今日mo平和desu wo公開！",
      "translation": null,
      "tokens": [
        {
          "id": "s9-t1",
          "hanzi": "ガーディアンテールズの",
          "pinyin": "gaadianteeruzuno",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t2",
          "hanzi": "コマ漫画",
          "pinyin": "koma漫画",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t3",
          "hanzi": "かんたべりーでぃいずの第",
          "pinyin": "kantaberiidiizuno第",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t4",
          "hanzi": "話",
          "pinyin": "話",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t5",
          "hanzi": "コンビニは今日も平和です",
          "pinyin": "konbiniha今日mo平和desu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t6",
          "hanzi": "を公開",
          "pinyin": "wo公開",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t7",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s10",
      "hanzi": "作者：純粋な不純物()先生",
      "pinyin": "作者： 純粋na不純物() 先生",
      "translation": null,
      "tokens": [
        {
          "id": "s10-t1",
          "hanzi": "作者",
          "pinyin": "作者",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t2",
          "hanzi": "：",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t3",
          "hanzi": "純粋な不純物",
          "pinyin": "純粋na不純物",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t4",
          "hanzi": "(",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t5",
          "hanzi": ")",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t6",
          "hanzi": "先生",
          "pinyin": "先生",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s11",
      "hanzi": "ガーディアンテールズガデテル",
      "pinyin": "gaadianteeruzu gadeteru",
      "translation": null,
      "tokens": [
        {
          "id": "s11-t1",
          "hanzi": "ガーディアンテールズ",
          "pinyin": "gaadianteeruzu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t2",
          "hanzi": "ガデテル",
          "pinyin": "gadeteru",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "ヘブンバーンズレッド公式",
      "pinyin": "hebunbaanzureddo公式",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "公式",
      "pinyin": "公式",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "コマ漫画",
      "pinyin": "koma漫画",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ヘブンバン劇場",
      "pinyin": "hebunban劇場",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "第",
      "pinyin": "第",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "話",
      "pinyin": "話",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "のろけ",
      "pinyin": "noroke",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "シャロの撮影技術はすごい",
      "pinyin": "sharono撮影技術hasugoi",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "今までのお話はこちら",
      "pinyin": "今madenoo話hakochira",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "作画",
      "pinyin": "作画",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "津留崎優",
      "pinyin": "津留崎優",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "さん",
      "pinyin": "san",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ヘブンバン",
      "pinyin": "hebunban",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーディアンテールズ公式",
      "pinyin": "gaadianteeruzu公式",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "かんたべりーでぃいず",
      "pinyin": "kantaberiidiizu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーディアンテールズの",
      "pinyin": "gaadianteeruzuno",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "かんたべりーでぃいずの第",
      "pinyin": "kantaberiidiizuno第",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "コンビニは今日も平和です",
      "pinyin": "konbiniha今日mo平和desu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "を公開",
      "pinyin": "wo公開",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "作者",
      "pinyin": "作者",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "純粋な不純物",
      "pinyin": "純粋na不純物",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "先生",
      "pinyin": "先生",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーディアンテールズ",
      "pinyin": "gaadianteeruzu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガデテル",
      "pinyin": "gadeteru",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "ヘブンバーンズレッド公式",
  "pinyin": "he bun baa nzu re ddou kou shi",
  "meaning": "Heaven Burns Red official",
  "notes": "Japanese phrase; 'Heaven Burns Red' is a game title and '公式' means official.",
  "examples": [],
  "pinyinSource": "text_model_hint"
}
```

## 42. 1730196408827jp.png | ja | nvidia/nemotron-nano-12b-v2-vl:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `ja`
- Analyze endpoint: status=502, latency=405.90s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=False, attempts=1, latency=405.90s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: Could not reach OpenRouter.

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 43. o08000924109524428441jp.jpg | auto | nvidia/nemotron-nano-12b-v2-vl:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `ja`
- Analyze endpoint: status=200, latency=255.04s
- Explain endpoint: status=200, latency=1.50s

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=True, attempts=1, latency=192.03s, prompt_tokens=1919, completion_tokens=2005, total_tokens=3924, t/s=10.44
- `text analysis` via `inclusionai/ling-2.6-flash:free`: ok=False, attempts=1, latency=63.00s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: Could not reach OpenRouter.

### Vision Output
```json
{
  "documentText": "少女時代ハラハラ日本脱出29日 PM10:45東京・羽田空港に到着し来日 AM11:00日本レコード大賞のリハーサルに臨む PM 6:53レコ大本番ステージで熱唱スタート PM 6:56本番終了後、控室で私服に着替える PM 7:05ワゴン車に分乗し、羽田へ向け会場を出発 PM 7:38羽田空港に到着日 PM 8:10チャーター機に乗り込み、いざ韓国へ離陸 PM10:10ソウル・金浦空港に無事到着 PM11:50 KBSホールで熱唱ステージ開始",
  "language": "ja",
  "readingLines": [
    "少女時代ハラハラ日本脱出29日 PM10:45東京・羽田空港に到着し来日 AM11:00日本レコード大賞のリハーサルに臨む PM 6:53レコ大本番ステージで熱唱スタート PM 6:56本番終了後、控室で私服に着替える PM 7:05ワゴン車に分乗し、羽田へ向け会場を出発 PM 7:38羽田空港に到着日 PM 8:10チャーター機に乗り込み、いざ韓国へ離陸 PM10:10ソウル・金浦空港に無事到着 PM11:50 KBSホールで熱唱ステージ開始"
  ],
  "pronunciationHints": [],
  "warnings": []
}
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "documentText": "少女時代ハラハラ日本脱出29日 PM10:45東京・羽田空港に到着し来日 AM11:00日本レコード大賞のリハーサルに臨む PM 6:53レコ大本番ステージで熱唱スタート PM 6:56本番終了後、控室で私服に着替える PM 7:05ワゴン車に分乗し、羽田へ向け会場を出発 PM 7:38羽田空港に到着日 PM 8:10チャーター機に乗り込み、いざ韓国へ離陸 PM10:10ソウル・金浦空港に無事到着 PM11:50 KBSホールで熱唱ステージ開始",
  "language": "ja",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "少女時代ハラハラ日本脱出日:東京・羽田空港に到着し来日:日本レコード大賞のリハーサルに臨む:レコ大本番ステージで熱唱スタート:本番終了後、控室で私服に着替える:ワゴン車に分乗し、羽田へ向け会場を出発:羽田空港に到着日:チャーター機に乗り込み、いざ韓国へ離陸:ソウル・金浦空港に無事到着:ホールで熱唱ステージ開始",
      "pinyin": "少女時代harahara日本脱出 日: 東京・羽田空港ni到着shi来日: 日本rekoodo大賞norihaasaruni臨mu: reko大本番suteejide熱唱sutaato: 本番終了後、 控室de私服ni着替eru: wagon車ni分乗shi、 羽田he向ke会場wo出発: 羽田空港ni到着日: chaataa機ni乗ri込mi、 iza韓国he離陸: souru・金浦空港ni無事到着: hoorude熱唱suteeji開始",
      "translation": null,
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "少女時代ハラハラ日本脱出",
          "pinyin": "少女時代harahara日本脱出",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t2",
          "hanzi": "日",
          "pinyin": "日",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t3",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t4",
          "hanzi": "東京・羽田空港に到着し来日",
          "pinyin": "東京・羽田空港ni到着shi来日",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t5",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t6",
          "hanzi": "日本レコード大賞のリハーサルに臨む",
          "pinyin": "日本rekoodo大賞norihaasaruni臨mu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t7",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t8",
          "hanzi": "レコ大本番ステージで熱唱スタート",
          "pinyin": "reko大本番suteejide熱唱sutaato",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t9",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t10",
          "hanzi": "本番終了後",
          "pinyin": "本番終了後",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t11",
          "hanzi": "、",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t12",
          "hanzi": "控室で私服に着替える",
          "pinyin": "控室de私服ni着替eru",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t13",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t14",
          "hanzi": "ワゴン車に分乗し",
          "pinyin": "wagon車ni分乗shi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t15",
          "hanzi": "、",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t16",
          "hanzi": "羽田へ向け会場を出発",
          "pinyin": "羽田he向ke会場wo出発",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t17",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t18",
          "hanzi": "羽田空港に到着日",
          "pinyin": "羽田空港ni到着日",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t19",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t20",
          "hanzi": "チャーター機に乗り込み",
          "pinyin": "chaataa機ni乗ri込mi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t21",
          "hanzi": "、",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t22",
          "hanzi": "いざ韓国へ離陸",
          "pinyin": "iza韓国he離陸",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t23",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t24",
          "hanzi": "ソウル・金浦空港に無事到着",
          "pinyin": "souru・金浦空港ni無事到着",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t25",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t26",
          "hanzi": "ホールで熱唱ステージ開始",
          "pinyin": "hoorude熱唱suteeji開始",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "少女時代ハラハラ日本脱出",
      "pinyin": "少女時代harahara日本脱出",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "日",
      "pinyin": "日",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "東京・羽田空港に到着し来日",
      "pinyin": "東京・羽田空港ni到着shi来日",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "日本レコード大賞のリハーサルに臨む",
      "pinyin": "日本rekoodo大賞norihaasaruni臨mu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "レコ大本番ステージで熱唱スタート",
      "pinyin": "reko大本番suteejide熱唱sutaato",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "本番終了後",
      "pinyin": "本番終了後",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "控室で私服に着替える",
      "pinyin": "控室de私服ni着替eru",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ワゴン車に分乗し",
      "pinyin": "wagon車ni分乗shi",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "羽田へ向け会場を出発",
      "pinyin": "羽田he向ke会場wo出発",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "羽田空港に到着日",
      "pinyin": "羽田空港ni到着日",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "チャーター機に乗り込み",
      "pinyin": "chaataa機ni乗ri込mi",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "いざ韓国へ離陸",
      "pinyin": "iza韓国he離陸",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ソウル・金浦空港に無事到着",
      "pinyin": "souru・金浦空港ni無事到着",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ホールで熱唱ステージ開始",
      "pinyin": "hoorude熱唱suteeji開始",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    }
  ],
  "warnings": [
    "Text analysis is temporarily unavailable; showing OCR text with local pronunciation."
  ]
}
```

### Explain Endpoint Output
```json
{
  "text": "少女時代ハラハラ日本脱出",
  "pinyin": "少女時代harahara日本脱出",
  "meaning": null,
  "notes": null,
  "examples": [],
  "pinyinSource": "library"
}
```

## 44. o08000924109524428441jp.jpg | ja | nvidia/nemotron-nano-12b-v2-vl:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `ja`
- Analyze endpoint: status=502, latency=162.13s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=False, attempts=1, latency=162.13s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: Could not reach OpenRouter.

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 45. The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | auto | nvidia/nemotron-nano-12b-v2-vl:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=146.06s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=False, attempts=1, latency=146.06s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: Could not reach OpenRouter.

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 46. The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | nvidia/nemotron-nano-12b-v2-vl:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=112.76s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=False, attempts=1, latency=112.75s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: Could not reach OpenRouter.

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 47. weibo_6_toutiao_comparison.jpg | auto | nvidia/nemotron-nano-12b-v2-vl:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=84.92s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=False, attempts=1, latency=84.91s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: Could not reach OpenRouter.

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 48. weibo_6_toutiao_comparison.jpg | zh | nvidia/nemotron-nano-12b-v2-vl:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=200, latency=97.34s
- Explain endpoint: status=200, latency=1.69s

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=True, attempts=1, latency=93.24s, prompt_tokens=1680, completion_tokens=3295, total_tokens=4975, t/s=35.34
- `text analysis` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=4.08s, prompt_tokens=643, completion_tokens=588, total_tokens=1231, t/s=143.99

### Vision Output
```json
{
  "documentText": "头条",
  "language": "zh-Hans",
  "readingLines": [
    "头条",
    "Toutiao",
    "10:54",
    "4G",
    "热榜",
    "#怀念单田芳#",
    "#台风山竹#",
    "#被说小伙要起...",
    "#朱旭去世#",
    "韩路出品",
    "我们现在在3200米海拔的四川轿顶山，大雾，本想着气爽来看黄嘎雪山，如今成了0度99%湿度还没电的温湿吐之旅",
    "Mavic2近地起降场补光，像不像UFO抓地球人时候那感觉",
    "10",
    "2",
    "6"
  ],
  "pronunciationHints": [
    {
      "phrase": "头条",
      "preferredPinyin": "tóutíáo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    }
  ],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [
    {
      "hanzi": "头条",
      "translation": "Top headline or trending topic, tóutíáo in pinyin, meaning the main news story or hot topic of the moment, serving as a concise summary of current events that captures reader attention with its prominence and urgency in media coverage and public discourse, representing the most important or most discussed subject at a given time across various platforms and channels where information is shared, discussed, and consumed by diverse audiences seeking to stay informed about what is currently happening in the world around them through various news sources and social media feeds that prioritize such content for maximum visibility and engagement with contemporary issues and developments shaping society today and influencing future trends and public opinion in significant ways that affect individuals, communities, and global interactions in complex modern informational environments characterized by rapid dissemination, constant updates, and evolving narratives that require careful consideration and critical thinking skills to navigate effectively in an increasingly interconnected digital landscape where information flows freely and shapes perceptions, attitudes, and behaviors on a massive scale across different cultures, languages, and regions with varying degrees of access, influence, and impact on public discourse and decision-making processes that determine the direction of societal change and progress over time through collective action, awareness, and engagement with diverse perspectives and ideas that contribute to a more informed and connected global community that values transparency, accuracy, and relevance in the pursuit of knowledge and understanding in an ever-changing world that demands adaptability, flexibility, and openness to new information and perspectives that challenge existing assumptions and beliefs while fostering growth, learning, and development at individual, group, and societal levels through continuous exploration, reflection, and dialogue that promotes understanding, empathy, and cooperation among people from different backgrounds and contexts who share common goals and aspirations for a better future for all members of society regardless of their differences or disagreements on certain issues or topics that may cause conflict or controversy but ultimately lead to greater understanding and progress through constructive engagement and respectful dialogue that encourages participation, collaboration, and innovation in addressing complex challenges and opportunities facing individuals and communities around the world today and tomorrow with hope, resilience, and determination to create positive change and improve lives for current and future generations through collective effort and shared responsibility in building a more just, equitable, and sustainable world for everyone regardless of their background, identity, or circumstances, while also recognizing the importance of balancing individual rights and freedoms with collective well-being and social responsibility to ensure that progress is inclusive, equitable, and sustainable for all people and the planet we share together as members of a global community that depends on cooperation, understanding, and mutual respect to thrive and prosper in an increasingly interconnected and interdependent world that requires us to work together to address common challenges and seize opportunities for growth and development in ways that benefit everyone involved and contribute to a more peaceful, prosperous, and sustainable future for all people and the planet we call home.",
      "tokens": [
        {
          "text": "头条",
          "kind": "other",
          "meaning": null
        }
      ]
    }
  ],
  "glossary": [],
  "pronunciationHints": []
}
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "documentText": "头条",
  "language": "zh-Hans",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "头条",
      "pinyin": "tóutíáo",
      "translation": null,
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "头条",
          "pinyin": "tóutíáo",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "vision_hint"
        }
      ]
    }
  ],
  "glossary": [],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "头条",
  "pinyin": "tóu tiáo",
  "meaning": "top headline; trending topic",
  "notes": "Commonly used in media and social contexts to refer to the most important or popular story.",
  "examples": [],
  "pinyinSource": "text_model_hint"
}
```

## 49. weibo_kol_1.jpg | auto | nvidia/nemotron-nano-12b-v2-vl:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=200, latency=197.74s
- Explain endpoint: status=200, latency=1.78s

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=True, attempts=1, latency=33.10s, prompt_tokens=3730, completion_tokens=1073, total_tokens=4803, t/s=32.41
- `text analysis` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=12.42s, prompt_tokens=1034, completion_tokens=2484, total_tokens=3518, t/s=200.04
- `glossary enrichment` via `inclusionai/ling-2.6-flash:free`: ok=True, attempts=1, latency=152.17s, prompt_tokens=967, completion_tokens=32768, total_tokens=33735, t/s=215.34

### Vision Output
```json
{
  "documentText": "15:33搜索 Following hot 语音鸡娘昨天19:25 from 微博视频怎么能让一碟菜从20块钱变成200块钱呢？语音鸡娘超话 #语音鸡娘品味小知识# @鲜城 @10元券微博专享限时领券语音鸡娘的微博视频在礼盒后面有一个品鉴方法10元券微博专享限时领券领券20.3K views 4846 Users can click coupons at the bottom of a KOL post They will then be directly be taken to Taobao Product page displays once they claim the coupon 15:34 Weibo 粉丝福利购26粉丝福利购品葡酒店10使用期限2019.06.24-2019.07.31立即领券语音鸡娘了不起鸡x诗芮鱼子酱西伯利亚30g礼盒装现价: ¥3092笔成交 ¥299.00更多宝贝推荐 ¥5 ¥5 ¥101 ¥188元送50g鲜鱼肉卡露伽黑鱼子酱西伯利亚鲜鱼鱼籽酱... 103.001699笔成交用券后¥98.00优惠券¥5领取106.00484笔成交用券后¥101.00优惠券¥5领取309 ¥339价格 ¥30910元券后预计减10元满699减30店铺优惠券领券30g礼盒装2人赞过发货四川成都快递:免运费月销3服务7天内发货·环单包赔·订单险参加购物车领券购买券后价¥299返回返回1/5",
  "language": "zh-Hans",
  "readingLines": [
    "15:33搜索 Following hot 语音鸡娘昨天19:25 from 微博视频怎么能让一碟菜从20块钱变成200块钱呢？语音鸡娘超话 #语音鸡娘品味小知识# @鲜城 @10元券微博专享限时领券语音鸡娘的微博视频在礼盒后面有一个品鉴方法10元券微博专享限时领券领券20.3K views 4846 Users can click coupons at the bottom of a KOL post They will then be directly be taken to Taobao Product page displays once they claim the coupon 15:34 Weibo 粉丝福利购26粉丝福利购品葡酒店10使用期限2019.06.24-2019.07.31立即领券语音鸡娘了不起鸡x诗芮鱼子酱西伯利亚30g礼盒装现价: ¥3092笔成交 ¥299.00更多宝贝推荐 ¥5 ¥5 ¥101 ¥188元送50g鲜鱼肉卡露伽黑鱼子酱西伯利亚鲜鱼鱼籽酱... 103.001699笔成交用券后¥98.00优惠券¥5领取106.00484笔成交用券后¥101.00优惠券¥5领取309 ¥339价格 ¥30910元券后预计减10元满699减30店铺优惠券领券30g礼盒装2人赞过发货四川成都快递:免运费月销3服务7天内发货·环单包赔·订单险参加购物车领券购买券后价¥299返回返回1/5"
  ],
  "pronunciationHints": [
    {
      "phrase": "微博",
      "preferredPinyin": "Weibo",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    }
  ],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [
    {
      "hanzi": "15:33搜索 Following hot 语音鸡娘昨天19:25 from 微博视频",
      "translation": "15:33 search Following hot Voice Chicken Girl yesterday 19:25 from Weibo video. (Pronunciation hint: 微博 Weibo).\", \"tokens\": [{\"text\": \"15:33\", \"kind\": \"other\"}, {\"text\": \"search\", \"kind\": \"word\"}, {\"text\": \"Following\", \"kind\": \"word\"}, {\"text\": \"Voice Chicken Girl\", \"kind\": \"phrase\"}, {\"text\": \"yesterday\", \"kind\": \"word\"}, {\"text\": \"19:25\", \"kind\": \"other\"}, {\"text\": \"from\", \"kind\": \"word\"}, {\"text\": \"Weibo\", \"kind\": \"phrase\"}, {\"text\": \"video\", \"kind\": \"word\"}]}",
      "tokens": [
        {
          "text": "15:33搜索 Following hot 语音鸡娘昨天19:25 from 微博视频",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "怎么能让一碟菜从20块钱变成200块钱呢？",
      "translation": "How can one dish change from 20 yuan to 200 yuan?\", \"tokens\": [{\"text\": \"How\", \"kind\": \"word\"}, {\"text\": \"can\", \"kind\": \"word\"}, {\"text\": \"one dish\", \"kind\": \"phrase\"}, {\"text\": \"change\", \"kind\": \"word\"}, {\"text\": \"from 20 yuan to 200 yuan\", \"kind\": \"phrase\"}, {text\":?\", \"kind\": \"punctuation\"}]}",
      "tokens": [
        {
          "text": "怎么能让一碟菜从20块钱变成200块钱呢？",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "语音鸡娘超话 #语音鸡娘品味小知识#",
      "translation": "Voice Chicken Girl super topic #Voice Chicken Girl taste tips#.\" \"tokens\": [{\"text\": \"Voice Chicken Girl\", \"kind\": \"phrase\"}, {\"text\": \"super topic\", \"kind\": \"phrase\"}, {\"text\": \"#Voice Chicken Girl taste tips#\", \"kind\": \"other\"}]}",
      "tokens": [
        {
          "text": "语音鸡娘超话 #语音鸡娘品味小知识#",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "@鲜城 @10元券微博专享限时领券",
      "translation": "@Fresh City @10 yuan coupon Weibo exclusive limited-time coupon.\" \"tokens\": [{\"text\": \"@Fresh City\", \"kind\": \"other\"}, {\"text\": \"@10 yuan coupon\", \"kind\": \"other\"}, {\"text\": \"Weibo exclusive limited-time coupon\", \"kind\": \"phrase\"}]}",
      "tokens": [
        {
          "text": "@鲜城 @10元券微博专享限时领券",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "语音鸡娘的微博视频在礼盒后面有一个品鉴方法",
      "translation": "Voice Chicken Girl's Weibo video has a tasting method behind the gift box.\" \"tokens\": [{\"text\": \"Voice Chicken Girl\", \"kind\": \"phrase\"}, {\"text\": \"Weibo video\", \"kind\": \"phrase\"}, {\"text\": \"tasting method\", \"kind\": \"phrase\"}, {\"text\": \"behind the gift box\", \"kind\": \"phrase\"}]}",
      "tokens": [
        {
          "text": "语音鸡娘的微博视频在礼盒后面有一个品鉴方法",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "10元券微博专享限时领券领券20.3K views 4846",
      "translation": "10 yuan coupon Weibo exclusive limited-time coupon, 20.3K views, 4846.\" \"tokens\": [{\"text\": \"10 yuan coupon\", \"kind\": \"phrase\"}, {\"text\": \"Weibo exclusive limited-time coupon\", \"kind\": \"phrase\"}, {\"text\": \"20.3K views\", \"kind\": \"other\"}, {\"text\": \"4846\", \"kind\": \"other\"}]}",
      "tokens": [
        {
          "text": "10元券微博专享限时领券领券20.3K views 4846",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Users can click coupons at the bottom of a KOL post",
      "translation": "Users can click coupons at the bottom of a KOL post.\" \"tokens\": [{\"text\": \"Users\", \"kind\": \"word\"}, {\"text\": \"can click\", \"kind\": \"word\"}, {\"text\": \"coupons\", \"kind\": \"word\"}, {\"text\": \"at the bottom of a KOL post\", \"kind\": \"phrase\"}]}",
      "tokens": [
        {
          "text": "Users can click coupons at the bottom of a KOL post",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "They will then be directly be taken to Taobao Product page displays once they claim the coupon",
      "translation": "They are taken directly to Taobao product page after claiming the coupon.\" \"tokens\": [{\"text\": \"They\", \"kind\": \"word\"}, {\"text\": \"are taken directly to Taobao\", \"kind\": \"phrase\"}, {\"text\": \"product page\", \"kind\": \"phrase\"}, {\"text\": \"after claiming the coupon\", \"kind\": \"phrase\"}]}",
      "tokens": [
        {
          "text": "They will then be directly be taken to Taobao Product page displays once they claim the coupon",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "15:34 Weibo 粉丝福利购26粉丝福利购品葡酒店10使用期限2019.06.24-2019.07.31立即领券",
      "translation": "15:34 Weibo fan welfare purchase 26, valid from 2019-06-24 to 2019-07-31, claim now.\" \"tokens\": [{\"text\": \"15:34\", \"kind\": \"other\"}, {\"text\": \"Weibo\", \"kind\": \"phrase\"}, {\"text\": \"fan welfare purchase 26\", \"kind\": \"phrase\"}, {\"text\": \"valid from 2019-06-24 to 2019-07-31\", \"kind\": \"phrase\"}, {\"text\": \"claim now\", \"kind\": \"phrase\"}]}",
      "tokens": [
        {
          "text": "15:34 Weibo 粉丝福利购26粉丝福利购品葡酒店10使用期限2019.06.24-2019.07.31立即领券",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "语音鸡娘了不起鸡x诗芮鱼子酱西伯利亚30g礼盒装现价: ¥3092笔成交 ¥299.00",
      "translation": "Voice Chicken Girl amazing chicken x Shirui caviar set, 30g, now ¥309, sold 2,990.\" \"tokens\": [{\"text\": \"Voice Chicken Girl\", \"kind\": \"phrase\"}, {\"text\": \"amazing chicken x Shirui caviar set\", \"kind\": \"phrase\"}, {\"text\": \"30g set\", \"kind\": \"phrase\"}, {\"text\": \"now ¥309\", \"kind\": \"other\"}, {\"text\": \"sold 2,990\", \"kind\": \"other\"}]}",
      "tokens": [
        {
          "text": "语音鸡娘了不起鸡x诗芮鱼子酱西伯利亚30g礼盒装现价: ¥3092笔成交 ¥299.00",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "更多宝贝推荐 ¥5 ¥5 ¥101 ¥188元送50g鲜鱼肉卡露伽黑鱼子酱西伯利亚鲜鱼鱼籽酱...",
      "translation": "More recommended items: ¥5, ¥5, ¥101, ¥188 for 50g fresh fish roe Kaluga caviar Siberian fish eggs.\" \"tokens\": [{\"text\": \"More recommended items\", \"kind\": \"phrase\"}, {\"text\": \"¥5\", \"kind\": \"other\"}, {\"text\": \"¥101\", \"kind\": \"other\"}, {\"text\": \"¥188 for 50g fresh fish roe Kaluga caviar\", \"kind\": \"phrase\"}, {\"text\": \"Siberian fish eggs\", \"kind\": \"phrase\"}]}",
      "tokens": [
        {
          "text": "更多宝贝推荐 ¥5 ¥5 ¥101 ¥188元送50g鲜鱼肉卡露伽黑鱼子酱西伯利亚鲜鱼鱼籽酱...",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "103.001699笔成交用券后¥98.00优惠券¥5领取106.00",
      "translation": "103.00, 1,699 sales, use coupon to pay ¥98, coupon ¥5, redeem for ¥106.\" \"tokens\": [{\"text\": \"103.00\", \"kind\": \"other\"}, {\"text\": \"1,699 sales\", \"kind\": \"other\"}, {\"text\": \"use coupon to pay ¥98\", \"kind\": \"phrase\"}, {\"text\": \"coupon ¥5\", \"kind\": \"other\"}, {\"text\": \"redeem for ¥106\", \"kind\": \"other\"}]}",
      "tokens": [
        {
          "text": "103.001699笔成交用券后¥98.00优惠券¥5领取106.00",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "484笔成交用券后¥101.00优惠券¥5领取",
      "translation": "484 sales, use coupon to pay ¥101, coupon ¥5.\" \"tokens\": [{\"text\": \"484 sales\", \"kind\": \"other\"}, {\"text\": \"use coupon to pay ¥101\", \"kind\": \"phrase\"}, {\"text\": \"coupon ¥5\", \"kind\": \"other\"}]}",
      "tokens": [
        {
          "text": "484笔成交用券后¥101.00优惠券¥5领取",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "309 ¥339价格 ¥30910元券后预计减10元满699减30店铺优惠券领券",
      "translation": "Price ¥339, 10 yuan coupon reduces by ¥10, 满699减30 shop coupon.\" \"tokens\": [{\"text\": \"Price ¥339\", \"kind\": \"other\"}, {\"text\": \"10 yuan coupon reduces by ¥10\", \"kind\": \"phrase\"}, {\"text\": \"满699减30 shop coupon\", \"kind\": \"phrase\"}, {\"text\": \"claim coupon\", \"kind\": \"phrase\"}]}",
      "tokens": [
        {
          "text": "309 ¥339价格 ¥30910元券后预计减10元满699减30店铺优惠券领券",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "30g礼盒装2人赞过发货四川成都快递:免运费月销3服务7天内发货·环单包赔·订单险参加购物车领券购买券后价¥299",
      "translation": "30g gift set, 2 endorsements, ships from Chengdu, free shipping, 3 sold/month, 7-day dispatch, refund guarantee, order insurance, cart coupon, price ¥299.\" \"tokens\": [{\"text\": \"30g gift set\", \"kind\": \"phrase\"}, {\"text\": \"2 endorsements\", \"kind\": \"phrase\"}, {\"text\": \"ships from Chengdu, free shipping\", \"kind\": \"phrase\"}, {\"text\": \"3 sold/month, 7-day dispatch\", \"kind\": \"phrase\"}, {\"text\": \"refund guarantee, order insurance\", \"kind\": \"phrase\"}, {\"text\": \"cart coupon, price ¥299\", \"kind\": \"phrase\"}]}",
      "tokens": [
        {
          "text": "30g礼盒装2人赞过发货四川成都快递:免运费月销3服务7天内发货·环单包赔·订单险参加购物车领券购买券后价¥299",
          "kind": "other",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "返回返回1/5",
      "translation": "Back, back, page 1/5.\" \"tokens\": [{\"text\": \"Back\", \"kind\": \"word\"}, {\"text\": \"page 1/5\", \"kind\": \"other\"}]}",
      "tokens": [
        {
          "text": "返回返回1/5",
          "kind": "other",
          "meaning": null
        }
      ]
    }
  ],
  "glossary": [],
  "pronunciationHints": []
}
```

### Glossary Enrichment Output
```json
{
  "entries": []
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "15:33搜索 Following hot 语音鸡娘昨天19:25 from 微博视频怎么能让一碟菜从20块钱变成200块钱呢？语音鸡娘超话 #语音鸡娘品味小知识# @鲜城 @10元券微博专享限时领券语音鸡娘的微博视频在礼盒后面有一个品鉴方法10元券微博专享限时领券领券20.3K views 4846 Users can click coupons at the bottom of a KOL post They will then be directly be taken to Taobao Product page displays once they claim the coupon 15:34 Weibo 粉丝福利购26粉丝福利购品葡酒店10使用期限2019.06.24-2019.07.31立即领券语音鸡娘了不起鸡x诗芮鱼子酱西伯利亚30g礼盒装现价: ¥3092笔成交 ¥299.00更多宝贝推荐 ¥5 ¥5 ¥101 ¥188元送50g鲜鱼肉卡露伽黑鱼子酱西伯利亚鲜鱼鱼籽酱... 103.001699笔成交用券后¥98.00优惠券¥5领取106.00484笔成交用券后¥101.00优惠券¥5领取309 ¥339价格 ¥30910元券后预计减10元满699减30店铺优惠券领券30g礼盒装2人赞过发货四川成都快递:免运费月销3服务7天内发货·环单包赔·订单险参加购物车领券购买券后价¥299返回返回1/5",
  "language": "zh-Hans",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "15:33搜索 Following hot 语音鸡娘昨天19:25 from 微博视频",
      "pinyin": "15:33 sōu suǒ Following hot yǔ yīn jī niáng zuó tiān 19:25 from wēi bó shì pín",
      "translation": "15:33 search Following hot Voice Chicken Girl yesterday 19:25 from Weibo video.",
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "15:33搜索 Following hot 语音鸡娘昨天19:25 from 微博视频",
          "pinyin": "15:33 sōu suǒ Following hot yǔ yīn jī niáng zuó tiān 19:25 from wēi bó shì pín",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "怎么能让一碟菜从块钱变成块钱呢？",
      "pinyin": "zěn me néng ràng yī dié cài cóng kuài qián biàn chéng kuài qián ne？",
      "translation": null,
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "怎么能让一碟菜从",
          "pinyin": "zěn me néng ràng yī dié cài cóng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t2",
          "hanzi": "块钱变成",
          "pinyin": "kuài qián biàn chéng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t3",
          "hanzi": "块钱呢",
          "pinyin": "kuài qián ne",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t4",
          "hanzi": "？",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "语音鸡娘超话语音鸡娘品味小知识",
      "pinyin": "yǔ yīn jī niáng chāo huà yǔ yīn jī niáng pǐn wèi xiǎo zhī shí",
      "translation": null,
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "语音鸡娘超话",
          "pinyin": "yǔ yīn jī niáng chāo huà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t2",
          "hanzi": "语音鸡娘品味小知识",
          "pinyin": "yǔ yīn jī niáng pǐn wèi xiǎo zhī shí",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s4",
      "hanzi": "@鲜城 @10元券微博专享限时领券",
      "pinyin": "@ xiān chéng @10 yuán quàn wēi bó zhuān xiǎng xiàn shí lǐng quàn",
      "translation": null,
      "tokens": [
        {
          "id": "s4-t1",
          "hanzi": "@鲜城 @10元券微博专享限时领券",
          "pinyin": "@ xiān chéng @10 yuán quàn wēi bó zhuān xiǎng xiàn shí lǐng quàn",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s5",
      "hanzi": "语音鸡娘的微博视频在礼盒后面有一个品鉴方法",
      "pinyin": "yǔ yīn jī niáng de wēi bó shì pín zài lǐ hé hòu miàn yǒu yí gè pǐn jiàn fāng fǎ",
      "translation": null,
      "tokens": [
        {
          "id": "s5-t1",
          "hanzi": "语音鸡娘的微博视频在礼盒后面有一个品鉴方法",
          "pinyin": "yǔ yīn jī niáng de wēi bó shì pín zài lǐ hé hòu miàn yǒu yí gè pǐn jiàn fāng fǎ",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s6",
      "hanzi": "10元券微博专享限时领券领券20.3K views 4846",
      "pinyin": "10 yuán quàn wēi bó zhuān xiǎng xiàn shí lǐng quàn lǐng quàn 20.3K views 4846",
      "translation": null,
      "tokens": [
        {
          "id": "s6-t1",
          "hanzi": "10元券微博专享限时领券领券20.3K views 4846",
          "pinyin": "10 yuán quàn wēi bó zhuān xiǎng xiàn shí lǐng quàn lǐng quàn 20.3K views 4846",
          "meaning": null,
          "kind": "other",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s7",
      "hanzi": "粉丝福利购粉丝福利购品葡酒店使用期限-立即领券",
      "pinyin": "fěn sī fú lì gòu fěn sī fú lì gòu pǐn pú jiǔ diàn shǐ yòng qī xiàn- lì jí lǐng quàn",
      "translation": null,
      "tokens": [
        {
          "id": "s7-t1",
          "hanzi": "粉丝福利购",
          "pinyin": "fěn sī fú lì gòu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t2",
          "hanzi": "粉丝福利购品葡酒店",
          "pinyin": "fěn sī fú lì gòu pǐn pú jiǔ diàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t3",
          "hanzi": "使用期限",
          "pinyin": "shǐ yòng qī xiàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t4",
          "hanzi": "-",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t5",
          "hanzi": "立即领券",
          "pinyin": "lì jí lǐng quàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s8",
      "hanzi": "语音鸡娘了不起鸡诗芮鱼子酱西伯利亚礼盒装现价:笔成交",
      "pinyin": "yǔ yīn jī niáng liǎo bù qǐ jī shī ruì yú zi jiàng xī bó lì yà lǐ hé zhuāng xiàn jià: bǐ chéng jiāo",
      "translation": null,
      "tokens": [
        {
          "id": "s8-t1",
          "hanzi": "语音鸡娘了不起鸡",
          "pinyin": "yǔ yīn jī niáng liǎo bù qǐ jī",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t2",
          "hanzi": "诗芮鱼子酱西伯利亚",
          "pinyin": "shī ruì yú zi jiàng xī bó lì yà",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t3",
          "hanzi": "礼盒装现价",
          "pinyin": "lǐ hé zhuāng xiàn jià",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t4",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t5",
          "hanzi": "笔成交",
          "pinyin": "bǐ chéng jiāo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s9",
      "hanzi": "更多宝贝推荐元送鲜鱼肉卡露伽黑鱼子酱西伯利亚鲜鱼鱼籽酱",
      "pinyin": "gèng duō bǎo bèi tuī jiàn yuán sòng xiān yú ròu kǎ lù gā hēi yú zi jiàng xī bó lì yà xiān yú yú zǐ jiàng",
      "translation": null,
      "tokens": [
        {
          "id": "s9-t1",
          "hanzi": "更多宝贝推荐",
          "pinyin": "gèng duō bǎo bèi tuī jiàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t2",
          "hanzi": "元送",
          "pinyin": "yuán sòng",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t3",
          "hanzi": "鲜鱼肉卡露伽黑鱼子酱西伯利亚鲜鱼鱼籽酱",
          "pinyin": "xiān yú ròu kǎ lù gā hēi yú zi jiàng xī bó lì yà xiān yú yú zǐ jiàng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s10",
      "hanzi": "笔成交用券后优惠券领取",
      "pinyin": "bǐ chéng jiāo yòng quàn hòu yōu huì quàn lǐng qǔ",
      "translation": null,
      "tokens": [
        {
          "id": "s10-t1",
          "hanzi": "笔成交用券后",
          "pinyin": "bǐ chéng jiāo yòng quàn hòu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t2",
          "hanzi": "优惠券",
          "pinyin": "yōu huì quàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t3",
          "hanzi": "领取",
          "pinyin": "lǐng qǔ",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s11",
      "hanzi": "笔成交用券后优惠券领取",
      "pinyin": "bǐ chéng jiāo yòng quàn hòu yōu huì quàn lǐng qǔ",
      "translation": "484 sales, use coupon to pay ¥101, coupon ¥5.\" \"tokens\": [{\"text\": \"484 sales\", \"kind\": \"other\"}, {\"text\": \"use coupon to pay ¥101\", \"kind\": \"phrase\"}, {\"text\": \"coupon ¥5\", \"kind\": \"other\"}]}",
      "tokens": [
        {
          "id": "s11-t1",
          "hanzi": "笔成交用券后",
          "pinyin": "bǐ chéng jiāo yòng quàn hòu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t2",
          "hanzi": "优惠券",
          "pinyin": "yōu huì quàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t3",
          "hanzi": "领取",
          "pinyin": "lǐng qǔ",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s12",
      "hanzi": "价格元券后预计减元满减店铺优惠券领券",
      "pinyin": "jià gé yuán quàn hòu yù jì jiǎn yuán mǎn jiǎn diàn pù yōu huì quàn lǐng quàn",
      "translation": "Price ¥339, 10 yuan coupon reduces by ¥10,",
      "tokens": [
        {
          "id": "s12-t1",
          "hanzi": "价格",
          "pinyin": "jià gé",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s12-t2",
          "hanzi": "元券后预计减",
          "pinyin": "yuán quàn hòu yù jì jiǎn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s12-t3",
          "hanzi": "元满",
          "pinyin": "yuán mǎn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s12-t4",
          "hanzi": "减",
          "pinyin": "jiǎn",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s12-t5",
          "hanzi": "店铺优惠券领券",
          "pinyin": "diàn pù yōu huì quàn lǐng quàn",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s13",
      "hanzi": "礼盒装人赞过发货四川成都快递:免运费月销服务天内发货·环单包赔·订单险参加购物车领券购买券后价",
      "pinyin": "lǐ hé zhuāng rén zàn guò fā huò sì chuān chéng dū kuài dì: miǎn yùn fèi yuè xiāo fú wù tiān nèi fā huò· huán dān bāo péi· dìng dān xiǎn cān jiā gòu wù chē lǐng quàn gòu mǎi quàn hòu jià",
      "translation": null,
      "tokens": [
        {
          "id": "s13-t1",
          "hanzi": "礼盒装",
          "pinyin": "lǐ hé zhuāng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t2",
          "hanzi": "人赞过发货四川成都快递",
          "pinyin": "rén zàn guò fā huò sì chuān chéng dū kuài dì",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t3",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t4",
          "hanzi": "免运费月销",
          "pinyin": "miǎn yùn fèi yuè xiāo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t5",
          "hanzi": "服务",
          "pinyin": "fú wù",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t6",
          "hanzi": "天内发货",
          "pinyin": "tiān nèi fā huò",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t7",
          "hanzi": "·",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t8",
          "hanzi": "环单包赔",
          "pinyin": "huán dān bāo péi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t9",
          "hanzi": "·",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t10",
          "hanzi": "订单险参加购物车领券购买券后价",
          "pinyin": "dìng dān xiǎn cān jiā gòu wù chē lǐng quàn gòu mǎi quàn hòu jià",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s14",
      "hanzi": "返回返回",
      "pinyin": "fǎn huí fǎn huí",
      "translation": "Back, back, page 1/5.\" \"tokens\": [{\"text\": \"Back\", \"kind\": \"word\"}, {\"text\": \"page 1/5\", \"kind\": \"other\"}]}",
      "tokens": [
        {
          "id": "s14-t1",
          "hanzi": "返回返回",
          "pinyin": "fǎn huí fǎn huí",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "怎么能让一碟菜从",
      "pinyin": "zěn me néng ràng yī dié cài cóng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "块钱变成",
      "pinyin": "kuài qián biàn chéng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "块钱呢",
      "pinyin": "kuài qián ne",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "语音鸡娘超话",
      "pinyin": "yǔ yīn jī niáng chāo huà",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "语音鸡娘品味小知识",
      "pinyin": "yǔ yīn jī niáng pǐn wèi xiǎo zhī shí",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "粉丝福利购",
      "pinyin": "fěn sī fú lì gòu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "粉丝福利购品葡酒店",
      "pinyin": "fěn sī fú lì gòu pǐn pú jiǔ diàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "使用期限",
      "pinyin": "shǐ yòng qī xiàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "立即领券",
      "pinyin": "lì jí lǐng quàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "语音鸡娘了不起鸡",
      "pinyin": "yǔ yīn jī niáng liǎo bù qǐ jī",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "诗芮鱼子酱西伯利亚",
      "pinyin": "shī ruì yú zi jiàng xī bó lì yà",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "礼盒装现价",
      "pinyin": "lǐ hé zhuāng xiàn jià",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "笔成交",
      "pinyin": "bǐ chéng jiāo",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "更多宝贝推荐",
      "pinyin": "gèng duō bǎo bèi tuī jiàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "元送",
      "pinyin": "yuán sòng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "鲜鱼肉卡露伽黑鱼子酱西伯利亚鲜鱼鱼籽酱",
      "pinyin": "xiān yú ròu kǎ lù gā hēi yú zi jiàng xī bó lì yà xiān yú yú zǐ jiàng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "笔成交用券后",
      "pinyin": "bǐ chéng jiāo yòng quàn hòu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "优惠券",
      "pinyin": "yōu huì quàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "领取",
      "pinyin": "lǐng qǔ",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "价格",
      "pinyin": "jià gé",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "元券后预计减",
      "pinyin": "yuán quàn hòu yù jì jiǎn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "元满",
      "pinyin": "yuán mǎn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "减",
      "pinyin": "jiǎn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "店铺优惠券领券",
      "pinyin": "diàn pù yōu huì quàn lǐng quàn",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "礼盒装",
      "pinyin": "lǐ hé zhuāng",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "人赞过发货四川成都快递",
      "pinyin": "rén zàn guò fā huò sì chuān chéng dū kuài dì",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "免运费月销",
      "pinyin": "miǎn yùn fèi yuè xiāo",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "服务",
      "pinyin": "fú wù",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "天内发货",
      "pinyin": "tiān nèi fā huò",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "环单包赔",
      "pinyin": "huán dān bāo péi",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "订单险参加购物车领券购买券后价",
      "pinyin": "dìng dān xiǎn cān jiā gòu wù chē lǐng quàn gòu mǎi quàn hòu jià",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "返回返回",
      "pinyin": "fǎn huí fǎn huí",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "怎么能让一碟菜从",
  "pinyin": "zěn me néng ràng yī dié cài cóng",
  "meaning": null,
  "notes": null,
  "examples": [],
  "pinyinSource": "library"
}
```

## 50. weibo_kol_1.jpg | zh | nvidia/nemotron-nano-12b-v2-vl:free + inclusionai/ling-2.6-flash:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=256.10s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=False, attempts=1, latency=256.06s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: Could not reach OpenRouter.

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 51. 1730196408827jp.png | auto | nvidia/nemotron-nano-12b-v2-vl:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `ja`
- Analyze endpoint: status=200, latency=94.47s
- Explain endpoint: status=200, latency=6.24s

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=True, attempts=1, latency=36.95s, prompt_tokens=1682, completion_tokens=1461, total_tokens=3143, t/s=39.55
- `text analysis` via `nvidia/nemotron-3-nano-30b-a3b:free`: ok=True, attempts=1, latency=26.89s, prompt_tokens=696, completion_tokens=7548, total_tokens=8244, t/s=280.70
- `glossary enrichment` via `nvidia/nemotron-3-nano-30b-a3b:free`: ok=True, attempts=1, latency=30.61s, prompt_tokens=552, completion_tokens=5987, total_tokens=6539, t/s=195.57

### Vision Output
```json
{
  "documentText": "@heavenburnsred • Follow\n公式4コマ漫画【ヘブンバン劇場】 第108話「のろけ」\nシャロの撮影技術はすごい！\n今までのお話はこちら→x.com/heavenburnsred...\n作画:津留崎優 @hatori_niwatoriさん\n#ヘブンバン #ヘブンバン劇場\n\n1:00 PM · Sep 15, 2024\n💖 4.1K\n💙 Reply\n🔗 Copy link\nRead 29 replies",
  "language": "ja",
  "readingLines": [
    "@heavenburnsred • Follow",
    "公式4コマ漫画【ヘブンバン劇場】 第108話「のろけ」",
    "シャロの撮影技術はすごい！",
    "今までのお話はこちら→x.com/heavenburnsred...",
    "作画:津留崎優 @hatori_niwatoriさん",
    "#ヘブンバン #ヘブンバン劇場",
    "",
    "1:00 PM · Sep 15, 2024",
    "💖 4.1K",
    "💙 Reply",
    "🔗 Copy link",
    "Read 29 replies"
  ],
  "pronunciationHints": [],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [
    {
      "hanzi": "@heavenburnsred • Follow",
      "translation": "Follow @heavenburnsred",
      "tokens": [
        {
          "text": "@heavenburnsred",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "•",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "Follow",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "公式4コマ漫画【ヘブンバン劇場】 第108話「のろけ」",
      "translation": "Official 4‑panel manga [Heaven Burn Theater] Chapter 108 \"Noro-ke\"",
      "tokens": [
        {
          "text": "公式",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "4コマ",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "漫画",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "【",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "ヘブンバン劇場",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "】",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "第108話",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "「",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "のろけ",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "」",
          "kind": "punctuation",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "シャロの撮影技術はすごい！",
      "translation": "Sharo's photography technique is amazing!",
      "tokens": [
        {
          "text": "シャロ",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "の",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "撮影技術",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "は",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "すごい",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "！",
          "kind": "punctuation",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "今までのお話はこちら→x.com/heavenburnsred...",
      "translation": "All previous stories are here → x.com/heavenburnsred...",
      "tokens": [
        {
          "text": "今まで",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "の",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "お話",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "は",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "こちら",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "→",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "x.com/heavenburnsred...",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "作画:津留崎優 @hatori_niwatoriさん",
      "translation": "Art by YU Tsuruzaki @hatori_niwatoriさん",
      "tokens": [
        {
          "text": "作画",
          "kind": "word",
          "meaning": null
        },
        {
          "text": ":",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "津留崎優",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "@hatori_niwatoriさん",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "#ヘブンバン #ヘブンバン劇場",
      "translation": "#HeavenBurn #HeavenBurnTheater",
      "tokens": [
        {
          "text": "#ヘブンバン",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "#ヘブンバン劇場",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "1:00 PM · Sep 15, 2024",
      "translation": "1:00 PM on September 15, 2024",
      "tokens": [
        {
          "text": "1:00",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "PM",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "·",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "Sep",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "15",
          "kind": "word",
          "meaning": null
        },
        {
          "text": ",",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "2024",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "💖 4.1K",
      "translation": "4.1K likes",
      "tokens": [
        {
          "text": "💖",
          "kind": "other",
          "meaning": null
        },
        {
          "text": "4.1K",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "💙 Reply",
      "translation": "Reply with a blue heart",
      "tokens": [
        {
          "text": "💙",
          "kind": "other",
          "meaning": null
        },
        {
          "text": "Reply",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "🔗 Copy link",
      "translation": "Copy link",
      "tokens": [
        {
          "text": "🔗",
          "kind": "other",
          "meaning": null
        },
        {
          "text": "Copy",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "link",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "Read 29 replies",
      "translation": "Read 29 replies",
      "tokens": [
        {
          "text": "Read",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "29",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "replies",
          "kind": "word",
          "meaning": null
        }
      ]
    }
  ],
  "glossary": [
    {
      "text": "撮影技術",
      "meaning": "photography technique"
    },
    {
      "text": "作画",
      "meaning": "artwork, animation production"
    },
    {
      "text": "ヘブンバン劇場",
      "meaning": "Heaven Burn Theater"
    },
    {
      "text": "のろけ",
      "meaning": "gripe, complaint"
    },
    {
      "text": "公式",
      "meaning": "official"
    },
    {
      "text": "4コマ",
      "meaning": "four-panel"
    },
    {
      "text": "漫画",
      "meaning": "comic, manga"
    },
    {
      "text": "第108話",
      "meaning": "chapter 108"
    },
    {
      "text": "シャロ",
      "meaning": "Sharo (character)"
    },
    {
      "text": "お話",
      "meaning": "story, talk"
    }
  ],
  "pronunciationHints": []
}
```

### Glossary Enrichment Output
```json
{
  "entries": [
    {
      "text": "公式",
      "literalMeaning": "official",
      "exampleSentence": "公式サイトに掲載されています。"
    },
    {
      "text": "コマ",
      "literalMeaning": "panel",
      "exampleSentence": "漫画の1コマです。"
    },
    {
      "text": "漫画",
      "literalMeaning": "comic",
      "exampleSentence": "漫画を読むのが好きです。"
    },
    {
      "text": "ヘブンバン劇場",
      "literalMeaning": "Heaven Burns Red theater",
      "exampleSentence": "ヘブンバン劇場で公演が行われます。"
    },
    {
      "text": "第",
      "literalMeaning": "th",
      "exampleSentence": "第1話です。"
    },
    {
      "text": "話",
      "literalMeaning": "story",
      "exampleSentence": "面白い話です。"
    },
    {
      "text": "のろけ",
      "literalMeaning": "gripe",
      "exampleSentence": "のろけが好きです。"
    },
    {
      "text": "シャロ",
      "literalMeaning": "Sharo",
      "exampleSentence": "シャロは可愛いです。"
    },
    {
      "text": "の",
      "literalMeaning": "of",
      "exampleSentence": "それはのです。"
    },
    {
      "text": "撮影技術",
      "literalMeaning": "photography technique",
      "exampleSentence": "撮影技術がすごいです。"
    },
    {
      "text": "は",
      "literalMeaning": "topic marker",
      "exampleSentence": "彼は学生です。"
    },
    {
      "text": "すごい",
      "literalMeaning": "amazing",
      "exampleSentence": "すごいですね！"
    },
    {
      "text": "今まで",
      "literalMeaning": "until now",
      "exampleSentence": "今までの経験です。"
    },
    {
      "text": "お話",
      "literalMeaning": "story",
      "exampleSentence": "面白いお話です。"
    },
    {
      "text": "こちら",
      "literalMeaning": "here",
      "exampleSentence": "こちらへ来てください。"
    },
    {
      "text": "作画",
      "literalMeaning": "artwork",
      "exampleSentence": "作画は津留崎優さんです。"
    },
    {
      "text": "津留崎優",
      "literalMeaning": "Yū Tsuruzaki",
      "exampleSentence": "津留崎優さんが描きました。"
    },
    {
      "text": "さん",
      "literalMeaning": "san",
      "exampleSentence": "田中さんです。"
    },
    {
      "text": "ヘブンバン",
      "literalMeaning": "Heaven Burns Red",
      "exampleSentence": "ヘブンバンは人気です。"
    },
    {
      "text": "4コマ",
      "literalMeaning": "four-panel",
      "exampleSentence": "4コマ漫画が好きです。"
    },
    {
      "text": "第108話",
      "literalMeaning": "episode 108",
      "exampleSentence": "第108話を読んだ。"
    }
  ]
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "@heavenburnsred • Follow\n公式4コマ漫画【ヘブンバン劇場】 第108話「のろけ」\nシャロの撮影技術はすごい！\n今までのお話はこちら→x.com/heavenburnsred...\n作画:津留崎優 @hatori_niwatoriさん\n#ヘブンバン #ヘブンバン劇場\n\n1:00 PM · Sep 15, 2024\n💖 4.1K\n💙 Reply\n🔗 Copy link\nRead 29 replies",
  "language": "ja",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "公式コマ漫画ヘブンバン劇場第話のろけ",
      "pinyin": "公式 koma 漫画 hebunban劇場 第 話 noroke",
      "translation": "Official 4‑panel manga [Heaven Burn Theater] Chapter 108 \"Noro-ke\"",
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "公式",
          "pinyin": "公式",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t2",
          "hanzi": "コマ",
          "pinyin": "koma",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t3",
          "hanzi": "漫画",
          "pinyin": "漫画",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t4",
          "hanzi": "ヘブンバン劇場",
          "pinyin": "hebunban劇場",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t5",
          "hanzi": "第",
          "pinyin": "第",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t6",
          "hanzi": "話",
          "pinyin": "話",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t7",
          "hanzi": "のろけ",
          "pinyin": "noroke",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "シャロの撮影技術はすごい！",
      "pinyin": "sharo no 撮影技術 ha sugoi！",
      "translation": "Sharo's photography technique is amazing!",
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "シャロ",
          "pinyin": "sharo",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t2",
          "hanzi": "の",
          "pinyin": "no",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t3",
          "hanzi": "撮影技術",
          "pinyin": "撮影技術",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t4",
          "hanzi": "は",
          "pinyin": "ha",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t5",
          "hanzi": "すごい",
          "pinyin": "sugoi",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t6",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "今までのお話はこちら",
      "pinyin": "今made no o話 ha kochira",
      "translation": "All previous stories are here → x.com/heavenburnsred...",
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "今まで",
          "pinyin": "今made",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t2",
          "hanzi": "の",
          "pinyin": "no",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t3",
          "hanzi": "お話",
          "pinyin": "o話",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t4",
          "hanzi": "は",
          "pinyin": "ha",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t5",
          "hanzi": "こちら",
          "pinyin": "kochira",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s4",
      "hanzi": "作画:津留崎優さん",
      "pinyin": "作画: 津留崎優 san",
      "translation": "Art by YU Tsuruzaki @hatori_niwatoriさん",
      "tokens": [
        {
          "id": "s4-t1",
          "hanzi": "作画",
          "pinyin": "作画",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t2",
          "hanzi": ":",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t3",
          "hanzi": "津留崎優",
          "pinyin": "津留崎優",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s4-t4",
          "hanzi": "さん",
          "pinyin": "san",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s5",
      "hanzi": "ヘブンバンヘブンバン劇場",
      "pinyin": "hebunban hebunban劇場",
      "translation": "#HeavenBurn #HeavenBurnTheater",
      "tokens": [
        {
          "id": "s5-t1",
          "hanzi": "ヘブンバン",
          "pinyin": "hebunban",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t2",
          "hanzi": "ヘブンバン劇場",
          "pinyin": "hebunban劇場",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "公式",
      "pinyin": "公式",
      "meaning": "official",
      "exampleSentence": "公式サイトに掲載されています。",
      "exampleSentencePinyin": "公式 saitoni掲載sareteimasu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "コマ",
      "pinyin": "koma",
      "meaning": "panel",
      "exampleSentence": "漫画の1コマです。",
      "exampleSentencePinyin": "漫画no 1 koma desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "漫画",
      "pinyin": "漫画",
      "meaning": "comic",
      "exampleSentence": "漫画を読むのが好きです。",
      "exampleSentencePinyin": "漫画 wo読munoga好kidesu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ヘブンバン劇場",
      "pinyin": "hebunban劇場",
      "meaning": "Heaven Burns Red theater",
      "exampleSentence": "ヘブンバン劇場で公演が行われます。",
      "exampleSentencePinyin": "hebunban劇場 de公演ga行waremasu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "第",
      "pinyin": "第",
      "meaning": "th",
      "exampleSentence": "第1話です。",
      "exampleSentencePinyin": "第 1話desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "話",
      "pinyin": "話",
      "meaning": "story",
      "exampleSentence": "面白い話です。",
      "exampleSentencePinyin": "面白i 話 desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "のろけ",
      "pinyin": "noroke",
      "meaning": "gripe",
      "exampleSentence": "のろけが好きです。",
      "exampleSentencePinyin": "noroke ga好kidesu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "シャロ",
      "pinyin": "sharo",
      "meaning": "Sharo",
      "exampleSentence": "シャロは可愛いです。",
      "exampleSentencePinyin": "sharo ha可愛idesu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "の",
      "pinyin": "no",
      "meaning": "of",
      "exampleSentence": "それはのです。",
      "exampleSentencePinyin": "soreha no desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "撮影技術",
      "pinyin": "撮影技術",
      "meaning": "photography technique",
      "exampleSentence": "撮影技術がすごいです。",
      "exampleSentencePinyin": "撮影技術 gasugoidesu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "は",
      "pinyin": "ha",
      "meaning": "topic marker",
      "exampleSentence": "彼は学生です。",
      "exampleSentencePinyin": "彼 ha 学生desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "すごい",
      "pinyin": "sugoi",
      "meaning": "amazing",
      "exampleSentence": "すごいですね！",
      "exampleSentencePinyin": "sugoi desune!",
      "pinyinSource": "library"
    },
    {
      "hanzi": "今まで",
      "pinyin": "今made",
      "meaning": "until now",
      "exampleSentence": "今までの経験です。",
      "exampleSentencePinyin": "今made no経験desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "お話",
      "pinyin": "o話",
      "meaning": "story",
      "exampleSentence": "面白いお話です。",
      "exampleSentencePinyin": "面白i o話 desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "こちら",
      "pinyin": "kochira",
      "meaning": "here",
      "exampleSentence": "こちらへ来てください。",
      "exampleSentencePinyin": "kochira he来tekudasai。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "作画",
      "pinyin": "作画",
      "meaning": "artwork",
      "exampleSentence": "作画は津留崎優さんです。",
      "exampleSentencePinyin": "作画 ha津留崎優sandesu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "津留崎優",
      "pinyin": "津留崎優",
      "meaning": "Yū Tsuruzaki",
      "exampleSentence": "津留崎優さんが描きました。",
      "exampleSentencePinyin": "津留崎優 sanga描kimashita。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "さん",
      "pinyin": "san",
      "meaning": "san",
      "exampleSentence": "田中さんです。",
      "exampleSentencePinyin": "田中 san desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ヘブンバン",
      "pinyin": "hebunban",
      "meaning": "Heaven Burns Red",
      "exampleSentence": "ヘブンバンは人気です。",
      "exampleSentencePinyin": "hebunban ha人気desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "4コマ",
      "pinyin": "4 koma",
      "meaning": "four-panel",
      "exampleSentence": "4コマ漫画が好きです。",
      "exampleSentencePinyin": "4 koma 漫画ga好kidesu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "第108話",
      "pinyin": "第1 0 8話",
      "meaning": "episode 108",
      "exampleSentence": "第108話を読んだ。",
      "exampleSentencePinyin": "第1 0 8話 wo読nda。",
      "pinyinSource": "library"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "公式",
  "pinyin": "gōng shì",
  "meaning": "official;official (as an adjective/noun)",
  "notes": "Used as a noun meaning \"official\" or \"official version\"; often appears in compound words like 公式サイト (official website).",
  "examples": [
    "公式の発表があった。",
    "公式のルールに従ってください。",
    "彼は公式の立場から発言した。"
  ],
  "pinyinSource": "library"
}
```

## 52. 1730196408827jp.png | ja | nvidia/nemotron-nano-12b-v2-vl:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `ja`
- Analyze endpoint: status=200, latency=117.44s
- Explain endpoint: status=200, latency=6.89s

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=True, attempts=1, latency=22.39s, prompt_tokens=1680, completion_tokens=778, total_tokens=2458, t/s=34.74
- `text analysis` via `nvidia/nemotron-3-nano-30b-a3b:free`: ok=True, attempts=1, latency=43.02s, prompt_tokens=870, completion_tokens=8289, total_tokens=9159, t/s=192.70
- `glossary enrichment` via `nvidia/nemotron-3-nano-30b-a3b:free`: ok=True, attempts=1, latency=52.02s, prompt_tokens=754, completion_tokens=9889, total_tokens=10643, t/s=190.11

### Vision Output
```json
{
  "documentText": "公式4コマ漫画【ヘブンバーンズレッド公式】\n第108話「のろけ」\nシャロの撮影技術はすごい！\n今までのお話はこちら→x.com/heavenburnsred...\n作画:津留崎優 @hatori_niwatoriさん\n#ヘブン #ヘブン劇場\n\nガーディアンテールズ公式\n【かんたべりーでぃいず！】\nガーディアンテールズの4コマ漫画\n#かんたべりーでぃいずの第140話「コンビニニは今日も平和です」を公開！\n今後もさまざまな英雄たちの日常をお送りしていきます。\n作者：純粋な不純物(@parang9494)先生\n#ガーディアンテイルズ #ガーデル",
  "language": "ja",
  "readingLines": [
    "公式4コマ漫画【ヘブンバーンズレッド公式】",
    "第108話「のろけ」",
    "シャロの撮影技術はすごい！",
    "今までのお話はこちら→x.com/heavenburnsred...",
    "作画:津留崎優 @hatori_niwatoriさん",
    "#ヘブン #ヘブン劇場",
    "",
    "ガーディアンテールズ公式",
    "【かんたべりーでぃいず！】",
    "ガーディアンテールズの4コマ漫画",
    "#かんたべりーでぃいずの第140話「コンビニニは今日も平和です」を公開！",
    "今後もさまざまな英雄たちの日常をお送りしていきます。",
    "作者：純粋な不純物(@parang9494)先生",
    "#ガーディアンテイルズ #ガーデル"
  ],
  "pronunciationHints": [
    {
      "phrase": "公式",
      "preferredPinyin": "kōshiki",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "コンビニニ",
      "preferredPinyin": "konbinini",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    }
  ],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [
    {
      "hanzi": "公式4コマ漫画【ヘブンバーンズレッド公式】",
      "translation": "Official 4-panel manga [Heaven Burns Red official].",
      "tokens": [
        {
          "text": "公式",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "4コマ",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "漫画",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "【",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "ヘブンバーンズレッド公式",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "】",
          "kind": "punctuation",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "第108話「のろけ」",
      "translation": "Episode 108 titled \"Noro-ke\".",
      "tokens": [
        {
          "text": "第108話",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "「",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "のろけ",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "」",
          "kind": "punctuation",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "シャロの撮影技術はすごい！",
      "translation": "Sharo's photography technique is amazing!",
      "tokens": [
        {
          "text": "シャロ",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "の",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "撮影技術",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "は",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "すごい",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "！",
          "kind": "punctuation",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "今までのお話はこちら→x.com/heavenburnsred...",
      "translation": "All previous stories are here → x.com/heavenburnsred...",
      "tokens": [
        {
          "text": "今までのお話はこちら",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "→",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "x.com/heavenburnsred...",
          "kind": "phrase",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "作画:津留崎優 @hatori_niwatoriさん",
      "translation": "Art by Yō Tsuruzaki @hatori_niwatori.",
      "tokens": [
        {
          "text": "作画",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "：",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "津留崎優",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "@hatori_niwatoriさん",
          "kind": "phrase",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "#ヘブン #ヘブン劇場",
      "translation": "#Heaven #Heaven Theater",
      "tokens": [
        {
          "text": "#ヘブン",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "#ヘブン劇場",
          "kind": "phrase",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "ガーディアンテールズ公式",
      "translation": "Guardian Tales official.",
      "tokens": [
        {
          "text": "ガーディアンテールズ",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "公式",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "【かんたべりーでぃいず！】",
      "translation": "Kan-tabe-ri-diz!",
      "tokens": [
        {
          "text": "【",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "かんたべりーでぃいず",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "！",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "】",
          "kind": "punctuation",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "ガーディアンテールズの4コマ漫画",
      "translation": "Guardian Tales' 4-panel manga.",
      "tokens": [
        {
          "text": "ガーディアンテールズ",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "の",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "4コマ",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "漫画",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "#かんたべりーでぃいずの第140話「コンビニニは今日も平和です」を公開！",
      "translation": "Kan-tabe-ri-diz #140 'Konbini-ni is peaceful today' published!",
      "tokens": [
        {
          "text": "#かんたべりーでぃいず",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "の",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "第140話",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "「",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "コンビニニ",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "は",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "今日も",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "平和です",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "」",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "を公開",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "！",
          "kind": "punctuation",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます。",
      "translation": "We will continue to share the daily lives of various heroes.",
      "tokens": [
        {
          "text": "今後も",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "さまざまな",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "英雄たち",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "の",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "日常",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "を",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "お送りしていきます",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "。",
          "kind": "punctuation",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "作者：純粋な不純物(@parang9494)先生",
      "translation": "Author: Pure Impurity (@parang9494).",
      "tokens": [
        {
          "text": "作者",
          "kind": "word",
          "meaning": null
        },
        {
          "text": "：",
          "kind": "punctuation",
          "meaning": null
        },
        {
          "text": "純粋な不純物",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "(@parang9494)",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "先生",
          "kind": "word",
          "meaning": null
        }
      ]
    },
    {
      "hanzi": "#ガーディアンテイルズ #ガーデル",
      "translation": "#Guardian Tales #Garder.",
      "tokens": [
        {
          "text": "#ガーディアンテイルズ",
          "kind": "phrase",
          "meaning": null
        },
        {
          "text": "#ガーデル",
          "kind": "phrase",
          "meaning": null
        }
      ]
    }
  ],
  "glossary": [
    {
      "text": "公式",
      "meaning": null
    },
    {
      "text": "4コマ",
      "meaning": null
    },
    {
      "text": "漫画",
      "meaning": null
    },
    {
      "text": "ヘブンバーンズレッド",
      "meaning": null
    },
    {
      "text": "撮影技術",
      "meaning": null
    },
    {
      "text": "シャロ",
      "meaning": null
    },
    {
      "text": "作画",
      "meaning": null
    },
    {
      "text": "津留崎優",
      "meaning": null
    },
    {
      "text": "ヘブン",
      "meaning": null
    },
    {
      "text": "ガーディアンテールズ",
      "meaning": null
    },
    {
      "text": "かんたべりーでぃいず",
      "meaning": null
    },
    {
      "text": "コンビニニ",
      "meaning": null
    },
    {
      "text": "英雄",
      "meaning": null
    },
    {
      "text": "日常",
      "meaning": null
    },
    {
      "text": "作者",
      "meaning": null
    },
    {
      "text": "不純物",
      "meaning": null
    },
    {
      "text": "先生",
      "meaning": null
    }
  ],
  "pronunciationHints": [
    {
      "phrase": "公式",
      "preferredPinyin": "kōshiki",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "コンビニニ",
      "preferredPinyin": "konbinini",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "撮影技術",
      "preferredPinyin": "satsuei gijutsu",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "作者",
      "preferredPinyin": "sāsha",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "不純物",
      "preferredPinyin": "fujunbutsu",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "先生",
      "preferredPinyin": "sensei",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    },
    {
      "phrase": "英雄",
      "preferredPinyin": "eiyū",
      "toneNumberPinyin": null,
      "reason": null,
      "confidence": 0.0
    }
  ]
}
```

### Glossary Enrichment Output
```json
{
  "entries": [
    {
      "text": "公式",
      "literalMeaning": "official",
      "exampleSentence": "公式の発表があった。"
    },
    {
      "text": "コマ",
      "literalMeaning": "panel",
      "exampleSentence": "コマが一枚描かれた。"
    },
    {
      "text": "漫画",
      "literalMeaning": "comic",
      "exampleSentence": "漫画は面白い。"
    },
    {
      "text": "ヘブンバーンズレッド公式",
      "literalMeaning": "Heaven Burns Red official",
      "exampleSentence": "ヘブンバーンズレッド公式のサイトがある。"
    },
    {
      "text": "第",
      "literalMeaning": "volume",
      "exampleSentence": "第1話が発売された。"
    },
    {
      "text": "話",
      "literalMeaning": "story",
      "exampleSentence": "話が続く。"
    },
    {
      "text": "のろけ",
      "literalMeaning": "flattery",
      "exampleSentence": "のろけが多い。"
    },
    {
      "text": "シャロ",
      "literalMeaning": "Sharo",
      "exampleSentence": "シャロは可愛い。"
    },
    {
      "text": "の",
      "literalMeaning": "of",
      "exampleSentence": "のが好きだ。"
    },
    {
      "text": "撮影技術",
      "literalMeaning": "photography technique",
      "exampleSentence": "撮影技術が向上した。"
    },
    {
      "text": "は",
      "literalMeaning": "as for",
      "exampleSentence": "は重要だ。"
    },
    {
      "text": "すごい",
      "literalMeaning": "awesome",
      "exampleSentence": "すごいね！"
    },
    {
      "text": "今までのお話はこちら",
      "literalMeaning": "Here are the previous stories",
      "exampleSentence": "今までのお話はこちら。"
    },
    {
      "text": "作画",
      "literalMeaning": "illustration",
      "exampleSentence": "作画が完成した。"
    },
    {
      "text": "津留崎優",
      "literalMeaning": "Yū Tsuruzaki",
      "exampleSentence": "津留崎優さんが描いた。"
    },
    {
      "text": "さん",
      "literalMeaning": "san",
      "exampleSentence": "さんが来た。"
    },
    {
      "text": "ヘブン",
      "literalMeaning": "Heaven",
      "exampleSentence": "ヘブンが好きだ。"
    },
    {
      "text": "ヘブン劇場",
      "literalMeaning": "Heaven Theater",
      "exampleSentence": "ヘブン劇場で上映中。"
    },
    {
      "text": "ガーディアンテールズ",
      "literalMeaning": "Guardian Tales",
      "exampleSentence": "ガーディアンテールズが人気だ。"
    },
    {
      "text": "かんたべりーでぃいず",
      "literalMeaning": "candy be ready",
      "exampleSentence": "かんたべりーでぃいずが更新された。"
    },
    {
      "text": "コンビニニ",
      "literalMeaning": "convenience store",
      "exampleSentence": "コンビニニが近い。"
    },
    {
      "text": "今日も",
      "literalMeaning": "also today",
      "exampleSentence": "今日も天気がいい。"
    },
    {
      "text": "平和です",
      "literalMeaning": "is peaceful",
      "exampleSentence": "平和です。"
    },
    {
      "text": "を公開",
      "literalMeaning": "to be released",
      "exampleSentence": "ニュースを公開した。"
    },
    {
      "text": "今後も",
      "literalMeaning": "also in the future",
      "exampleSentence": "今後も続ける。"
    },
    {
      "text": "さまざまな",
      "literalMeaning": "various",
      "exampleSentence": "さまざまな選択肢がある。"
    },
    {
      "text": "英雄たち",
      "literalMeaning": "heroes",
      "exampleSentence": "英雄たちが集まった。"
    },
    {
      "text": "日常",
      "literalMeaning": "daily life",
      "exampleSentence": "日常が忙しい。"
    },
    {
      "text": "を",
      "literalMeaning": "as object",
      "exampleSentence": "を好きだ。"
    },
    {
      "text": "お送りしていきます",
      "literalMeaning": "will be delivered",
      "exampleSentence": "お送りしていきます。"
    },
    {
      "text": "作者",
      "literalMeaning": "author",
      "exampleSentence": "作者が決まった。"
    },
    {
      "text": "純粋な不純物",
      "literalMeaning": "pure impurity",
      "exampleSentence": "純粋な不純物が混ざった。"
    },
    {
      "text": "先生",
      "literalMeaning": "teacher",
      "exampleSentence": "先生が来た。"
    },
    {
      "text": "ガーデル",
      "literalMeaning": "Garder",
      "exampleSentence": "ガーデルが開いた。"
    },
    {
      "text": "4コマ",
      "literalMeaning": "four-panel",
      "exampleSentence": "4コマ漫画を描いた。"
    },
    {
      "text": "ヘブンバーンズレッド",
      "literalMeaning": "Heaven Burns Red",
      "exampleSentence": "ヘブンバーンズレッドが発売された。"
    },
    {
      "text": "英雄",
      "literalMeaning": "hero",
      "exampleSentence": "英雄が英雄的だ。"
    },
    {
      "text": "不純物",
      "literalMeaning": "impurity",
      "exampleSentence": "不純物が残った。"
    }
  ]
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "公式4コマ漫画【ヘブンバーンズレッド公式】\n第108話「のろけ」\nシャロの撮影技術はすごい！\n今までのお話はこちら→x.com/heavenburnsred...\n作画:津留崎優 @hatori_niwatoriさん\n#ヘブン #ヘブン劇場\n\nガーディアンテールズ公式\n【かんたべりーでぃいず！】\nガーディアンテールズの4コマ漫画\n#かんたべりーでぃいずの第140話「コンビニニは今日も平和です」を公開！\n今後もさまざまな英雄たちの日常をお送りしていきます。\n作者：純粋な不純物(@parang9494)先生\n#ガーディアンテイルズ #ガーデル",
  "language": "ja",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "公式コマ漫画ヘブンバーンズレッド公式",
      "pinyin": "kōshiki koma 漫画 hebunbaanzureddo公式",
      "translation": "Official 4-panel manga [Heaven Burns Red official].",
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "公式",
          "pinyin": "kōshiki",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s1-t2",
          "hanzi": "コマ",
          "pinyin": "koma",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t3",
          "hanzi": "漫画",
          "pinyin": "漫画",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t4",
          "hanzi": "ヘブンバーンズレッド公式",
          "pinyin": "hebunbaanzureddo公式",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "第話のろけ",
      "pinyin": "第 話 noroke",
      "translation": "Episode 108 titled \"Noro-ke\".",
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "第",
          "pinyin": "第",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t2",
          "hanzi": "話",
          "pinyin": "話",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t3",
          "hanzi": "のろけ",
          "pinyin": "noroke",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "シャロの撮影技術はすごい！",
      "pinyin": "sharo no satsuei gijutsu ha sugoi！",
      "translation": "Sharo's photography technique is amazing!",
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "シャロ",
          "pinyin": "sharo",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t2",
          "hanzi": "の",
          "pinyin": "no",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t3",
          "hanzi": "撮影技術",
          "pinyin": "satsuei gijutsu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s3-t4",
          "hanzi": "は",
          "pinyin": "ha",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t5",
          "hanzi": "すごい",
          "pinyin": "sugoi",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t6",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s4",
      "hanzi": "今までのお話はこちら",
      "pinyin": "今madenoo話hakochira",
      "translation": "All previous stories are here → x.com/heavenburnsred...",
      "tokens": [
        {
          "id": "s4-t1",
          "hanzi": "今までのお話はこちら",
          "pinyin": "今madenoo話hakochira",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s5",
      "hanzi": "作画：津留崎優さん",
      "pinyin": "作画： 津留崎優 san",
      "translation": "Art by Yō Tsuruzaki @hatori_niwatori.",
      "tokens": [
        {
          "id": "s5-t1",
          "hanzi": "作画",
          "pinyin": "作画",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t2",
          "hanzi": "：",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t3",
          "hanzi": "津留崎優",
          "pinyin": "津留崎優",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s5-t4",
          "hanzi": "さん",
          "pinyin": "san",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s6",
      "hanzi": "ヘブンヘブン劇場",
      "pinyin": "hebun hebun劇場",
      "translation": "#Heaven #Heaven Theater",
      "tokens": [
        {
          "id": "s6-t1",
          "hanzi": "ヘブン",
          "pinyin": "hebun",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s6-t2",
          "hanzi": "ヘブン劇場",
          "pinyin": "hebun劇場",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s7",
      "hanzi": "ガーディアンテールズ公式",
      "pinyin": "gaadianteeruzu kōshiki",
      "translation": "Guardian Tales official.",
      "tokens": [
        {
          "id": "s7-t1",
          "hanzi": "ガーディアンテールズ",
          "pinyin": "gaadianteeruzu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s7-t2",
          "hanzi": "公式",
          "pinyin": "kōshiki",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "text_model_hint"
        }
      ]
    },
    {
      "id": "s8",
      "hanzi": "かんたべりーでぃいず！",
      "pinyin": "kantaberiidiizu！",
      "translation": "Kan-tabe-ri-diz!",
      "tokens": [
        {
          "id": "s8-t1",
          "hanzi": "かんたべりーでぃいず",
          "pinyin": "kantaberiidiizu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s8-t2",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s9",
      "hanzi": "ガーディアンテールズのコマ漫画",
      "pinyin": "gaadianteeruzu no koma 漫画",
      "translation": "Guardian Tales' 4-panel manga.",
      "tokens": [
        {
          "id": "s9-t1",
          "hanzi": "ガーディアンテールズ",
          "pinyin": "gaadianteeruzu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t2",
          "hanzi": "の",
          "pinyin": "no",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t3",
          "hanzi": "コマ",
          "pinyin": "koma",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s9-t4",
          "hanzi": "漫画",
          "pinyin": "漫画",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s10",
      "hanzi": "かんたべりーでぃいずの第話コンビニニは今日も平和ですを公開！",
      "pinyin": "kantaberiidiizu no 第 話 konbinini ha 今日mo 平和desu wo公開！",
      "translation": "Kan-tabe-ri-diz #140 'Konbini-ni is peaceful today' published!",
      "tokens": [
        {
          "id": "s10-t1",
          "hanzi": "かんたべりーでぃいず",
          "pinyin": "kantaberiidiizu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t2",
          "hanzi": "の",
          "pinyin": "no",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t3",
          "hanzi": "第",
          "pinyin": "第",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t4",
          "hanzi": "話",
          "pinyin": "話",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t5",
          "hanzi": "コンビニニ",
          "pinyin": "konbinini",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s10-t6",
          "hanzi": "は",
          "pinyin": "ha",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t7",
          "hanzi": "今日も",
          "pinyin": "今日mo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t8",
          "hanzi": "平和です",
          "pinyin": "平和desu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t9",
          "hanzi": "を公開",
          "pinyin": "wo公開",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s10-t10",
          "hanzi": "！",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s11",
      "hanzi": "今後もさまざまな英雄たちの日常をお送りしていきます。",
      "pinyin": "今後mo samazamana 英雄tachi no 日常 wo o送rishiteikimasu。",
      "translation": "We will continue to share the daily lives of various heroes.",
      "tokens": [
        {
          "id": "s11-t1",
          "hanzi": "今後も",
          "pinyin": "今後mo",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t2",
          "hanzi": "さまざまな",
          "pinyin": "samazamana",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t3",
          "hanzi": "英雄たち",
          "pinyin": "英雄tachi",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t4",
          "hanzi": "の",
          "pinyin": "no",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t5",
          "hanzi": "日常",
          "pinyin": "日常",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t6",
          "hanzi": "を",
          "pinyin": "wo",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t7",
          "hanzi": "お送りしていきます",
          "pinyin": "o送rishiteikimasu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s11-t8",
          "hanzi": "。",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s12",
      "hanzi": "作者：純粋な不純物先生",
      "pinyin": "sāsha： 純粋na不純物 sensei",
      "translation": "Author: Pure Impurity (@parang9494).",
      "tokens": [
        {
          "id": "s12-t1",
          "hanzi": "作者",
          "pinyin": "sāsha",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s12-t2",
          "hanzi": "：",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        },
        {
          "id": "s12-t3",
          "hanzi": "純粋な不純物",
          "pinyin": "純粋na不純物",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s12-t4",
          "hanzi": "先生",
          "pinyin": "sensei",
          "meaning": null,
          "kind": "word",
          "pinyinSource": "text_model_hint"
        }
      ]
    },
    {
      "id": "s13",
      "hanzi": "ガーディアンテイルズガーデル",
      "pinyin": "gaadianteiruzu gaaderu",
      "translation": "#Guardian Tales #Garder.",
      "tokens": [
        {
          "id": "s13-t1",
          "hanzi": "ガーディアンテイルズ",
          "pinyin": "gaadianteiruzu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s13-t2",
          "hanzi": "ガーデル",
          "pinyin": "gaaderu",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "公式",
      "pinyin": "kōshiki",
      "meaning": "official",
      "exampleSentence": "公式の発表があった。",
      "exampleSentencePinyin": "kōshiki no発表gaatta。",
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "コマ",
      "pinyin": "koma",
      "meaning": "panel",
      "exampleSentence": "コマが一枚描かれた。",
      "exampleSentencePinyin": "koma ga一枚描kareta。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "漫画",
      "pinyin": "漫画",
      "meaning": "comic",
      "exampleSentence": "漫画は面白い。",
      "exampleSentencePinyin": "漫画 ha面白i。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ヘブンバーンズレッド公式",
      "pinyin": "hebunbaanzureddo公式",
      "meaning": "Heaven Burns Red official",
      "exampleSentence": "ヘブンバーンズレッド公式のサイトがある。",
      "exampleSentencePinyin": "hebunbaanzureddo公式 nosaitogaaru。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "第",
      "pinyin": "第",
      "meaning": "volume",
      "exampleSentence": "第1話が発売された。",
      "exampleSentencePinyin": "第 1話ga発売sareta。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "話",
      "pinyin": "話",
      "meaning": "story",
      "exampleSentence": "話が続く。",
      "exampleSentencePinyin": "話 ga続ku。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "のろけ",
      "pinyin": "noroke",
      "meaning": "flattery",
      "exampleSentence": "のろけが多い。",
      "exampleSentencePinyin": "noroke ga多i。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "シャロ",
      "pinyin": "sharo",
      "meaning": "Sharo",
      "exampleSentence": "シャロは可愛い。",
      "exampleSentencePinyin": "sharo ha可愛i。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "の",
      "pinyin": "no",
      "meaning": "of",
      "exampleSentence": "のが好きだ。",
      "exampleSentencePinyin": "no ga好kida。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "撮影技術",
      "pinyin": "satsuei gijutsu",
      "meaning": "photography technique",
      "exampleSentence": "撮影技術が向上した。",
      "exampleSentencePinyin": "satsuei gijutsu ga向上shita。",
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "は",
      "pinyin": "ha",
      "meaning": "as for",
      "exampleSentence": "は重要だ。",
      "exampleSentencePinyin": "ha 重要da。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "すごい",
      "pinyin": "sugoi",
      "meaning": "awesome",
      "exampleSentence": "すごいね！",
      "exampleSentencePinyin": "sugoi ne!",
      "pinyinSource": "library"
    },
    {
      "hanzi": "今までのお話はこちら",
      "pinyin": "今madenoo話hakochira",
      "meaning": "Here are the previous stories",
      "exampleSentence": "今までのお話はこちら。",
      "exampleSentencePinyin": "今madenoo話hakochira。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "作画",
      "pinyin": "作画",
      "meaning": "illustration",
      "exampleSentence": "作画が完成した。",
      "exampleSentencePinyin": "作画 ga完成shita。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "津留崎優",
      "pinyin": "津留崎優",
      "meaning": "Yū Tsuruzaki",
      "exampleSentence": "津留崎優さんが描いた。",
      "exampleSentencePinyin": "津留崎優 sanga描ita。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "さん",
      "pinyin": "san",
      "meaning": "san",
      "exampleSentence": "さんが来た。",
      "exampleSentencePinyin": "san ga来ta。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ヘブン",
      "pinyin": "hebun",
      "meaning": "Heaven",
      "exampleSentence": "ヘブンが好きだ。",
      "exampleSentencePinyin": "hebun ga好kida。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ヘブン劇場",
      "pinyin": "hebun劇場",
      "meaning": "Heaven Theater",
      "exampleSentence": "ヘブン劇場で上映中。",
      "exampleSentencePinyin": "hebun劇場 de上映中。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーディアンテールズ",
      "pinyin": "gaadianteeruzu",
      "meaning": "Guardian Tales",
      "exampleSentence": "ガーディアンテールズが人気だ。",
      "exampleSentencePinyin": "gaadianteeruzu ga人気da。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "かんたべりーでぃいず",
      "pinyin": "kantaberiidiizu",
      "meaning": "candy be ready",
      "exampleSentence": "かんたべりーでぃいずが更新された。",
      "exampleSentencePinyin": "kantaberiidiizu ga更新sareta。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "コンビニニ",
      "pinyin": "konbinini",
      "meaning": "convenience store",
      "exampleSentence": "コンビニニが近い。",
      "exampleSentencePinyin": "konbinini ga近i。",
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "今日も",
      "pinyin": "今日mo",
      "meaning": "also today",
      "exampleSentence": "今日も天気がいい。",
      "exampleSentencePinyin": "今日mo 天気gaii。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "平和です",
      "pinyin": "平和desu",
      "meaning": "is peaceful",
      "exampleSentence": "平和です。",
      "exampleSentencePinyin": "平和desu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "を公開",
      "pinyin": "wo公開",
      "meaning": "to be released",
      "exampleSentence": "ニュースを公開した。",
      "exampleSentencePinyin": "nyuusu wo公開 shita。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "今後も",
      "pinyin": "今後mo",
      "meaning": "also in the future",
      "exampleSentence": "今後も続ける。",
      "exampleSentencePinyin": "今後mo 続keru。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "さまざまな",
      "pinyin": "samazamana",
      "meaning": "various",
      "exampleSentence": "さまざまな選択肢がある。",
      "exampleSentencePinyin": "samazamana 選択肢gaaru。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "英雄たち",
      "pinyin": "英雄tachi",
      "meaning": "heroes",
      "exampleSentence": "英雄たちが集まった。",
      "exampleSentencePinyin": "英雄tachi ga集matta。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "日常",
      "pinyin": "日常",
      "meaning": "daily life",
      "exampleSentence": "日常が忙しい。",
      "exampleSentencePinyin": "日常 ga忙shii。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "を",
      "pinyin": "wo",
      "meaning": "as object",
      "exampleSentence": "を好きだ。",
      "exampleSentencePinyin": "wo 好kida。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "お送りしていきます",
      "pinyin": "o送rishiteikimasu",
      "meaning": "will be delivered",
      "exampleSentence": "お送りしていきます。",
      "exampleSentencePinyin": "o送rishiteikimasu。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "作者",
      "pinyin": "sāsha",
      "meaning": "author",
      "exampleSentence": "作者が決まった。",
      "exampleSentencePinyin": "sāsha ga決matta。",
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "純粋な不純物",
      "pinyin": "純粋na不純物",
      "meaning": "pure impurity",
      "exampleSentence": "純粋な不純物が混ざった。",
      "exampleSentencePinyin": "純粋na不純物 ga混zatta。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "先生",
      "pinyin": "sensei",
      "meaning": "teacher",
      "exampleSentence": "先生が来た。",
      "exampleSentencePinyin": "sensei ga来ta。",
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "ガーディアンテイルズ",
      "pinyin": "gaadianteiruzu",
      "meaning": null,
      "exampleSentence": null,
      "exampleSentencePinyin": null,
      "pinyinSource": "library"
    },
    {
      "hanzi": "ガーデル",
      "pinyin": "gaaderu",
      "meaning": "Garder",
      "exampleSentence": "ガーデルが開いた。",
      "exampleSentencePinyin": "gaaderu ga開ita。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "4コマ",
      "pinyin": "4 koma",
      "meaning": "four-panel",
      "exampleSentence": "4コマ漫画を描いた。",
      "exampleSentencePinyin": "4 koma 漫画wo描ita。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "ヘブンバーンズレッド",
      "pinyin": "hebunbaanzureddo",
      "meaning": "Heaven Burns Red",
      "exampleSentence": "ヘブンバーンズレッドが発売された。",
      "exampleSentencePinyin": "hebunbaanzureddo ga発売sareta。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "英雄",
      "pinyin": "eiyū",
      "meaning": "hero",
      "exampleSentence": "英雄が英雄的だ。",
      "exampleSentencePinyin": "eiyū ga eiyū 的da。",
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "不純物",
      "pinyin": "fujunbutsu",
      "meaning": "impurity",
      "exampleSentence": "不純物が残った。",
      "exampleSentencePinyin": "fujunbutsu ga残tta。",
      "pinyinSource": "text_model_hint"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "公式",
  "pinyin": "gōng shì",
  "meaning": "official; official (as in official source, official rules)",
  "notes": null,
  "examples": [
    "このゲームの公式はとても厳しいです。",
    "公式の発表があった。",
    "公式のルールに従ってください。"
  ],
  "pinyinSource": "library"
}
```

## 53. o08000924109524428441jp.jpg | auto | nvidia/nemotron-nano-12b-v2-vl:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `ja`
- Analyze endpoint: status=502, latency=255.95s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=False, attempts=1, latency=255.93s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: Could not reach OpenRouter.

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 54. o08000924109524428441jp.jpg | ja | nvidia/nemotron-nano-12b-v2-vl:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `ja`
- Analyze endpoint: status=502, latency=255.90s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=False, attempts=1, latency=255.89s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: Could not reach OpenRouter.

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 55. The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | auto | nvidia/nemotron-nano-12b-v2-vl:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=254.96s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=False, attempts=1, latency=254.96s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: Could not reach OpenRouter.

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 56. The-front-page-of-a-daily-Chinese-newspaper-from-a-local-Chinese-store-The.webp | zh | nvidia/nemotron-nano-12b-v2-vl:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=156.56s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=False, attempts=1, latency=156.55s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: Could not reach OpenRouter.

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 57. weibo_6_toutiao_comparison.jpg | auto | nvidia/nemotron-nano-12b-v2-vl:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=154.85s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=False, attempts=1, latency=154.84s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: Could not reach OpenRouter.

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 58. weibo_6_toutiao_comparison.jpg | zh | nvidia/nemotron-nano-12b-v2-vl:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=131.29s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=False, attempts=1, latency=131.27s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: Could not reach OpenRouter.

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 59. weibo_kol_1.jpg | auto | nvidia/nemotron-nano-12b-v2-vl:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=502, latency=56.11s
- Explain endpoint: status=n/a, latency=n/a

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=False, attempts=1, latency=56.11s, prompt_tokens=n/a, completion_tokens=n/a, total_tokens=n/a, t/s=n/a
  error: Could not reach OpenRouter.

### Vision Output
```json
null
```

### Text Output
```json
null
```

### Glossary Enrichment Output
```json
null
```

### Analyze Endpoint Output
```json
{
  "detail": "Vision extraction service is currently unavailable."
}
```

### Explain Endpoint Output
```json
null
```

## 60. weibo_kol_1.jpg | zh | nvidia/nemotron-nano-12b-v2-vl:free + nvidia/nemotron-3-nano-30b-a3b:free

- Expected primary language: `zh`
- Analyze endpoint: status=200, latency=1234.56s
- Explain endpoint: status=200, latency=327.94s

### Stages
- `vision extraction` via `nvidia/nemotron-nano-12b-v2-vl:free`: ok=True, attempts=1, latency=946.70s, prompt_tokens=1918, completion_tokens=10125, total_tokens=12043, t/s=10.70
- `text analysis` via `nvidia/nemotron-3-nano-30b-a3b:free`: ok=True, attempts=1, latency=279.77s, prompt_tokens=6877, completion_tokens=65536, total_tokens=72413, t/s=234.25
- `glossary enrichment` via `nvidia/nemotron-3-nano-30b-a3b:free`: ok=True, attempts=1, latency=8.02s, prompt_tokens=6683, completion_tokens=1796, total_tokens=8479, t/s=223.91

### Vision Output
```json
{
  "documentText": "15:33\nSearch\nFollowing\nhot\n+1\nYesterday 19:25 from 識側视频\n总么能认了一砮菜之20场长变成200场长呼?\n静肉妮奈超语 #静肉妮奈品味小知访# @““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““",
  "language": "zh-Hans",
  "readingLines": [
    "15:33",
    "Search",
    "Following",
    "hot",
    "+1",
    "Yesterday 19:25 from 識側视频",
    "总么能认了一砮菜之20场长变成200场长呼?",
    "静肉妮奈超语 #静肉妮奈品味小知访# @““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““"
  ],
  "pronunciationHints": [],
  "warnings": []
}
```

### Text Output
```json
{
  "sentences": [],
  "glossary": [],
  "pronunciationHints": []
}
```

### Glossary Enrichment Output
```json
{
  "entries": [
    {
      "text": "識側视频",
      "literalMeaning": "recognize side video",
      "exampleSentence": "他在識側视频里发现线索。"
    },
    {
      "text": "总么能认了一砮菜之",
      "literalMeaning": "how can one recognize a dish",
      "exampleSentence": "总么能认了一砮菜之才能通过考试。"
    },
    {
      "text": "场长变成",
      "literalMeaning": "scene becomes longer",
      "exampleSentence": "这个故事场长变成了两小时。"
    },
    {
      "text": "场长呼",
      "literalMeaning": "scene long call",
      "exampleSentence": "场长呼时大家都安静。"
    },
    {
      "text": "静肉妮奈超语",
      "literalMeaning": "quiet meat super language",
      "exampleSentence": "她喜欢静肉妮奈超语。"
    },
    {
      "text": "静肉妮奈品味小知访",
      "literalMeaning": "quiet meat super taste small know visit",
      "exampleSentence": "他在静肉妮奈品味小知访中学习。"
    }
  ]
}
```

### Analyze Endpoint Output
```json
{
  "documentText": "15:33\nSearch\nFollowing\nhot\n+1\nYesterday 19:25 from 識側视频\n总么能认了一砮菜之20场长变成200场长呼?\n静肉妮奈超语 #静肉妮奈品味小知访# @““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““““",
  "language": "zh-Hans",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "識側视频",
      "pinyin": "shí cè shì pín",
      "translation": null,
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "識側视频",
          "pinyin": "shí cè shì pín",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "总么能认了一砮菜之场长变成场长呼?",
      "pinyin": "zǒng me néng rèn le yī nǔ cài zhī chǎng zhǎng biàn chéng chǎng zhǎng hū?",
      "translation": null,
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "总么能认了一砮菜之",
          "pinyin": "zǒng me néng rèn le yī nǔ cài zhī",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t2",
          "hanzi": "场长变成",
          "pinyin": "chǎng zhǎng biàn chéng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t3",
          "hanzi": "场长呼",
          "pinyin": "chǎng zhǎng hū",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t4",
          "hanzi": "?",
          "pinyin": "",
          "meaning": null,
          "kind": "punctuation",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "静肉妮奈超语静肉妮奈品味小知访",
      "pinyin": "jìng ròu nī nài chāo yǔ jìng ròu nī nài pǐn wèi xiǎo zhī fǎng",
      "translation": null,
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "静肉妮奈超语",
          "pinyin": "jìng ròu nī nài chāo yǔ",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t2",
          "hanzi": "静肉妮奈品味小知访",
          "pinyin": "jìng ròu nī nài pǐn wèi xiǎo zhī fǎng",
          "meaning": null,
          "kind": "phrase",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "識側视频",
      "pinyin": "shí cè shì pín",
      "meaning": "recognize side video",
      "exampleSentence": "他在識側视频里发现线索。",
      "exampleSentencePinyin": "tā zài shí cè shì pín lǐ fā xiàn xiàn suǒ 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "总么能认了一砮菜之",
      "pinyin": "zǒng me néng rèn le yī nǔ cài zhī",
      "meaning": "how can one recognize a dish",
      "exampleSentence": "总么能认了一砮菜之才能通过考试。",
      "exampleSentencePinyin": "zǒng me néng rèn le yī nǔ cài zhī cái néng tōng guò kǎo shì 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "场长变成",
      "pinyin": "chǎng zhǎng biàn chéng",
      "meaning": "scene becomes longer",
      "exampleSentence": "这个故事场长变成了两小时。",
      "exampleSentencePinyin": "zhè ge gù shì chǎng zhǎng biàn chéng le liǎng xiǎo shí 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "场长呼",
      "pinyin": "chǎng zhǎng hū",
      "meaning": "scene long call",
      "exampleSentence": "场长呼时大家都安静。",
      "exampleSentencePinyin": "chǎng zhǎng hū shí dà jiā dōu ān jìng 。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "静肉妮奈超语",
      "pinyin": "jìng ròu nī nài chāo yǔ",
      "meaning": "quiet meat super language",
      "exampleSentence": "她喜欢静肉妮奈超语。",
      "exampleSentencePinyin": "tā xǐ huān jìng ròu nī nài chāo yǔ。",
      "pinyinSource": "library"
    },
    {
      "hanzi": "静肉妮奈品味小知访",
      "pinyin": "jìng ròu nī nài pǐn wèi xiǎo zhī fǎng",
      "meaning": "quiet meat super taste small know visit",
      "exampleSentence": "他在静肉妮奈品味小知访中学习。",
      "exampleSentencePinyin": "tā zài jìng ròu nī nài pǐn wèi xiǎo zhī fǎng zhōng xué xí 。",
      "pinyinSource": "library"
    }
  ],
  "warnings": []
}
```

### Explain Endpoint Output
```json
{
  "text": "識側视频",
  "pinyin": "shí cè shì pín",
  "meaning": "to identify or recognize a side video",
  "notes": "This phrase is not common; it may be a typo or a specialized term used in video analysis.",
  "examples": [
    "他在識側视频中发现了异常。",
    "该系统能够自动識側视频中的人物。"
  ],
  "pinyinSource": "library"
}
```