package com.mytaxi.apis.phraseapi

import com.mytaxi.apis.phraseapi.locale.reponse.CreatePhraseLocale
import feign.Headers
import feign.Param
import feign.RequestLine
import feign.Response
import java.io.File

@Headers(
    "Content-Type: application/json"
)
interface PhraseApi {

    //Projects
    @RequestLine("GET /v2/projects")
    fun projects(): Response

    @RequestLine("GET /v2/projects/{projectId}")
    fun project(@Param("projectId") projectId: String): Response

    @RequestLine("POST /v2/projects")
    @Headers(
        "Content-Type: multipart/form-data"
    )
    fun createProject(
        @Param("name") name: String,
        @Param("project_image") projectImage: File?,
        @Param("main_format") mainFormat: String?,
        @Param("sharesTranslationMemory") sharesTranslationMemory: String?,
        @Param("remove_project_image") removeProjectImage: Boolean?,
        @Param("account_id") accountId: String?
    ): Response

    @RequestLine("PUT /v2/projects/{projectId}")
    @Headers(
        "Content-Type: multipart/form-data"
    )
    fun updateProject(
        @Param("projectId") projectId: String,
        @Param("name") name: String,
        @Param("project_image") projectImage: File?,
        @Param("main_format") mainFormat: String?,
        @Param("sharesTranslationMemory") sharesTranslationMemory: String?,
        @Param("remove_project_image") removeProjectImage: Boolean?,
        @Param("account_id") accountId: String?
    ): Response

    @RequestLine("DELETE /v2/projects/{projectId}")
    fun deleteProject(@Param("projectId") projectId: String): Response

    //Locales
    @RequestLine("GET /v2/projects/{projectId}/locales")
    fun locales(@Param("projectId") projectId: String): Response

    @RequestLine("POST /v2/projects/{projectId}/locales")
    fun createLocale(
        @Param("projectId") projectId: String,
        locale: CreatePhraseLocale
    ): Response

    @RequestLine("PUT /v2/projects/{projectId}/locales/{localeId}")
    fun updateLocale(
        @Param("projectId") projectId: String,
        @Param("localeId") localeId: String,
        locale: CreatePhraseLocale
    ): Response

    @RequestLine("GET /v2/projects/{projectId}/locales/{localeId}")
    fun locale(
        @Param("projectId") projectId: String,
        @Param("localeId") localeId: String
    ): Response

    @RequestLine("DELETE /v2/projects/{projectId}/locales/{localeId}")
    fun deleteLocale(
        @Param("projectId") projectId: String,
        @Param("localeId") localeId: String
    ): Response


    @RequestLine("GET /v2/projects/{projectId}/locales/{localeId}/download?file_format=json")
    fun downloadLocale(
        @Param("projectId") projectId: String,
        @Param("localeId") localeId: String
    ): Response


    //Translations
    @RequestLine("GET /v2/projects/{projectId}/locales/{localeId}/translations")
    fun translations(
        @Param("projectId") projectId: String,
        @Param("localeId") localeId: String
    ): Response

}