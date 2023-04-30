> 通过该课程可以获得什么？ 1、学习软件开发的提示词的最佳实践以及一些常用的案例（摘要、推断、转换、扩展） 2、使用LLM构建聊天机器人 3、激发对新应用的想象力

## 1、两类大语言模型（LLM）

- **基础LLM**：基于文本训练数据（互联网上的大量数据）来预测做“文字接龙”
- **指令调整LLM（Instruction Tuned LLM）**：遵循指示的培训。指令调整LLM是在基础LLM上，使用输入和输出的指令进行**微调**。通常使用RLHF（人类反馈强化学习）技术进一步优化，使系统能够更好的遵循指令，使得输出的内容更加helpful、honest、harmless。

网上的例子可能更加适合基础LLM，但是想要在生产应用中使用，还是得使用指令微调LLM。

## 2、有效编写提示词的两大关键原则

在下面的笔记中，会涉及到一些prompt和代码，所以像更好的掌握内容，可以先完成下面的步骤哈。

- 安装openai：`pip install openai`
- 导入并jupyter并定义一个方法，用户轻松获取ChatGPT的返回值。

```Python
import openai
openai.api_key = "sk-" # 填写你的api key
model = "gpt-3.5-turbo"

def get_completion(prompt, model="gpt-3.5-turbo"):
    messages = [{
        "role": "user",
        "content": prompt
    }]
    response = openai.ChatCompletion.create(
        model=model,
        messages=messages,
        temperature=0,
    )
    return response.choices[0].message["content"]


# test demo
print(get_completion("hello, who are you?"))
# output
# I am an AI language model created by OpenAI. How can I assist you today?
```

### 2.1、两大原则

- 编写明确、具体的指令：clear ≠ short；明确的指令将指导模型朝所需的方向输出。
  - **使用分隔符清楚的指示输入的不同部分。**比如使用分隔符区分指令和待处理的文本。可避免提示词与待处理文本冲突。
  - **要求结构化输出。**即在prompt的末尾要求GPT以json或者html的形式输出。
  - **要求模型模型检查是否满足条件。**
  - **少量训练提示。**比如在prompt中给一些对话任务，然后让GPT完成该对话。（比较适合写小说的场景）
- 给模型足够的时间思考：简而言之就是通过指令调整多训练一会模型，让模型输出能够让你满意。
  - 指定完成任务所需要的步骤。
  - 指示模型在匆忙做出结论之前思考解决方案。

### 2.2、模型限制

- ChatGPT的幻觉：根据晦涩难懂的prompt，编造一个不真实的，但却极其逼真的内容。
- 减少幻觉的策略：要求模型从文本中找到任何相关的引用，并要求模型根据引用来回答问题。追溯答案并回源文档可以帮助减少这些幻觉。

## 3、提示词的迭代开发

- 提示词的开发是一个迭代过程。
- 基于第2章节的提示，先写一份prompt，看看输出结果如何。
- 然后逐步根据用户、产品需求逐步改进prompt（为提示词添加更多的产品或需求描述内容），以更接近所需的结果。
- 提示词工程师的关键并不在于知道多少个“完美提示词”，而在于他**对产品的了解程度，对用户需求的了解程度，并将这种了解转化成prompt、转化成训练ChatGPT的指令。**

## 4、摘要总结

- 描述任务：总结一段文本，生成一段更加简短的内容
- 描述边界：
  - 生成内容的单词数、句子数、字符数
  - 生成内容被应用在哪个方面
  - 生成内容更加聚焦于哪些属性
  - 生成内容的适用人群
- 描述待处理文本
- 以上步骤通过分隔符（换行符）分割

```Python
prod_review = """
Got this panda plush toy for my daughter's birthday, \
who loves it and takes it everywhere. It's soft and \ 
super cute, and its face has a friendly look. It's \ 
a bit small for what I paid though. I think there \ 
might be other options that are bigger for the \ 
same price. It arrived a day earlier than expected, \ 
so I got to play with it myself before I gave it \ 
to her.
"""

# 单词数、句子数、字符数
prompt=f"""
Your task is to generate a short summary of a product \
review from an ecommerce site.

Summarize the review below, delimited by triple \ 
backticks, in **at most 30 words**.

Review: ```{prod_review}```
"""

# 生成内容被应用在哪个方面
prompt = f"""
Your task is to generate a short summary of a product \
review from an ecommerce site to give **feedback to the \
Shipping deparmtment**. 

Summarize the review below, delimited by triple 
backticks, in at most 30 words, and **focusing on any aspects \
that mention shipping and delivery of the product**. 

Review: ```{prod_review}```
"""

# 生成内容更加聚焦于哪些属性
prompt = f"""
Your task is to generate a short summary of a product \
review from an ecommerce site to give **feedback to the \
pricing deparmtment**, responsible for determining the \
**price of the product**.  

Summarize the review below, delimited by triple 
backticks, in at most 30 words, and **focusing on any aspects \
that are relevant to the price and perceived value**. 

Review: ```{prod_review}```
"""
```