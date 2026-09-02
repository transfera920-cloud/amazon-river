package com.example.data

import com.example.model.*

object SafetyCurriculum {

    const val BRAND_NAME = "亞馬遜國家山岳協會"
    const val APP_FULL_TITLE = "亞馬遜國家山岳協會｜登山途中溪水橫渡安全教案"

    val TOP_CORE_PRINCIPLES = listOf(
        "登山隊過溪的最高原則：不是判斷「現在能不能過」，而是判斷「進去之後，是否仍然保有安全撤退的能力」。",
        "不要進入會困住你的地方。",
        "有繩 ≠ 可以過。",
        "繩索是控制系統，不是替代個人脫困能力。"
    )

    val CORE_PILLARS = listOf(
        Triple("01｜先看水", "水位、水流、水色、上游、下游", "仔細觀察水文動態與流速，絕不盲目踏入未知水域。"),
        Triple("02｜再選點", "寬、緩、淺，通常優於窄、急、深", "尋找即使失足也有足夠緩衝與撤退空間的過渡點。"),
        Triple("03｜保留退路", "不要進入會困住你的地方", "確保進入水流的任何時刻，都保有隨時轉身撤回岸上的能力。")
    )

    val LEADER_COMMANDS_10SEC = listOf(
        "「先停，不下水。」",
        "「看上游、看水位、看下游。」",
        "「找寬、緩、淺的位置。」",
        "「先想跌倒後會去哪裡。」",
        "「確定還有撤退能力，再決定過不過。」"
    )

    val SAFETY_BASELINE = listOf(
        "水會變。",
        "地形會變。",
        "隊員狀態會變。",
        "裝備會影響脫困能力。",
        "繩索不能消除風險。",
        "最好的渡溪技術，有時候就是不要下水。"
    )

    const val FINAL_GOLDEN_RULE = "安全通過，不是勇敢通過。\n真正的能力，是知道什麼時候不能過。"

    const val REFERENCE_TITLE = "鐘擺橫渡法｜渡溪技術"
    const val REFERENCE_URL = "https://dar999.pixnet.net/blog/posts/30479582"
    const val REFERENCE_DISCLAIMER = "本頁技術內容為安全教育用途之重新整理，僅參考相關渡溪安全技術概念；圖例、介面與教材內容由「亞馬遜國家山岳協會」重新整理與原創設計。"

    val CHAPTERS: List<Chapter> = listOf(
        Chapter(
            id = 1,
            chapterNumber = "Chapter 01",
            title = "為什麼登山會遇到溪水",
            subtitle = "溪水不是普通的路面，山區溪流具高度變動性",
            category = "基礎認知",
            coreQuote = "溪水不是普通的路面。",
            summary = "登山行程常穿梭於不同水文環境，山區溪流與陸地路徑有本質上的不同，極易受氣候與地形快速改變。",
            keyPoints = listOf(
                "登山路線可能穿越溪床與乾涸河道",
                "林道路線可能因土石崩塌改道而被迫進入溪流",
                "多日縱走行程不可避免遇到各級溪流橫渡點",
                "豪雨後原本安全的過水點可能在數小時內完全改變",
                "山區溪流具有高度變動性與不可預測的推力"
            ),
            deepContent = listOf(
                "許多登山者容易將「過溪」視為一般步道的延伸，但水流是充滿動態推力的介質。",
                "尤其在台灣或多山地形中，集水區降雨往往在短時間內匯流至下游溪床，原本踏石可過的淺溪可能瞬間暴漲成阻斷退路的急流。"
            )
        ),
        Chapter(
            id = 2,
            chapterNumber = "Chapter 02",
            title = "溪水不是一般路面",
            subtitle = "水流具有持續推力，失足後情況將瞬間惡化",
            category = "基礎認知",
            coreQuote = "在陸地上跌倒，可能只是跌倒；在流水中跌倒，可能會變成被水流帶走。",
            summary = "水流具有不可忽視的持續衝擊力，水底暗藏滑石與深坑，背包更會加劇水阻，一旦失衡將面臨被沖走的危險。",
            keyPoints = listOf(
                "水流具有強大且持續不斷的橫向推力",
                "水底可能有泥、細砂、圓石、滑石等不穩定沉積物",
                "水下地形無法單純從水面外觀完全正確判斷",
                "水深與流速會互相加成，顯著放大推動人體的力道",
                "一旦在流水中跌倒，人體失去支撐會瞬間失去控制",
                "背包與厚重衣物吸水後會大幅增加水阻與自重",
                "下游可能存在落差、瀑布、巨石卡死、倒木等致命二次危險"
            ),
            warningBox = WarningBoxData(
                level = WarningLevel.WARNING,
                title = "物理推力警示",
                text = "水深達到膝蓋且流速明顯時，水流推力足以推翻一名成年負重登山者。跌倒後水流會壓制身體，使站立變得極端困難。"
            )
        ),
        Chapter(
            id = 3,
            chapterNumber = "Chapter 03",
            title = "到溪邊第一件事：停下來",
            subtitle = "禁止看到水就直接走，建立標準停看聽流程",
            category = "觀察與判斷",
            coreQuote = "停下 → 集合 → 觀察 → 討論 → 選點 → 再決定",
            summary = "抵達溪畔時第一準則是「立即停下」，召集全員評估環境，嚴格禁止隊員個別直接涉水穿越。",
            keyPoints = listOf(
                "禁止讓隊員「看到水就直接過」的冒進習慣",
                "全員在安全高處停下並集合",
                "仔細觀察上游天候與下游環境",
                "隊伍幹部與隊員共同討論風險評估",
                "尋找最佳選點與確認撤退路線後再做最後決定"
            ),
            deepContent = listOf(
                "觀察核心清單包括：",
                "1. 上游：遠方山頭是否有烏雲、是否正在下雨、集水區狀況",
                "2. 下游：是否有落差、瀑布、卡人倒木、深潭、巨石縫隙",
                "3. 水深與流速：評估水深是否過膝、流速是否過快",
                "4. 水面狀況：有無白浪、漩渦、回流、紊流區",
                "5. 河床與岸邊：對岸是否有平緩出水點，是否容易攀爬脫離",
                "6. 替代路線：是否有上游寬廣處、高繞路徑或原路折返方案",
                "7. 水位趨勢：水線是否有正在上升的痕跡（如淹沒剛被浸濕的乾石）"
            ),
            processSteps = listOf(
                "1. 停下：全員停在離水邊有安全距離的高位",
                "2. 集合：清點人員，穩定隊伍情緒與節奏",
                "3. 觀察：環視上游、下游、水色、流速與河床",
                "4. 討論：領隊與隊員評估能力與裝備狀況",
                "5. 選點：挑選寬、緩、淺且兩岸好出入之地點",
                "6. 決定：評估是否具備撤退能力，決定渡溪或撤退"
            )
        ),
        Chapter(
            id = 4,
            chapterNumber = "Chapter 04",
            title = "選擇渡溪位置",
            subtitle = "寬、緩、淺優於窄、急、深，以失足脫離機會為核心",
            category = "觀察與判斷",
            coreQuote = "寬、緩、淺，通常優於窄、急、深。不要只看哪裡距離最近，而要看哪裡即使有人失足，也比較有機會安全脫離。",
            summary = "渡溪選點的關鍵在於水流能量的分散程度與失足後的緩衝空間，而非單純追求最短橫跨距離。",
            keyPoints = listOf(
                "河道寬廣處水流截面積大，流速通常較為平緩",
                "河道窄縮處水流能量高度集中，深不可測且推力倍增",
                "評估選點時，必須將「下游失足後緩衝安全區」列為首要條件",
                "避免選擇下游直接緊鄰瀑布、落差或倒木堆積處"
            ),
            comparisonTable = ComparisonTableData(
                idealHeader = "較理想情境（寬、緩、淺）",
                dangerHeader = "較危險情境（窄、急、深）",
                rows = listOf(
                    ComparisonRow("河道較寬，水流分散", "河道狹窄，水流高壓集中"),
                    ComparisonRow("水流平緩，推力小", "流速極快，具有強烈拍打推力"),
                    ComparisonRow("水深較淺（低於膝蓋）", "水深增加，甚至超過大腿或及腰"),
                    ComparisonRow("河床平整，底石相對穩定", "水流混濁，水底巨石縫或深坑暗藏"),
                    ComparisonRow("下游開闊平緩，無立即致命危險", "下游緊接瀑布、急湍、巨大落差"),
                    ComparisonRow("兩岸進出容易，有寬裕的安全撤退空間", "有倒木、滾動巨石、兩岸峭壁無退路")
                )
            ),
            diagramType = SvgDiagramType.RIVER_CROSS_SECTION
        ),
        Chapter(
            id = 5,
            chapterNumber = "Chapter 05",
            title = "學會看水",
            subtitle = "建立溪水觀察卡：水深、流速、水色、漂流物、水面與下游",
            category = "觀察與判斷",
            coreQuote = "即使目前的位置看起來可以通過，也要觀察：如果人在這裡跌倒，會被帶去哪裡？",
            summary = "看懂水面的細微徵兆是戶外安全的基本功，涵蓋水深、流速、水色、漂流物、水面擾動及下游出口環境。",
            keyPoints = listOf(
                "1. 水深觀察：不要只看水面折射，利用登山杖探測實際深度與淤泥厚度",
                "2. 水流速度：拋擲樹枝或落葉觀察漂流物移動秒數，判斷推力級數",
                "3. 水色判別：清澈見底、微濁或突然變成泥黃色皆是重要安全信號",
                "4. 漂流物警戒：若水面開始出現大量新鮮樹枝、斷木、泥沙落葉，代表上游正在沖刷",
                "5. 水面變化：密切注意白浪湧起、集中水線、突發回流、漩渦與窄縮跌水",
                "6. 下游環境：預先假設失足被沖走時，是否有開闊淺灘能自行爬起"
            ),
            warningBox = WarningBoxData(
                level = WarningLevel.CAUTION,
                title = "溪水觀察卡 6 大維度",
                text = "水深、流速、水色、漂流物、水面變化、下游環境。六者缺一不可，任何一項呈現危險信號均應停下評估。"
            )
        ),
        Chapter(
            id = 6,
            chapterNumber = "Chapter 06",
            title = "注意「正在變化的溪水」",
            subtitle = "溪水不是靜態環境，上游天候隨時可能引發暴漲",
            category = "觀察與判斷",
            coreQuote = "溪水不是靜態環境。",
            summary = "山區降雨具有滯後性與遠距影響性，眼前看似平靜的溪流，可能正處於洪峰即將抵達的劇烈變化期。",
            keyPoints = listOf(
                "上游集水區降雨可能造成下游水位在幾分鐘內突然暴升",
                "即便目前位置無雨，遠方山頭降雨仍會直接影響溪流流量",
                "水色突然轉濁或由清變混，代表上游土石泥流已啟動",
                "水面漂流物、泡沫顯著增加，預示更大水量即將湧至",
                "「原本來的時候可以過」的水位，絕不代表「現在回程仍然可以過」"
            ),
            warningBox = WarningBoxData(
                level = WarningLevel.WARNING,
                title = "時間動態警示",
                text = "溪水是活的、動態的。過溪決策只能依據「當下的即時變化趨勢」來判斷，切勿仰賴過去的經驗或舊紀錄。"
            )
        ),
        Chapter(
            id = 7,
            chapterNumber = "Chapter 07",
            title = "沙洲與河中島不是一定安全",
            subtitle = "警惕孤島陷阱，踩得到不等於能安全撤退",
            category = "觀察與判斷",
            coreQuote = "不要把「現在踩得到」誤判成「可以安全撤退」。",
            summary = "河道中的沙洲與中繼小島极易在水位上漲時被迅速淹沒，進入中繼區域可能讓隊伍身陷進退維谷的孤島死局。",
            keyPoints = listOf(
                "⚠️ 沙洲 ≠ 安全區",
                "⚠️ 河中島 ≠ 安全區",
                "隊伍若進入河道中間沙洲暫歇，一旦兩側水位上漲，將立刻失去撤回原岸的能力",
                "原本以為的休息站可能在十幾分鐘內變成四面受困的孤立急流區",
                "評估渡溪時，必須確保能「一口氣安全抵達對岸高處」或「隨時能退回出發岸」"
            ),
            warningBox = WarningBoxData(
                level = WarningLevel.PROHIBITION,
                title = "沙洲陷阱警示",
                text = "切勿將隊伍停留在河中沙洲過夜、長時間休息或整裝。水位微升即可能切斷所有退路！"
            ),
            diagramType = SvgDiagramType.SANDBANK_ISLAND_TRAP
        ),
        Chapter(
            id = 8,
            chapterNumber = "Chapter 08",
            title = "過溪前最後判斷",
            subtitle = "最後停看聽 STOP 介面，安全撤退也是成功完成任務",
            category = "觀察與判斷",
            coreQuote = "不是一定要過。安全撤退也是成功完成任務。",
            summary = "在踩入水中的最後一秒，執行嚴格的 STOP 檢查。若有任何一項不符合安全標準，優先選擇停止與撤退。",
            keyPoints = listOf(
                "【STOP】水位正在快速上升或岸邊水線向上推移",
                "【STOP】溪水顏色迅速變黃變濁",
                "【STOP】水流聲增大且推力明顯增強",
                "【STOP】上游持續降雨或遠處雷聲大作",
                "【STOP】下游存在明顯落差、深潭或致命卡人障礙",
                "【STOP】找不到明確且穩固的安全撤退路線",
                "【STOP】隊員已有失溫、疲勞或無法穩定站立之情況",
                "【STOP】隊伍整體能力不足以抗衡目前水勢",
                "【STOP】必須依賴臨時、未經受訓的繩索操作",
                "【STOP】隊伍無法維持口語或手勢的有效聯絡與指揮"
            ),
            warningBox = WarningBoxData(
                level = WarningLevel.INFO,
                title = "領隊決策思維",
                text = "撤退不是軟弱，而是高度成熟的山岳風險管理決策。山永遠在，帶領全體隊員平安回家才是唯一目標。"
            )
        ),
        Chapter(
            id = 9,
            chapterNumber = "Chapter 09",
            title = "哪些情況直接禁止進入",
            subtitle = "絕對禁令紅色警示卡，「大家都覺得應該可以」不是安全判斷依據",
            category = "觀察與判斷",
            coreQuote = "「大家都覺得應該可以」不是安全判斷依據。",
            summary = "列出絕對禁止涉水的紅色危險情境。在這些條件下，任何冒險涉水均屬致命行為，必須堅決撤退或改道。",
            keyPoints = listOf(
                "🚫 暴雨或豪雨特報期間",
                "🚫 目視可見上游山區正降下暴雨",
                "🚫 水位在觀察期間內呈現快速上升",
                "🚫 溪水突然混濁並伴隨泥沙斷木",
                "🚫 水流速度過快（目測超過正常步行速度甚多）",
                "🚫 下游存在瀑布、巨石倒木夾縫等致命障礙",
                "🚫 無法判斷水下地形且水深及腰以上",
                "🚫 無法建立安全撤退方案",
                "🚫 隊員體能衰竭或過度恐慌",
                "🚫 裝備嚴重不足且無合適防護",
                "🚫 現場臨時嘗試「發明」或摸索未經訓練的繩索系統",
                "🚫 領隊無法掌握或控制整個隊伍的步調"
            ),
            warningBox = WarningBoxData(
                level = WarningLevel.PROHIBITION,
                title = "紅色禁令法則",
                text = "只要符合上述任一條件，無論行程多趕、距離山屋多近，一律嚴禁下水！"
            )
        ),
        Chapter(
            id = 10,
            chapterNumber = "Chapter 10",
            title = "一般登山者的基本渡溪原則",
            subtitle = "非溯溪課程，專注於登山隊伍能落實的徒步過水基本功",
            category = "隊伍管理",
            coreQuote = "穩扎穩打，不要急著進水。保持三點支撐，不跳躍、不互相拉扯。",
            summary = "為無專業溯溪背景的一般登山隊量身打造，注重步法穩定、重心控制與隊伍間的默契配合。",
            keyPoints = listOf(
                "不要急著進水：深呼吸，解除背包胸扣與腰扣防護，看清腳踏點",
                "先選擇踏足路線：避開深潭與滑石，規劃每一步落腳點",
                "保持三點支撐概念：雙腳與登山杖交互前進，始終維持兩點或三點接地",
                "注意腳下受力：用腳掌在水底試探石頭是否搖晃、長青苔或易滑",
                "嚴禁跳躍石頭：水邊濕滑岩石極易滑倒，跳躍失足將直接摔入急流",
                "不要在水中互相拉扯：拉扯會破壞彼此重心，一人摔倒可能拉倒全隊",
                "保持隊伍控制：一人前進時其餘隊員在旁警戒，保持安全間距",
                "保持口語與手勢聯絡：確認水流聲中彼此指令明確傳達",
                "避免單獨渡溪：嚴禁隊員擅自脫隊過水",
                "通過後重新集合：對岸安全平坦區集合，確認人員狀態"
            )
        ),
        Chapter(
            id = 11,
            chapterNumber = "Chapter 11",
            title = "隊伍如何通過",
            subtitle = "團隊渡溪九大標準流程，渡溪不是個人行為而是團隊操作",
            category = "隊伍管理",
            coreQuote = "渡溪不是個人行為，而是團隊操作。",
            summary = "建立嚴謹的隊伍過溪節奏，從領隊探勘、規則宣布、順序排列到逐人接應，確保全員有條不紊。",
            keyPoints = listOf(
                "領隊或最有經驗者先進行水文與地形總體觀察",
                "選定最佳渡溪位置與上岸出水點",
                "集合全隊宣布過溪規則、步伐要領與緊急應變",
                "安排人員順序（先鋒探路、有經驗者前後壓陣、體能較弱者排中段並重點護送）",
                "逐人或以安全組別通過，保持間隔，嚴禁一擁而上",
                "先抵達對岸者立即在安全側建立接應防線",
                "全員通過後進行人數清點與健康檢查",
                "確認所有個人裝備與重要公裝無遺失損壞",
                "整隊完成後全員迅速離開易受洪水影響的溪床河階"
            ),
            processSteps = listOf(
                "1. 領隊觀察：評估水文與兩岸出入口",
                "2. 選擇渡溪位置：確認寬緩淺與下游緩衝",
                "3. 建立隊伍規則：宣布解扣、步伐與信號",
                "4. 安排人員順序：強者先鋒與壓陣，弱者中段接應",
                "5. 逐人通過：維持安全間距，單人穩定前進",
                "6. 安全側接應：先到者於對岸平緩處伸手/杖接應",
                "7. 清點人員：確認全體隊員均已安全上岸",
                "8. 確認裝備：檢查背包、鞋襪與通訊器具",
                "9. 全隊離開溪床：迅速移往高處步道安全區"
            )
        ),
        Chapter(
            id = 12,
            chapterNumber = "Chapter 12",
            title = "過溪後重新確認",
            subtitle = "嚴禁「過了就算了」，上岸後的完整清點與狀態評估",
            category = "隊伍管理",
            coreQuote = "不要出現「過了就算了」的鬆懈心態。",
            summary = "安全過溪的終點不是腳踏上岸，而是完成人員、裝備、保暖與後續路線的全面檢查確認。",
            keyPoints = listOf(
                "清點全隊人數，確保無人落單或滯留溪床",
                "確認是否有隊員撞傷、扭傷、擦傷或抽筋",
                "檢查鞋襪狀況，必要時倒水或更換乾襪防止起水泡與失溫",
                "檢查背包內部是否進水，保護睡袋與保暖衣物乾爽",
                "確認重要公裝（糧食、帳篷、醫療包）完好",
                "確認通訊設備（無線電、衛星通訊儀、手機）是否受潮失效",
                "評估全體隊員心理與體力狀態",
                "確認下一段登山路線走向與預計抵達營地時間"
            )
        ),
        Chapter(
            id = 13,
            chapterNumber = "Chapter 13",
            title = "人包分離｜人的安全永遠優先於裝備",
            subtitle = "背包可以丟人不能，具備必要時與裝備分離的自救能力",
            category = "核心裝備技術",
            coreQuote = "背包可以丟，人不能。\n這不代表每次過溪都必須自動脫掉背包；是否採取人包分離，必須依水流強度、水深、地形、背包固定方式與當下情境判斷。",
            summary = "深入解析背包在流水中產生的致命阻力與拖曳效應，建立「人的脫困能力 > 保住裝備」的絕對安全思維。",
            keyPoints = listOf(
                "背包在急流中會瞬間大量吸水，增加龐大重量與迎水阻力",
                "巨大的水阻會將人體向後拉扯，嚴重破壞站立平衡",
                "背包外掛裝備極易被水底岩石、倒木樹枝勾住卡死",
                "扣緊的腰扣與胸扣會限制人體翻身游動與自救脫困的能力",
                "事前必須極度熟悉自身背包扣具的單手快速解除操作",
                "絕不能到了急流中失足才第一次摸索如何解開扣具",
                "繩索確保不能替代個人脫困能力，有繩確保同樣不能忽略人包分離思維"
            ),
            warningBox = WarningBoxData(
                level = WarningLevel.WARNING,
                title = "核心觀念釐清",
                text = "人包分離不是「每次都要把背包扔掉」，而是「在遇到危急或失足拖曳時，能毫不猶豫、迅速解除背包以保全生命」。"
            )
        ),
        Chapter(
            id = 14,
            chapterNumber = "Chapter 14",
            title = "人包分離原創教學圖解",
            subtitle = "正常通過 vs 失足拖曳 vs 快速解扣脫困核心概念",
            category = "核心裝備技術",
            coreQuote = "人的脫困能力 > 保住背包。當裝備開始妨礙生命安全時，果斷分離！",
            summary = "以直觀原創向量圖解呈現正常姿態、失足遭水流拖曳的物理力學，以及迅速解扣使人體自由浮起脫困的核心機制。",
            keyPoints = listOf(
                "【A 正常狀態】人物解開腰扣/胸扣，重心前傾，利用登山杖與背包保持穩定通過",
                "【B 失足情境】人物跌入水中，若扣具鎖死，背包吸水產生強烈拖曳力將人壓向水底",
                "【C 核心概念】單手快速釋放扣具，卸除背包水阻，人體迅速恢復自由並順流自救脫困"
            ),
            diagramType = SvgDiagramType.BACKPACK_SEPARATION
        ),
        Chapter(
            id = 15,
            chapterNumber = "Chapter 15",
            title = "鐘擺式確保過溪｜進階技術",
            subtitle = "專業技術認識與進階觀念，非一般登山者看完即可自行操作之技術",
            category = "核心裝備技術",
            coreQuote = "有繩 ≠ 可以過。繩索是控制系統，不是替代個人脫困能力。",
            summary = "定位為專業技術的學理認識。介紹鐘擺橫渡的基本力學原理與極限，強調切勿因手邊有一條繩子就盲目涉險。",
            keyPoints = listOf(
                "鐘擺式確保是一種利用上游固定點與主繩，引導渡溪者以弧形軌跡橫越水流的專業技術",
                "核心元件包括：渡溪者、岸上確保者、主繩、上游穩固固定點、水流推力向量、撤退方向與安全接應區",
                "技術目的在於「控制橫向移動與提供失足時的擺盪回岸路徑」，而非拉著人硬抗急流",
                "【三大安全鐵律】1. 有繩不代表安全 2. 繩索不能代替個人能力 3. 嚴禁臨時發明未經訓練的繩索系統",
                "若無受過專業溯溪或急流救援實體訓練，切勿自行架設或冒險嘗試"
            ),
            isAdvanced = true,
            referenceUrl = REFERENCE_URL,
            referenceText = REFERENCE_TITLE
        ),
        Chapter(
            id = 16,
            chapterNumber = "Chapter 16",
            title = "鐘擺式過溪原創教學圖解",
            subtitle = "力學結構與系統分工全貌：渡溪者、確保者、主繩、水流與撤退方向",
            category = "核心裝備技術",
            coreQuote = "繩索系統的目的，是建立可控制的移動與撤退能力。",
            summary = "清楚標示鐘擺橫渡各關鍵角色與力學箭頭，幫助登山者理解專業繩索系統的運作原理與安全裕度。",
            keyPoints = listOf(
                "① 渡溪者（保持機動與脫困能力）",
                "② 確保者（岸上動態放繩與觀察）",
                "③ 主繩（連接固定點與渡溪者）",
                "④ 固定／確保點（上游堅固巨木或岩石錨點）",
                "⑤ 水流方向（向正下游持續推擠）",
                "⑥ 渡溪方向（沿鐘擺弧線橫向切過）",
                "⑦ 撤退方向（失足或受阻時順擺回出發岸）",
                "⑧ 岸上安全區（寬廣穩定的陸上站立點）"
            ),
            isAdvanced = true,
            diagramType = SvgDiagramType.PENDULUM_TRAVERSE,
            referenceUrl = REFERENCE_URL,
            referenceText = REFERENCE_TITLE
        ),
        Chapter(
            id = 17,
            chapterNumber = "Chapter 17",
            title = "鐘擺式技術的適用與不適用",
            subtitle = "專業研究 vs 嚴禁自行嘗試對照表",
            category = "核心裝備技術",
            coreQuote = "沒有能力建立安全系統，就不要進入需要安全系統才能脫困的位置。",
            summary = "明確區分何時具備專業操作條件，何時屬於高危險的盲目冒險，建立嚴格的技術邊界。",
            keyPoints = listOf(
                "專業技術研究必須具備完整受訓背景與合格專用器材",
                "一般隊伍若缺乏固定點設置能力與失誤救援方案，嚴禁盲目架繩涉水"
            ),
            isAdvanced = true,
            comparisonTable = ComparisonTableData(
                idealHeader = "可以作為專業技術研究情境",
                dangerHeader = "不應自行嘗試之情境",
                rows = listOf(
                    ComparisonRow("團隊全員具備正式急流/繩索救援訓練", "未受過專業訓練，僅看過網路文章"),
                    ComparisonRow("配備合適的專業浮力繩、快卸扣與吊帶", "使用普通細繩、扁帶或缺乏防護裝備"),
                    ComparisonRow("上游有絕對穩固可靠的天然或人工固定點", "固定點不牢靠（如鬆動小樹、小石）"),
                    ComparisonRow("確保者與先鋒有明確分工與熟練操作默契", "現場手忙腳亂，分工混亂"),
                    ComparisonRow("兩岸具備清晰無阻礙的通訊手勢與口令", "水流噪音過大無法溝通，失去聯絡"),
                    ComparisonRow("備有完整的失足自救與下游救援補救方案", "完全不知道人員跌倒後該如何拉回"),
                    ComparisonRow("具備及時中止並順利撤回出發岸的控制力", "只是因為「手上剛好有一條繩子」就冒險進入")
                )
            ),
            referenceUrl = REFERENCE_URL,
            referenceText = REFERENCE_TITLE
        ),
        Chapter(
            id = 18,
            chapterNumber = "Chapter 18",
            title = "專業溯溪技術只是「認識」",
            subtitle = "本教案非溯溪課程，真正的急流救援需實體專業培訓",
            category = "核心裝備技術",
            coreQuote = "真正的繩索渡溪、救援與急流技術，需要實體課程、專業教練與實際環境訓練。",
            summary = "誠實告知教案的教育邊界。一般登山者的最高準則是避險與撤退，而非在野外實戰未受訓的專業急流技巧。",
            keyPoints = listOf(
                "本教案旨在建立登山者的風險識別與撤退決策思維",
                "登山者需要知道溪水危險在哪、為何選寬緩淺、為何需要撤退能力與人包分離",
                "文字與圖解無法替代冰冷急流中的身體肌肉記憶與水感反應",
                "如需學習架繩渡溪、拋繩包救援與急流游泳，請報名合格專業機構之實體訓練"
            ),
            warningBox = WarningBoxData(
                level = WarningLevel.INFO,
                title = "培訓提醒",
                text = "在沒有教練在場的野外，最頂級的技術就是「做出正確撤退的智慧」。"
            )
        ),
        Chapter(
            id = 19,
            chapterNumber = "Chapter 19",
            title = "案例演練",
            subtitle = "五大真實登山過溪情境互動演練與深度思維剖析",
            category = "案例演練",
            coreQuote = "情境 → 觀察 → 判斷 → 行動 → 核心教訓",
            summary = "透過五個具代表性的山岳溪流情境，引導隊友實戰模擬判斷，無評分機制，專注於培養堅實的安全決策思維。",
            keyPoints = listOf(
                "案例 A：溪水原本很淺，但上游正在下雨（水位動態變化思維）",
                "案例 B：溪邊留有一條舊繩，但水流很急（破除繩索迷思）",
                "案例 C：河中央有一塊看似寬闊的大型沙洲（沙洲孤島陷阱）",
                "案例 D：隊員背包極重且水流開始變強（人包分離與生命優先）",
                "案例 E：走到溪中央時水位突然上升（中途應變與撤退能力）"
            )
        )
    )

    val CASE_STUDIES: List<CaseStudy> = listOf(
        CaseStudy(
            id = "case_a",
            tag = "案例 A",
            title = "溪水原本很淺，但上游正在下雨",
            situation = "午後登山隊抵達一條原本水深僅及腳踝的小溪，但此時遠方上游山頭烏雲密布，且隱約傳來雷聲與雨聲，溪水看似尚未暴漲。",
            question = "身為領隊或隊員，此時「現在可以過嗎？」最佳行動是什麼？",
            options = listOf(
                CaseOption(
                    id = "a_cross",
                    label = "趁水還很淺，叫大家快步衝過去",
                    outcomeType = WarningLevel.PROHIBITION,
                    safetyFeedback = "危險！上游降雨的集水洪峰可能在幾秒鐘內湧至，在涉水過程中遭遇暴漲極易造成隊員直接被沖走。"
                ),
                CaseOption(
                    id = "a_retreat",
                    label = "立即停止過溪，迅速撤往高處或紮營避雨",
                    outcomeType = WarningLevel.INFO,
                    safetyFeedback = "正確！上游正在降雨代表溪水處於「極度高風險變動期」，水位隨時可能暴升。避開溪床前往高地是唯一安全決策。"
                ),
                CaseOption(
                    id = "a_wait",
                    label = "站在溪邊水線旁觀望十分鐘看水位有沒有變",
                    outcomeType = WarningLevel.WARNING,
                    safetyFeedback = "欠妥！站在溪邊水線等候若遇到突發山洪會缺乏反應時間，應全隊移至高處安全區再做長期觀察。"
                )
            ),
            expertAnalysis = "山區溪流的水位具有極高的「延遲性與突然性」。上游降雨累積至洪峰衝向下游，往往只有幾分鐘預警時間，水色可能在一瞬間從清澈變成滾滾泥流。絕不能因為「眼前還踩得到底」就抱持僥倖。",
            coreLesson = "不要只看眼前水位，要判斷水位是否正在變化。"
        ),
        CaseStudy(
            id = "case_b",
            tag = "案例 B",
            title = "有一條繩子，但水流很急",
            situation = "抵達橫渡點時，發現對岸與此岸之間綁著一條前人留下的固定繩索，但溪水水流非常湍急、白浪翻騰且水深及大腿。",
            question = "有人說「既然有拉好的繩子，抓緊繩子走過去就安全了」，你該如何應對？",
            options = listOf(
                CaseOption(
                    id = "b_cross",
                    label = "雙手抓緊繩子，一個接一個拉著繩過溪",
                    outcomeType = WarningLevel.PROHIBITION,
                    safetyFeedback = "極端危險！急流中抓繩一旦腳下打滑，水流會將人體向下游強推，強大的水阻會讓人連手都抓不住繩子，甚至將人反扣在繩索下方窒息。"
                ),
                CaseOption(
                    id = "b_retreat",
                    label = "堅決拒絕過溪，尋找平緩寬廣替代點或原路撤退",
                    outcomeType = WarningLevel.INFO,
                    safetyFeedback = "正確！「有繩 ≠ 可以過」。留下的舊繩無法消除急流的巨大推力與水下深坑風險，盲目抓繩是常見山難主因。"
                ),
                CaseOption(
                    id = "b_single",
                    label = "派最強壯的先鋒試拉繩子走過去看看",
                    outcomeType = WarningLevel.WARNING,
                    safetyFeedback = "危險！急流水壓巨大，即便是強壯隊員一旦失足也難以自拔，且隊伍缺乏專業救援系統。"
                )
            ),
            expertAnalysis = "繩索只是輔助控制系統，不能消除急流水流對身體的強大物理推力。前人留下的舊繩更可能存在風化、磨損或錨點鬆動的隱形風險。急流＋白浪代表能量高度集中，絕不能因為有繩而降低警戒。",
            coreLesson = "有繩不代表可以過。"
        ),
        CaseStudy(
            id = "case_c",
            tag = "案例 C",
            title = "河中有一塊大型沙洲",
            situation = "寬廣的溪床中間有一塊高出水面一公尺的大型沙洲，看起來平坦乾燥，隊伍打算先走上沙洲休息並作為中繼站。",
            question = "沙洲是否可以作為安全的暫停點與過渡策略？",
            options = listOf(
                CaseOption(
                    id = "c_rest",
                    label = "全隊上去沙洲卸背包煮水休息，再慢慢看怎麼過後半段",
                    outcomeType = WarningLevel.PROHIBITION,
                    safetyFeedback = "非常危險！沙洲是河道中的低窪沉積物，一旦兩側溪水暴漲，沙洲會瞬間被淹沒或沖刷崩解，全隊將變成進退兩難的孤島死局。"
                ),
                CaseOption(
                    id = "c_assess",
                    label = "不將沙洲視為安全區，評估能否一口氣安全上岸，否則不進",
                    outcomeType = WarningLevel.INFO,
                    safetyFeedback = "正確！沙洲 ≠ 安全區。進入中間區域可能切斷退路，必須確認進去之後依然保有全身而退的能力。"
                ),
                CaseOption(
                    id = "c_camp",
                    label = "若天黑乾脆在沙洲上搭帳篷過夜",
                    outcomeType = WarningLevel.PROHIBITION,
                    safetyFeedback = "致命錯誤！夜間山區若有暴雨，河中沙洲首當其衝，極易發生全隊遭洪水圍困或沖走慘劇。"
                )
            ),
            expertAnalysis = "沙洲給人「乾燥穩固」的假象，但它本質上就是河道的一部分。當水流上升時，最先被切斷的就是連接兩岸的淺水通道。千萬不要把「現在站得住」誤以為是「具備安全撤退能力」。",
            coreLesson = "沙洲不一定是安全區，必須確認是否可以安全撤退。"
        ),
        CaseStudy(
            id = "case_d",
            tag = "案例 D",
            title = "隊員背包很重，水流開始變強",
            situation = "過溪過到一半時，水深及膝且水流推力明顯增大，一名身材較瘦小的隊員感到腳步不穩、身體開始被水流帶偏，背包裝滿了重裝裝備。",
            question = "此時最優先的安全指導原則是什麼？",
            options = listOf(
                CaseOption(
                    id = "d_hold",
                    label = "大叫叫他死命抓住背包，千萬不要讓昂貴相機與裝備濕掉",
                    outcomeType = WarningLevel.PROHIBITION,
                    safetyFeedback = "致命思維！裝備可以重新買，生命只有一條。死抓重裝只會加劇水阻，讓人迅速失去平衡被水流吞噬。"
                ),
                CaseOption(
                    id = "d_release",
                    label = "指導立刻解開背包胸扣腰扣，必要時果斷脫卸背包以保人身安全",
                    outcomeType = WarningLevel.INFO,
                    safetyFeedback = "正確！「背包可以丟，人不能」。解除重裝水阻後人體自然產生浮力，能大幅提升自行爬起脫困的機會。"
                ),
                CaseOption(
                    id = "d_pull",
                    label = "旁邊隊友立刻衝過去用力拉扯他的背包",
                    outcomeType = WarningLevel.WARNING,
                    safetyFeedback = "危險！在急流中互相拉扯極易造成重心雙雙崩潰，導致兩人都被水流沖走。"
                )
            ),
            expertAnalysis = "在流動水體中，背包就像是一張吸滿水的風帆，會持續施加巨大阻力與旋轉扭力。當裝備開始妨礙人體維持平衡與脫困能力時，人的安全永遠且絕對優先於任何裝備。",
            coreLesson = "人的安全優先於裝備。（人包分離）"
        ),
        CaseStudy(
            id = "case_e",
            tag = "案例 E",
            title = "隊伍已經走到溪中央，水位突然上升",
            situation = "隊伍前鋒已抵達溪流中央，此時發現原本及小腿的水位迅速淹過膝蓋，水色開始轉黃，流速顯著加劇。",
            question = "進退兩難之際，「現在最重要的是什麼？」",
            options = listOf(
                CaseOption(
                    id = "e_rush",
                    label = "不管水多急，全隊咬緊牙關加速往前衝過對岸",
                    outcomeType = WarningLevel.PROHIBITION,
                    safetyFeedback = "極端危險！水勢正在急劇增強，越往對岸可能水更深流更急，盲目衝鋒極易在最深處全軍覆沒。"
                ),
                CaseOption(
                    id = "e_retreat",
                    label = "立即中止前進，全員保持重心穩定，果斷順勢撤回原出發岸",
                    outcomeType = WarningLevel.INFO,
                    safetyFeedback = "正確！不要繼續深入危險區，優先維持撤退能力與隊伍控制，退回熟悉的出發岸確保全體存活。"
                ),
                CaseOption(
                    id = "e_freeze",
                    label = "全體站在溪中央原地不動，等待水流自己變小",
                    outcomeType = WarningLevel.PROHIBITION,
                    safetyFeedback = "致命！水位持續上漲會迅速奪走站立能力，站在急流中停留越久，失溫與失足機率呈指數暴增。"
                )
            ),
            expertAnalysis = "在危險水文環境中，「及時認賠撤退」是最高生存法則。已經走到一半不代表必須硬過。面對正在暴漲的溪水，每一秒都在惡化，立刻轉身撤回出發岸是唯一能保全隊伍的冷靜決定。",
            coreLesson = "不要繼續深入危險區，優先維持撤退能力與隊伍控制。"
        )
    )

    val CHECKLIST_8_QUESTIONS: List<ChecklistItem> = listOf(
        ChecklistItem(
            id = 1,
            question = "上游有沒有下雨？",
            observationGuide = "抬頭觀察上游集水區山頭是否雲層低垂、天色晦暗或有雷聲雨瀑。",
            riskExplain = "上游降雨會引發下游滯後性山洪暴發。"
        ),
        ChecklistItem(
            id = 2,
            question = "水位有沒有正在上升？",
            observationGuide = "觀察岸邊露出的小石塊、乾枯草木是否在幾分鐘內被水線慢慢淹沒。",
            riskExplain = "水位上升代表洪峰正在接近，溪流推力急速增加。"
        ),
        ChecklistItem(
            id = 3,
            question = "水色有沒有突然變濁？",
            observationGuide = "對比溪水是否從清澈透明轉為黃褐色、泥漿色或漂浮大量細砂。",
            riskExplain = "水色變濁代表上游土石沖刷，水流密度大增。"
        ),
        ChecklistItem(
            id = 4,
            question = "水流是否過快？",
            observationGuide = "扔一根樹枝測試漂流速度，觀察水面是否有白浪翻騰與奔騰轟鳴聲。",
            riskExplain = "流速過快時，水深即使只有及膝也足以推倒成年人。"
        ),
        ChecklistItem(
            id = 5,
            question = "水下地形是否能合理判斷？",
            observationGuide = "用登山杖探測水底是否有深不見底的暗坑、巨石縫隙或鬆軟泥沼。",
            riskExplain = "腳卡在巨石縫中遭水流推壓是致命溺水主因。"
        ),
        ChecklistItem(
            id = 6,
            question = "下游是否存在致命障礙？",
            observationGuide = "檢查過溪點正下游是否有瀑布、落差、深潭、倒木堆或卡人岩壁。",
            riskExplain = "一旦失足，下游障礙將決定是輕傷還是致命二次傷害。"
        ),
        ChecklistItem(
            id = 7,
            question = "如果跌倒，我能不能撤退？",
            observationGuide = "評估自身體力、裝備扣具解開狀態與被沖走時的自救空間。",
            riskExplain = "不能抱著「絕對不會跌倒」的幻想下水。"
        ),
        ChecklistItem(
            id = 8,
            question = "如果情況突然變壞，整隊能不能撤？",
            observationGuide = "確認全隊是否均有共識與能力隨時中止渡溪並平安退回高處。",
            riskExplain = "隊伍的安全性取決於整體撤退能力而非單一先鋒。"
        )
    )

    val DECISION_FLOW_STEPS: List<DecisionNode> = listOf(
        DecisionNode(
            id = 1,
            stepTitle = "抵達溪邊",
            description = "登山路線遭遇溪水、溪床或河道橫渡點。",
            observationTip = "保持冷靜，不急躁。",
            passCondition = "進入標準評估程序",
            failAction = "不可直接涉水"
        ),
        DecisionNode(
            id = 2,
            stepTitle = "停下與集合",
            description = "全員於離水邊安全距離處停步集合，卸下冒進心態。",
            observationTip = "清點人員，統一指揮。",
            passCondition = "全員就位並保持安靜警戒",
            failAction = "嚴禁隊員自行先下水",
            isCriticalGate = true
        ),
        DecisionNode(
            id = 3,
            stepTitle = "觀察上游天候",
            description = "確認上游集水區與遠方山頭是否晴朗無雨。",
            observationTip = "觀察是否有烏雲、雨瀑或雷聲。",
            passCondition = "上游無降雨跡象",
            failAction = "若上游下雨 → 立即中止，撤往高處"
        ),
        DecisionNode(
            id = 4,
            stepTitle = "觀察水位與水色",
            description = "確認水線穩定無上升、水色清澈無泥沙漂流物。",
            observationTip = "岸邊定點石塊觀察 3-5 分鐘。",
            passCondition = "水線平穩、水色正常",
            failAction = "若水變濁或水位升 → 立即撤退"
        ),
        DecisionNode(
            id = 5,
            stepTitle = "觀察水流與下游",
            description = "確認流速平緩，正下游無瀑布、落差、倒木卡死區。",
            observationTip = "尋找失足後的緩衝安全出水區。",
            passCondition = "下游平緩開闊、無致命陷阱",
            failAction = "下游有瀑布倒木 → 另覓他處或撤退"
        ),
        DecisionNode(
            id = 6,
            stepTitle = "尋找替代路線",
            description = "評估是否有更平緩的上游淺灘、高繞步道或乾溪橋梁。",
            observationTip = "不要只看最近路線。",
            passCondition = "評估所有可能路徑優劣",
            failAction = "若有安全高繞路線 → 優先走高繞"
        ),
        DecisionNode(
            id = 7,
            stepTitle = "是否存在安全渡溪位置？",
            description = "確認具備「寬、緩、淺」特徵，且兩岸進出無峭壁阻礙。",
            observationTip = "寬緩淺 >> 窄急深。",
            passCondition = "找到寬緩淺之理想過渡點",
            failAction = "否 → 堅決撤退／改線原路折返",
            isCriticalGate = true
        ),
        DecisionNode(
            id = 8,
            stepTitle = "是否能保持安全撤退能力？",
            description = "評估進入水中任何階段，是否都能隨時安全退回出發岸。",
            observationTip = "不要進入會困住你的地方。",
            passCondition = "退路暢通，可隨時撤離",
            failAction = "否 → 撤退／改線",
            isCriticalGate = true
        ),
        DecisionNode(
            id = 9,
            stepTitle = "隊伍能力與裝備是否足夠？",
            description = "隊員體能健全、熟悉解扣、具備穩定度，無需臨時發明繩索。",
            observationTip = "不拿生命做未受訓實驗。",
            passCondition = "全隊狀況良好，裝備就緒",
            failAction = "否 → 不要進入，就地紮營或折返",
            isCriticalGate = true
        ),
        DecisionNode(
            id = 10,
            stepTitle = "執行渡溪",
            description = "解開背包胸腰扣，依序逐人前進，對岸接應，維持隊伍控制。",
            observationTip = "三點支撐，穩健踏踩。",
            passCondition = "全員安全抵達對岸",
            failAction = "中途遇阻 → 立即順水勢撤回出發岸"
        ),
        DecisionNode(
            id = 11,
            stepTitle = "過溪後清點全員",
            description = "清點人數、檢查傷勢、排查失溫與鞋襪背包進水狀況。",
            observationTip = "絕不鬆懈，落實清點。",
            passCondition = "全員平安無恙",
            failAction = "若有人員受傷 → 現場急救處理"
        ),
        DecisionNode(
            id = 12,
            stepTitle = "確認裝備與離開溪床",
            description = "確認通訊器具正常，迅速全隊移往高處安全步道離開河階。",
            observationTip = "脫離洪水潛在影響範圍。",
            passCondition = "安全踏上後續登山步道",
            failAction = "完成全套安全渡溪流程"
        )
    )
}
