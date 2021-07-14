package com.go.shopping.question

import android.util.SparseArray

/**
 *@author YPT
 *@version
 *@date 2021/7/14
 */
object QuestionConfig {
    //应该存放在sqlLite，定期从服务器更新,用户没回答一个，编号依次加一，加到最后一个，从服务器更新，类似于分页，每回答对一个，积分加1，用户兑换商品
    val questionList = SparseArray<QuestionBean>()

    init {
        val a = QuestionBean(
            "The grey building is the place where the workers live, and the white building is the place where the spare parts ( ).",
            "A. are producing",
            "B. are produced",
            "C. produced",
            "D. being produced",
            "B. are produced",
            "动词被动语态。be+动词过去分词，表示被动语态。句意：灰色建筑是工人住的地方，而白色建筑是生产部件的地方。故选B。"
        )
        val b = QuestionBean(
            "They got there an hour ( ) than the others. ",
            "A. early",
            "B. much early",
            "C. more early",
            "D. earlier",
            "D. earlier",
            "比较级。与形容词一样，副词比较级常和than连用。句意：他们比别人早到一个小时。故选D。"
        )
        val c = QuestionBean(
            "The harder you study, ( ) you will learn.",
            "A. much",
            "B. many",
            "C. the more",
            "D. much more",
            "C. the more",
            "比较级。用两个叠加的比较级形容词或副词可以表示“越……越……”。句意：你学习越努力，学到的东西越多。故选C。"
        )
        val d = QuestionBean(
            "( ) you know, David has been well lately. ",
            "A. Which",
            "B. As",
            "C. What",
            "D. When",
            "B. As",
            "as代表主句的内容，意为“正像……，如同……”。句意：正像你所知道的那样，Davd近来身体很好。故选B。"
        )
        val e = QuestionBean(
            "Sunday is the day ( ) people usually don't go to work.",
            "A. when",
            "B. which",
            "C. in which",
            "D. that",
            "A. when",
            "定语从句。在表示时间的一些特定名词如time、day、 morning、 month、year等之后可以接一个由when引出的限制性定语从句。句意： 星期天是人们通常不上班的日子。故选A。"
        )
        val f = QuestionBean(
            "Australia is one of the few countries ( ) people drive on the left of the road.",
            "A. which",
            "B. that",
            "C. where",
            "D. on which",
            "C. where",
            "定语从句。在表示地点的一些特定名词如 place、room、 countrv、 street等之后，可接一个由 where或 in which引出的限制性定语从句。句意：澳大利亚是少数几个沿左侧开车的国家之一。故选C。"
        )
        val g = QuestionBean(
            "The higher the temperature ( ) the liquid evaporates.",
            "A. the faster",
            "B. the more fast",
            "C. the slower",
            "D. the more slower",
            "A. the faster",
            "比较级。“the+形容词或副词比较级……，the+形容词或副词比较级……，表示“越……，越……。句意：温度越高，液体蒸发得越越快。故选A。"
        )
        val h = QuestionBean(
            "She wonders ( ) will happen to her private life in the future. ",
            "A. that",
            "B. it",
            "C. this",
            "D. what",
            "D. what",
            "名词性从句（宾语从句）。that和what都能引导宾语从句，但是that在从句中不作任成分（无词义），而what有词义，在从句中作主语。"
        )
        val i = QuestionBean(
            " It was well known that Thomas Edison ( ) the electric lamp.",
            "A. discovered",
            "B. invented",
            "C. found",
            "D. developed",
            "B. invented",
            "动词词义辨析。 invent，发明； discover；发现；found（find的过去时），发现； develop，研究、发展。句意：大家都知道托马斯爱迪生发明了电灯。故选B。"
        )
        val j = QuestionBean(
            "The workers are busy ( ) models for the exhibition.",
            "A. to make",
            "B. with making",
            "C. being making",
            "D. making",
            "D. making",
            "非谓语动词。 be busy+(in)+动名词，等同于be busy with + n.，表示忙于做某事。句意：那些工人在忙着为展览会做模型。故选D。"
        )
        questionList.append(1, a)
        questionList.append(2, b)
        questionList.append(3, c)
        questionList.append(4, d)
        questionList.append(5, e)
        questionList.append(6, f)
        questionList.append(7, g)
        questionList.append(8, h)
        questionList.append(9, i)
        questionList.append(10, j)
    }

}