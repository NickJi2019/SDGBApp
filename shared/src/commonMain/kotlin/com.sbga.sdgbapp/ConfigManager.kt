package com.sbga.sdgbapp

object ConfigManager {
    val maiApiURL = "https://maimai-gm.wahlap.com:42081/Maimai2Servlet/"
    val wechatAimeURL = "http://ai.sys-all.cn/wc_aime/api/get_data"

    val clientId: String = "A63E01D8972"
    val placeId = 1641
    val regionId = 1
    val isEventMode = false
    val isFreePlay = false

    val keyChipId = "A63E-01C30466404"

    object SecureManager {
        object AES{
            val key: String = "F2Rc8F0x2Ly6LiIFy9K>s_Y0Bum62H;R"
            val iv: String = "PR12H;E2Brw@5kJ<"
        }
        object obfuscate{
            val obfuscateParam: String = "SX2bTFe8"
        }
        object WechatAime {
            val salt = "XcW5FW4cPArBXEk4vzKz3CIrMuA5EVVW"
        }
        object SSLCertificate{
            val serverCertificate = """
                -----BEGIN CERTIFICATE-----
                MIIGtTCCBZ2gAwIBAgIQBxiSyVJJPhAjd5nb9f2hZjANBgkqhkiG9w0BAQsFADBf
                MQswCQYDVQQGEwJVUzEVMBMGA1UEChMMRGlnaUNlcnQgSW5jMRkwFwYDVQQLExB3
                d3cuZGlnaWNlcnQuY29tMR4wHAYDVQQDExVHZW9UcnVzdCBDTiBSU0EgQ0EgRzEw
                HhcNMjMwOTI1MDAwMDAwWhcNMjQxMDI1MjM1OTU5WjB7MQswCQYDVQQGEwJDTjES
                MBAGA1UECAwJ5bm/5Lic55yBMRIwEAYDVQQHDAnlub/lt57luIIxLTArBgNVBAoM
                JOW5v+W3nuWNjueri+enkeaKgOiCoeS7veaciemZkOWFrOWPuDEVMBMGA1UEAwwM
                Ki53YWhsYXAuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1JqK
                Z2qxgdo33/E8v3tbwR6Kqc3TxUvq+iZSdYUS/27xF2N70aXfo6CpxPnCvTN0cnlo
                pmdPQbJDi/uI3xeEniBY4DY6KTGZ0D2/EoG7mgYc9j1WowqavQ4CDNo/8MIGp+r0
                WGeKdLOdyUeQmK6fI+FU4lS9ATpTdNtIKPQpGRByjTAIjkrwLjLAohnjkwVKPFCe
                xssBEUmmgc6Y0+gT9nzUVWOKtBtZuFZ19v2o/facvMu8hAkmDrW5OPvuc3A8oYe+
                5/wT4+Cb5f2IaLXe5yVvR4AhRQe0qz70toIQyL6h5TmfZLdCxp1PE0j1q4a3+6Cw
                Jc57D8FvdfwCiy9QVwIDAQABo4IDTzCCA0swHwYDVR0jBBgwFoAUkZ9eMRWuEJ+t
                YMH3wcyqSDQvDCYwHQYDVR0OBBYEFKNmV4L2in1paRu9NwMplFMCbFIYMCMGA1Ud
                EQQcMBqCDCoud2FobGFwLmNvbYIKd2FobGFwLmNvbTA+BgNVHSAENzA1MDMGBmeB
                DAECAjApMCcGCCsGAQUFBwIBFhtodHRwOi8vd3d3LmRpZ2ljZXJ0LmNvbS9DUFMw
                DgYDVR0PAQH/BAQDAgWgMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjB1
                BgNVHR8EbjBsMDSgMqAwhi5odHRwOi8vY3JsMy5kaWdpY2VydC5jb20vR2VvVHJ1
                c3RDTlJTQUNBRzEuY3JsMDSgMqAwhi5odHRwOi8vY3JsNC5kaWdpY2VydC5jb20v
                R2VvVHJ1c3RDTlJTQUNBRzEuY3JsMG8GCCsGAQUFBwEBBGMwYTAhBggrBgEFBQcw
                AYYVaHR0cDovL29jc3AuZGNvY3NwLmNuMDwGCCsGAQUFBzAChjBodHRwOi8vY3Js
                LmRpZ2ljZXJ0LWNuLmNvbS9HZW9UcnVzdENOUlNBQ0FHMS5jcnQwDAYDVR0TAQH/
                BAIwADCCAX0GCisGAQQB1nkCBAIEggFtBIIBaQFnAHUA7s3QZNXbGs7FXLedtM0T
                ojKHRny87N7DUUhZRnEftZsAAAGKyxxcUwAABAMARjBEAiBMwpqIiQ2GxdbEQI9X
                EnGIGaK+gYUiHiJZf0XCPDU4NgIgTu7SV5+3emAPLUpzr+d3aevakVn6smAwEu0R
                sxyAF9YAdgBIsONr2qZHNA/lagL6nTDrHFIBy1bdLIHZu7+rOdiEcwAAAYrLHFxz
                AAAEAwBHMEUCIQDfvKhP+/Tc46VyR4r1tD6DKJwhpw3onGDOm5Su5ys4FgIgKWZB
                co4waza49XQ0uGSwcdwFsxjNf8566pX4yd55DswAdgDatr9rP7W2Ip+bwrtca+hw
                kXFsu1GEhTS9pD0wSNf7qwAAAYrLHFy+AAAEAwBHMEUCIQCipMQFORci58ZIFrkn
                JBrVloSHCd+Q+s4F8HbpKR4AqgIgHdvpLF2/grbAGq4huxKaDUXf63aF+RigQ6ng
                mdggUJMwDQYJKoZIhvcNAQELBQADggEBAH2wwDpKw3wJ88kedc7kEbMHTClWlpBk
                U2hQ+1UYbLxE50T3pOixm+ZCRgTStbIOA34eHost8vpO1AwGamaQ/XFpmkxMDPTi
                o7XkcuwToWLn9MoifHafVGMSVVvg6SreE9Z5wLvAUX+aHX+w5kn7o8tsV4tjaWUB
                j4Tdj/fZ+UoeELGKln4aS0SLE7kVy6+g3XyIbJzxzdYeVK3zE8NpeAfLBMSyHuRN
                dJmqJE1tx5glWbDm00DdOaYFmQHD6SNWmzvtKs0AX7w6y27edv5DX0HS1Z/SSB8X
                XQj5/YrPdj7PrPI/s6k2GF7F70sWQijCAkF8tcnyi0VnBWhw2YIws1U=
                -----END CERTIFICATE-----
            """.trimIndent()
            val intermediate = """
                -----BEGIN CERTIFICATE-----
                MIIFGjCCBAKgAwIBAgIQCgRw0Ja8ihLIkKbfgm7sSzANBgkqhkiG9w0BAQsFADBh
                MQswCQYDVQQGEwJVUzEVMBMGA1UEChMMRGlnaUNlcnQgSW5jMRkwFwYDVQQLExB3
                d3cuZGlnaWNlcnQuY29tMSAwHgYDVQQDExdEaWdpQ2VydCBHbG9iYWwgUm9vdCBD
                QTAeFw0xOTA2MjAxMjI3NThaFw0yOTA2MjAxMjI3NThaMF8xCzAJBgNVBAYTAlVT
                MRUwEwYDVQQKEwxEaWdpQ2VydCBJbmMxGTAXBgNVBAsTEHd3dy5kaWdpY2VydC5j
                b20xHjAcBgNVBAMTFUdlb1RydXN0IENOIFJTQSBDQSBHMTCCASIwDQYJKoZIhvcN
                AQEBBQADggEPADCCAQoCggEBALFJ+j1KeZVG4jzgQob23lQ8PJUNhY31ufZihuUx
                hYc6HSU4Lw0fxfA43a9DpJl74M3E6F1ZRBOfJ+dWnaiyYD0PxRIQd4wJisti4Uad
                vz61IYY/oQ/Elxk/X7GFDquYuxCSyBdHtTVMXCxFSvQ2C/7jWZFDfGGKKNoQSiJy
                wDe8iiHbUOakLMmXmOTZyWJnFdR/TH5YNTiMKCNUPHAleG4IigGxDyL/gbwrdDNi
                bDA4lUNhD0xNvPjQ8BNKqm5HWDvirUuHdC+4hpi0GJO34O3iiRV16YmWTuVFNboU
                LDZ0+PQtctJnatpuZKPGyKX6jCpPvzzPw/EhNDlpEdrYHZMCAwEAAaOCAc4wggHK
                MB0GA1UdDgQWBBSRn14xFa4Qn61gwffBzKpINC8MJjAfBgNVHSMEGDAWgBQD3lA1
                VtFMu2bwo+IbG8OXsj3RVTAOBgNVHQ8BAf8EBAMCAYYwHQYDVR0lBBYwFAYIKwYB
                BQUHAwEGCCsGAQUFBwMCMA8GA1UdEwEB/wQFMAMBAf8wMQYIKwYBBQUHAQEEJTAj
                MCEGCCsGAQUFBzABhhVodHRwOi8vb2NzcC5kY29jc3AuY24wRAYDVR0fBD0wOzA5
                oDegNYYzaHR0cDovL2NybC5kaWdpY2VydC1jbi5jb20vRGlnaUNlcnRHbG9iYWxS
                b290Q0EuY3JsMIHOBgNVHSAEgcYwgcMwgcAGBFUdIAAwgbcwKAYIKwYBBQUHAgEW
                HGh0dHBzOi8vd3d3LmRpZ2ljZXJ0LmNvbS9DUFMwgYoGCCsGAQUFBwICMH4MfEFu
                eSB1c2Ugb2YgdGhpcyBDZXJ0aWZpY2F0ZSBjb25zdGl0dXRlcyBhY2NlcHRhbmNl
                IG9mIHRoZSBSZWx5aW5nIFBhcnR5IEFncmVlbWVudCBsb2NhdGVkIGF0IGh0dHBz
                Oi8vd3d3LmRpZ2ljZXJ0LmNvbS9ycGEtdWEwDQYJKoZIhvcNAQELBQADggEBABfg
                eXrxIrtlixBv+KMDeqKxtNJbZiLDzJBkGCd4HI63X5eS6BElJBn6mI9eYVrr7qOL
                Tp7WiO02Sf1Yrpaz/ePSjZ684o89UAGpxOfbgVSMvo/a07n/220jUWLxzaJhQNLu
                lACXwwWsxYf8twP8glkoIHnUUNTlhsyyl1ZzvVC4bDpI4hC6QkJGync1MNqYSMj8
                tZbhQNw3HdSmcTO0Nc/J/pK2VZc6fFbKBgspmzdHc6jMKG2t4lisXEysS3wPcg0a
                Nfr1Odl5+myh3MnMK08f6pTXvduLz+QZiIh8IYL+Z6QWgTZ9e2jnV8juumX1I8Ge
                7cZdtNnTCB8hFfwGLUA=
                -----END CERTIFICATE-----

            """.trimIndent()
        }
    }
}