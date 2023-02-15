package com.example.e_reader.model

/**
 * Create by Sirumalayil on 15-02-2023.
 */
data class Story(
    val ChapterTitle: String,
    val ChapterTitleEnglish: String,
    val LexiconMapping: LexiconMapping,
    val contentsLex: List<ContentLex>
)