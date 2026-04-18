package com.hanyupinyin.core.model

import kotlinx.serialization.decodeFromString

private val sampleStudyResponse: AnalyzeImageResponse by lazy {
    StudyJson.decodeFromString<AnalyzeImageResponse>(SAMPLE_STUDY_RESPONSE_JSON)
}

fun sampleAnalyzeImageResponse(): AnalyzeImageResponse = sampleStudyResponse

private const val SAMPLE_STUDY_RESPONSE_JSON = """
{
  "documentText": "\u957f\u5927\u4ee5\u540e\uff0c\u6211\u60f3\u5f53\u8001\u5e08\u3002\u94f6\u884c\u884c\u957f\u6b63\u5728\u8bb2\u8bdd\uff0c\u5b66\u751f\u4eec\u8ba4\u771f\u5730\u542c\u3002\u5317\u4eac\u7684\u65e9\u6668\u5f88\u5b89\u9759\uff0c\u4f46\u662f\u5e02\u573a\u5df2\u7ecf\u70ed\u95f9\u8d77\u6765\u4e86\u3002",
  "language": "zh-Hans",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "\u957f\u5927\u4ee5\u540e\uff0c\u6211\u60f3\u5f53\u8001\u5e08\u3002",
      "pinyin": "zhang3 da4 yi3 hou4, wo3 xiang3 dang1 lao3 shi1.",
      "translation": "After growing up, I want to become a teacher.",
      "tokens": [
        {
          "id": "s1-t1",
          "hanzi": "\u957f\u5927",
          "pinyin": "zhang3 da4",
          "meaning": "to grow up",
          "kind": "phrase",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s1-t2",
          "hanzi": "\u4ee5\u540e",
          "pinyin": "yi3 hou4",
          "meaning": "afterward",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t3",
          "hanzi": "\u6211",
          "pinyin": "wo3",
          "meaning": "I; me",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t4",
          "hanzi": "\u60f3",
          "pinyin": "xiang3",
          "meaning": "to want; to hope",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t5",
          "hanzi": "\u5f53",
          "pinyin": "dang1",
          "meaning": "to become",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s1-t6",
          "hanzi": "\u8001\u5e08",
          "pinyin": "lao3 shi1",
          "meaning": "teacher",
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s2",
      "hanzi": "\u94f6\u884c\u884c\u957f\u6b63\u5728\u8bb2\u8bdd\uff0c\u5b66\u751f\u4eec\u8ba4\u771f\u5730\u542c\u3002",
      "pinyin": "yin2 hang2 hang2 zhang3 zheng4 zai4 jiang3 hua4, xue2 sheng1 men5 ren4 zhen1 de5 ting1.",
      "translation": "The bank manager is speaking, and the students are listening carefully.",
      "tokens": [
        {
          "id": "s2-t1",
          "hanzi": "\u94f6\u884c",
          "pinyin": "yin2 hang2",
          "meaning": "bank",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t2",
          "hanzi": "\u884c\u957f",
          "pinyin": "hang2 zhang3",
          "meaning": "manager; president of a bank",
          "kind": "word",
          "pinyinSource": "vision_hint"
        },
        {
          "id": "s2-t3",
          "hanzi": "\u6b63\u5728",
          "pinyin": "zheng4 zai4",
          "meaning": "currently; in the middle of",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t4",
          "hanzi": "\u8bb2\u8bdd",
          "pinyin": "jiang3 hua4",
          "meaning": "to speak",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t5",
          "hanzi": "\u5b66\u751f\u4eec",
          "pinyin": "xue2 sheng1 men5",
          "meaning": "students",
          "kind": "phrase",
          "pinyinSource": "library"
        },
        {
          "id": "s2-t6",
          "hanzi": "\u8ba4\u771f\u5730",
          "pinyin": "ren4 zhen1 de5",
          "meaning": "carefully; earnestly",
          "kind": "phrase",
          "pinyinSource": "text_model_hint"
        },
        {
          "id": "s2-t7",
          "hanzi": "\u542c",
          "pinyin": "ting1",
          "meaning": "to listen",
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    },
    {
      "id": "s3",
      "hanzi": "\u5317\u4eac\u7684\u65e9\u6668\u5f88\u5b89\u9759\uff0c\u4f46\u662f\u5e02\u573a\u5df2\u7ecf\u70ed\u95f9\u8d77\u6765\u4e86\u3002",
      "pinyin": "bei3 jing1 de5 zao3 chen2 hen3 an1 jing4, dan4 shi4 shi4 chang3 yi3 jing1 re4 nao4 qi3 lai2 le5.",
      "translation": "Beijing mornings are quiet, but the market is already coming alive.",
      "tokens": [
        {
          "id": "s3-t1",
          "hanzi": "\u5317\u4eac",
          "pinyin": "bei3 jing1",
          "meaning": "Beijing",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t2",
          "hanzi": "\u65e9\u6668",
          "pinyin": "zao3 chen2",
          "meaning": "morning",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t3",
          "hanzi": "\u5b89\u9759",
          "pinyin": "an1 jing4",
          "meaning": "quiet; calm",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t4",
          "hanzi": "\u4f46\u662f",
          "pinyin": "dan4 shi4",
          "meaning": "but; however",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t5",
          "hanzi": "\u5e02\u573a",
          "pinyin": "shi4 chang3",
          "meaning": "market",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t6",
          "hanzi": "\u5df2\u7ecf",
          "pinyin": "yi3 jing1",
          "meaning": "already",
          "kind": "word",
          "pinyinSource": "library"
        },
        {
          "id": "s3-t7",
          "hanzi": "\u70ed\u95f9\u8d77\u6765",
          "pinyin": "re4 nao4 qi3 lai2",
          "meaning": "to become lively",
          "kind": "phrase",
          "pinyinSource": "text_model_hint"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "\u957f\u5927",
      "pinyin": "zhang3 da4",
      "meaning": "to grow up",
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "\u884c\u957f",
      "pinyin": "hang2 zhang3",
      "meaning": "bank manager",
      "pinyinSource": "vision_hint"
    },
    {
      "hanzi": "\u5b66\u751f\u4eec",
      "pinyin": "xue2 sheng1 men5",
      "meaning": "students",
      "pinyinSource": "library"
    },
    {
      "hanzi": "\u8ba4\u771f\u5730",
      "pinyin": "ren4 zhen1 de5",
      "meaning": "carefully; earnestly",
      "pinyinSource": "text_model_hint"
    },
    {
      "hanzi": "\u70ed\u95f9\u8d77\u6765",
      "pinyin": "re4 nao4 qi3 lai2",
      "meaning": "to become lively",
      "pinyinSource": "text_model_hint"
    }
  ],
  "warnings": []
}
"""
