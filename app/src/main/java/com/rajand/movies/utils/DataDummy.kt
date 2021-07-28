package com.rajand.movies.utils

import com.rajand.movies.data.source.local.entity.EpisodeEntity
import com.rajand.movies.data.source.local.entity.MovieEntity
import com.rajand.movies.data.source.local.entity.SeriesWithEpisode
import com.rajand.movies.data.source.remote.response.EpisodeResponse
import com.rajand.movies.data.source.remote.response.MovieResponse
import com.rajand.movies.data.source.remote.response.SeriesResponse

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
            384018,
            "Fast & Furious Presents: Hobbs & Shaw",
            "Ever since US Diplomatic Security Service Agent Hobbs and lawless outcast Shaw first faced off, they just have traded smack talk and body blows. But when cyber-genetically enhanced anarchist Brixton's ruthless actions threaten the future of humanity, they join forces to defeat him.",
            "Action, Adventure, Comedy",
            "2019-08-01",
            6.9,
            false,
            "https://image.tmdb.org/t/p/w500/qRyy2UmjC5ur9bDi3kpNNRCc5nc.jpg",
            Const.CATEGORY_MOVIE)
        )
        movies.add(
            MovieEntity(
            2,
            "Army of the Dead",
            "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
            "Action | Crime | Fiction | Horror",
            "2021",
            6.5,
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                Const.CATEGORY_MOVIE)
        )
        movies.add(
            MovieEntity(
            3,
            "Close",
            "A counter-terrorism expert takes a job protecting a young heiress. After an attempted kidnapping puts both of their lives in danger, they must flee.",
            "Action",
            "2021",
            5.8,
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4kjUGqPIv6kpxJUvjmeQX7nQpKd.jpg",
            Const.CATEGORY_MOVIE)
        )
        movies.add(
            MovieEntity(
            4,
            "Godzilla vs. Kong",
            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
            "Action | Fiction | Adventure",
            "2021",
            8.0,
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lrSjP0NS9urCQlSBaqs0kfmb5bY.jpg",
            Const.CATEGORY_MOVIE)
        )
        movies.add(
            MovieEntity(
            5,
            "Mulan",
            "When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet.",
            "Adventure | Fantasy",
            "2020",
            7.0,
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg",
            Const.CATEGORY_MOVIE)
        )
        movies.add(
            MovieEntity(
            6,
            "A Monster Calls",
            "A boy imagines a monster that helps him deal with his difficult life and see the world in a different way.",
            "Drama | Fantasy",
            "2016",
            7.2,
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fSmItIOMMURBLBP8ji2nzkhBo3t.jpg",
            Const.CATEGORY_MOVIE)
        )
        movies.add(
            MovieEntity(
            7,
            "The Conjuring",
            "Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse. Forced to confront a powerful entity, the Warrens find themselves caught in the most terrifying case of their lives.",
            "Horror",
            "2013",
            7.5,
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wVYREutTvI2tmxr6ujrHT704wGF.jpg",
            Const.CATEGORY_MOVIE)
        )
        movies.add(
            MovieEntity(
            8,
            "The Handmaid's Tale",
            "Set in a dystopian future, a woman is forced to live as a concubine under a fundamentalist theocratic dictatorship. A TV adaptation of Margaret Atwood's novel.",
            "Sci-fi | Fantasy | Drama",
            "2017",
            8.2,
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1ryCwZaZFAlG0c1w8XiMHeAxxYy.jpg",
            Const.CATEGORY_MOVIE)
        )
        movies.add(
            MovieEntity(
            9,
            "The Conjuring 2",
            "Lorraine and Ed Warren travel to north London to help a single mother raising four children alone in a house plagued by malicious spirits.",
            "Horror | Mystery",
            "2016",
            7.3,
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zEqyD0SBt6HL7W9JQoWwtd5Do1T.jpg",
            Const.CATEGORY_MOVIE)
        )
        movies.add(
            MovieEntity(
            10,
            "Lucifer",
            "Bored and unhappy as Lord of Hell, Lucifer Morningstar left his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to bring down criminals.",
            "Crime | Sci-fi & Fantasy",
            "2016",
            8.5,
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
            Const.CATEGORY_MOVIE)
        )
        movies.add(
            MovieEntity(
            11,
            "The Unholy",
            "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate.",
            "Horror",
            "2021",
            7.0,
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bShgiEQoPnWdw4LBrYT5u18JF34.jpg",
            Const.CATEGORY_MOVIE)
        )
        movies.add(
            MovieEntity(
            12,
            "Awake",
            "After a sudden global event wipes out all electronics and takes away humankind’s ability to sleep, chaos quickly begins to consume the world. Only Jill, an ex-soldier with a troubled past, may hold the key to a cure in the form of her own daughter.",
            "Action | Adventure | Drama | Fiction",
            "2021",
            6.3,
            false,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/uZkNbB8isWXHMDNoIbqXvmslBMC.jpg",
            Const.CATEGORY_MOVIE)
        )

        return movies
    }

    fun generateDummySeries(): List<MovieEntity> {

        val series = ArrayList<MovieEntity>()

        series.add(
            MovieEntity(
            1399,
            "Game of Thrones",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            "Sci-Fi & Fantasy",
            "2011-04-17",
            8.4,
            false,
            "https://image.tmdb.org/t/p/w500/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
            Const.CATEGORY_SERIES)
        )
        series.add(
            MovieEntity(
            2,
            "Person of Interes",
            "You are being watched. The government has a secret system, a machine that spies on you every hour of every day. I know because I built it. I designed the Machine to detect acts of terror but it sees everything. Violent crimes involving ordinary people. People like you. Crimes the government considered \\\"irrelevant\\\". They wouldn't act so I decided I would. But I needed a partner. Someone with the skills to intervene. Hunted by the authorities, we work in secret. You'll never find us. But victim or perpetrator, if your number is up, we'll find you.",
            "Action | Crime | Science-Fiction",
            "22-09-2011",
            8.9,
            false,
            "https://static.tvmaze.com/uploads/images/medium_portrait/163/407679.jpg",
            Const.CATEGORY_SERIES)
        )
        series.add(
            MovieEntity(
            3,
            "Bitten",
            "Based on the critically acclaimed series of novels from Kelley Armstrong. Set in Toronto and upper New York State, Bitten follows the adventures of 28-year-old Elena Michaels, the world's only female werewolf. An orphan, Elena thought she finally found her \\\"happily ever after\\\" with her new love Clayton, until her life changed forever. With one small bite, the normal life she craved was taken away and she was left to survive life with the Pack.",
            "Drama | Horror | Romance",
            "11-01-2014",
            7.5,
            false,
            "https://static.tvmaze.com/uploads/images/medium_portrait/0/15.jpg",
            Const.CATEGORY_SERIES)
        )
        series.add(
            MovieEntity(
            4,
            "Arrow",
            "After a violent shipwreck, billionaire playboy Oliver Queen was missing and presumed dead for five years before being discovered alive on a remote island in the Pacific. He returned home to Starling City, welcomed by his devoted mother Moira, beloved sister Thea and former flame Laurel Lance. With the aid of his trusted chauffeur/bodyguard John Diggle, the computer-hacking skills of Felicity Smoak and the occasional, reluctant assistance of former police detective, now beat cop, Quentin Lance, Oliver has been waging a one-man war on crime.",
            "Drama | Action | Science-Fiction",
            "10-10-2012",
            7.4,
            false,
            "https://static.tvmaze.com/uploads/images/medium_portrait/213/534017.jpg",
            Const.CATEGORY_SERIES)
        )
        series.add(
            MovieEntity(
            5,
            "True Detective",
            "Touch darkness and darkness touches you back. True Detective centers on troubled cops and the investigations that drive them to the edge. Each season features a new cast and a new case.",
            "Drama | Crime | Thriller",
            "12-01-2014",
            8.3,
            false,
            "https://static.tvmaze.com/uploads/images/medium_portrait/178/445621.jpg",
            Const.CATEGORY_SERIES)
        )
        series.add(
            MovieEntity(
            6,
            "The 100",
            "Ninety-seven years ago, nuclear Armageddon decimated planet Earth, destroying civilization. The only survivors were the 400 inhabitants of 12 international space stations that were in orbit at the time. Three generations have been born in space, the survivors now number 4,000, and resources are running out on their dying \"Ark\" - the 12 stations now linked together and repurposed to keep the survivors alive. Draconian measures including capital punishment and population control are the order of the day, as the leaders of the Ark take ruthless steps to ensure their future, including secretly exiling a group of 100 juvenile prisoners to the Earth's surface to test whether it's habitable.",
            "Action | Adventure | Science-Fiction",
            "19-03-2014",
            7.7,
            false,
            "https://static.tvmaze.com/uploads/images/medium_portrait/257/642675.jpg",
            Const.CATEGORY_SERIES)
        )
        series.add(
            MovieEntity(
            7,
            "Homeland",
            "The winner of 6 Emmy Awards including Outstanding Drama Series, Homeland is an edge-of-your-seat sensation. Marine Sergeant Nicholas Brody is both a decorated hero and a serious threat. CIA officer Carrie Mathison is tops in her field despite being bipolar. The delicate dance these two complex characters perform, built on lies, suspicion, and desire, is at the heart of this gripping, emotional thriller in which nothing short of the fate of our nation is at stake.",
            "Drama | Thriller | Espionage",
            "02-10-2011",
            8.2,
            false,
            "https://static.tvmaze.com/uploads/images/medium_portrait/230/575652.jpg",
            Const.CATEGORY_SERIES)
        )
        series.add(
            MovieEntity(
            8,
            "Glee",
            "Glee is a musical comedy about a group of ambitious and talented young adults in search of strength, acceptance and, ultimately, their voice.",
            "Drama | Music | Romance",
            "19-05-2009",
            6.8,
            false,
            "https://static.tvmaze.com/uploads/images/medium_portrait/0/73.jpg",
            Const.CATEGORY_SERIES)
        )
        series.add(
            MovieEntity(
            9,
            "Revenge",
            "This is not a story about forgiveness; Revenge is a show about retribution. Meet Emily Thorne, the newest resident of The Hamptons. When she was a little girl (and known as Amanda Clarke) her father, David Clarke, was framed for a horrific crime and subsequently sent to prison. While serving his time, the conspirators plotted and murdered David in order to prevent the truth from coming out. Emily is now back with a new identity and ready to take vengeance on the people that murdered her father and stole her childhood.",
            "Drama | Thriller | Mystery",
            "21-09-2011",
            7.7,
            false,
            "https://static.tvmaze.com/uploads/images/medium_portrait/82/206879.jpg",
            Const.CATEGORY_SERIES)
        )
        series.add(
            MovieEntity(
            10,
            "Grimm",
            "Grimm is a drama series inspired by the classic Grimm Brothers' Fairy Tales. After Portland homicide detective Nick Burkhardt discovers he's descended from an elite line of criminal profilers known as \"Grimms\", he increasingly finds his responsibilities as a detective at odds with his new responsibilities as a Grimm.",
            "Drama | Crime | Supernatural",
            "28-10-2011",
            8.5,
            false,
            "https://static.tvmaze.com/uploads/images/medium_portrait/69/174906.jpg",
            Const.CATEGORY_SERIES)
        )
        series.add(
            MovieEntity(
            11,
            "Gotham",
            "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            "Drama | Action | Crime",
            "22-09-2014",
            7.7,
            false,
            "https://static.tvmaze.com/uploads/images/medium_portrait/189/474715.jpg",
            Const.CATEGORY_SERIES)
        )

        return series
    }

    fun generateDummyEpisodes(seriesId: Int): ArrayList<EpisodeEntity> {

        val episodes = ArrayList<EpisodeEntity>()

        episodes.add(
            EpisodeEntity(
            1,
            seriesId,
            1,
            "Episode 1",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
            "24-06-2013",
            6.6)
        )
        episodes.add(
            EpisodeEntity(
            2,
            seriesId,
            2,
                "Episode 2",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                "24-06-2013",
                6.6)
        )
        episodes.add(
            EpisodeEntity(
            3,
            seriesId,
            3,
                "Episode 3",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                "24-06-2013",
                6.6)
        )
        episodes.add(
            EpisodeEntity(
            4,
            seriesId,
            4,
                "Episode 4",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                "24-06-2013",
                6.6)
        )
        episodes.add(
            EpisodeEntity(
            5,
            seriesId,
            5,
                "Episode 5",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                "24-06-2013",
                6.6)
        )
        episodes.add(
            EpisodeEntity(
            6,
            seriesId,
            6,
                "Episode 6",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                "24-06-2013",
                6.6)
        )
        episodes.add(
            EpisodeEntity(
            7,
            seriesId,
            7,
                "Episode 7",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                "24-06-2013",
                6.6)
        )
        episodes.add(
            EpisodeEntity(
            8,
            seriesId,
            8,
                "Episode 8",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                "24-06-2013",
                6.6)
        )
        episodes.add(
            EpisodeEntity(
            9,
            seriesId,
            9,
                "Episode 9",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                "24-06-2013",
                6.6)
        )
        episodes.add(
            EpisodeEntity(
            10,
            seriesId,
            10,
                "Episode 10",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                "24-06-2013",
                6.6)
        )
        episodes.add(
            EpisodeEntity(
            11,
            seriesId,
            11,
                "Episode 11",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                "24-06-2013",
                6.6)
        )
        episodes.add(
            EpisodeEntity(
            12,
            seriesId,
            12,
                "Episode 12",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                "24-06-2013",
                6.6)
        )
        episodes.add(
            EpisodeEntity(
            13,
            seriesId,
            13,
                "Episode 13",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                "24-06-2013",
                6.6)
        )

        return episodes
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {

        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse(
                "Ever since US Diplomatic Security Service Agent Hobbs and lawless outcast Shaw first faced off, they just have traded smack talk and body blows. But when cyber-genetically enhanced anarchist Brixton's ruthless actions threaten the future of humanity, they join forces to defeat him.",
                "2019-08-01",
                6.9,
                384018,
                "Fast & Furious Presents: Hobbs & Shaw",
                "Action, Adventure, Comedy",
                "https://image.tmdb.org/t/p/w500/qRyy2UmjC5ur9bDi3kpNNRCc5nc.jpg")
        )
        movies.add(
            MovieResponse(
                "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                "2021",
                6.5,
                2,
                "Army of the Dead",
                "Action | Crime | Fiction | Horror",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/z8CExJekGrEThbpMXAmCFvvgoJR.jpg")
        )
        movies.add(
            MovieResponse(
                "A counter-terrorism expert takes a job protecting a young heiress. After an attempted kidnapping puts both of their lives in danger, they must flee.",
                "2021",
                5.8,
                3,
                "Close",
                "Action",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4kjUGqPIv6kpxJUvjmeQX7nQpKd.jpg")
        )
        movies.add(
            MovieResponse(
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "2021",
                8.0,
                4,
                "Godzilla vs. Kong",
                "Action | Fiction | Adventure",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lrSjP0NS9urCQlSBaqs0kfmb5bY.jpg")
        )
        movies.add(
            MovieResponse(
                "When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet.",
                "2020",
                7.0,
                5,
                "Mulan",
                "Adventure | Fantasy",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg")
        )
        movies.add(
            MovieResponse(
                "A boy imagines a monster that helps him deal with his difficult life and see the world in a different way.",
                "2016",
                7.2,
                6,
                "A Monster Calls",
                "Drama | Fantasy",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fSmItIOMMURBLBP8ji2nzkhBo3t.jpg")
        )
        movies.add(
            MovieResponse(
                "Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse. Forced to confront a powerful entity, the Warrens find themselves caught in the most terrifying case of their lives.",
                "2013",
                7.5,
                7,
                "The Conjuring",
                "Horror",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wVYREutTvI2tmxr6ujrHT704wGF.jpg")
        )
        movies.add(
            MovieResponse(
                "Set in a dystopian future, a woman is forced to live as a concubine under a fundamentalist theocratic dictatorship. A TV adaptation of Margaret Atwood's novel.",
                "2017",
                8.2,
                8,
                "The Handmaid's Tale",
                "Sci-fi | Fantasy | Drama",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1ryCwZaZFAlG0c1w8XiMHeAxxYy.jpg")
        )
        movies.add(
            MovieResponse(
                "Lorraine and Ed Warren travel to north London to help a single mother raising four children alone in a house plagued by malicious spirits.",
                "2016",
                7.3,
                9,
                "The Conjuring 2",
                "Horror | Mystery",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zEqyD0SBt6HL7W9JQoWwtd5Do1T.jpg")
        )
        movies.add(
            MovieResponse(
                "Bored and unhappy as Lord of Hell, Lucifer Morningstar left his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to bring down criminals.",
                "2016",
                8.5,
                10,
                "Lucifer",
                "Crime | Sci-fi & Fantasy",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg")
        )
        movies.add(
            MovieResponse(
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate.",
                "2021",
                7.0,
                11,
                "The Unholy",
                "Horror",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bShgiEQoPnWdw4LBrYT5u18JF34.jpg")
        )
        movies.add(
            MovieResponse(
                "After a sudden global event wipes out all electronics and takes away humankind’s ability to sleep, chaos quickly begins to consume the world. Only Jill, an ex-soldier with a troubled past, may hold the key to a cure in the form of her own daughter.",
                "2021",
                6.3,
                12,
                "Awake",
                "Action | Adventure | Drama | Fiction",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/uZkNbB8isWXHMDNoIbqXvmslBMC.jpg")
        )
        return movies
    }

    fun generateRemoteDummySeries(): List<SeriesResponse> {

        val series = ArrayList<SeriesResponse>()

        series.add(
            SeriesResponse(
                "2011-04-17",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                8.4,
                "Game of Thrones",
                1399,
                "Sci-Fi & Fantasy",
                "https://image.tmdb.org/t/p/w500/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
        )
        series.add(
            SeriesResponse(
                "22-09-2011",
                "You are being watched. The government has a secret system, a machine that spies on you every hour of every day. I know because I built it. I designed the Machine to detect acts of terror but it sees everything. Violent crimes involving ordinary people. People like you. Crimes the government considered \\\"irrelevant\\\". They wouldn't act so I decided I would. But I needed a partner. Someone with the skills to intervene. Hunted by the authorities, we work in secret. You'll never find us. But victim or perpetrator, if your number is up, we'll find you.",
                8.9,
                "Person of Interes",
                2,
                "Action | Crime | Science-Fiction",
                "https://static.tvmaze.com/uploads/images/medium_portrait/163/407679.jpg")
        )
        series.add(
            SeriesResponse(
                "11-01-2014",
                "Based on the critically acclaimed series of novels from Kelley Armstrong. Set in Toronto and upper New York State, Bitten follows the adventures of 28-year-old Elena Michaels, the world's only female werewolf. An orphan, Elena thought she finally found her \\\"happily ever after\\\" with her new love Clayton, until her life changed forever. With one small bite, the normal life she craved was taken away and she was left to survive life with the Pack.",
                7.5,
                "Bitten",
                3,
                "Drama | Horror | Romance",
                "https://static.tvmaze.com/uploads/images/medium_portrait/0/15.jpg")
        )
        series.add(
            SeriesResponse(
                "10-10-2012",
                "After a violent shipwreck, billionaire playboy Oliver Queen was missing and presumed dead for five years before being discovered alive on a remote island in the Pacific. He returned home to Starling City, welcomed by his devoted mother Moira, beloved sister Thea and former flame Laurel Lance. With the aid of his trusted chauffeur/bodyguard John Diggle, the computer-hacking skills of Felicity Smoak and the occasional, reluctant assistance of former police detective, now beat cop, Quentin Lance, Oliver has been waging a one-man war on crime.",
                7.4,
                "Arrow",
                4,
                "Drama | Action | Science-Fiction",
                "https://static.tvmaze.com/uploads/images/medium_portrait/213/534017.jpg")
        )
        series.add(
            SeriesResponse(
                "12-01-2014",
                "Touch darkness and darkness touches you back. True Detective centers on troubled cops and the investigations that drive them to the edge. Each season features a new cast and a new case.",
                8.3,
                "True Detective",
                5,
                "Drama | Crime | Thriller",
                "https://static.tvmaze.com/uploads/images/medium_portrait/178/445621.jpg")
        )
        series.add(
            SeriesResponse(
                "19-03-2014",
                "Ninety-seven years ago, nuclear Armageddon decimated planet Earth, destroying civilization. The only survivors were the 400 inhabitants of 12 international space stations that were in orbit at the time. Three generations have been born in space, the survivors now number 4,000, and resources are running out on their dying \"Ark\" - the 12 stations now linked together and repurposed to keep the survivors alive. Draconian measures including capital punishment and population control are the order of the day, as the leaders of the Ark take ruthless steps to ensure their future, including secretly exiling a group of 100 juvenile prisoners to the Earth's surface to test whether it's habitable.",
                7.7,
                "The 100",
                6,
                "Action | Adventure | Science-Fiction",
                "https://static.tvmaze.com/uploads/images/medium_portrait/257/642675.jpg")
        )
        series.add(
            SeriesResponse(
                "02-10-2011",
                "The winner of 6 Emmy Awards including Outstanding Drama Series, Homeland is an edge-of-your-seat sensation. Marine Sergeant Nicholas Brody is both a decorated hero and a serious threat. CIA officer Carrie Mathison is tops in her field despite being bipolar. The delicate dance these two complex characters perform, built on lies, suspicion, and desire, is at the heart of this gripping, emotional thriller in which nothing short of the fate of our nation is at stake.",
                8.2,
                "Homeland",
                7,
                "Drama | Thriller | Espionage",
                "https://static.tvmaze.com/uploads/images/medium_portrait/230/575652.jpg")
        )
        series.add(
            SeriesResponse(
                "19-05-2009",
                "Glee is a musical comedy about a group of ambitious and talented young adults in search of strength, acceptance and, ultimately, their voice.",
                6.8,
                "Glee",
                8,
                "Drama | Music | Romance",
                "https://static.tvmaze.com/uploads/images/medium_portrait/0/73.jpg")
        )
        series.add(
            SeriesResponse(
                "21-09-2011",
                "This is not a story about forgiveness; Revenge is a show about retribution. Meet Emily Thorne, the newest resident of The Hamptons. When she was a little girl (and known as Amanda Clarke) her father, David Clarke, was framed for a horrific crime and subsequently sent to prison. While serving his time, the conspirators plotted and murdered David in order to prevent the truth from coming out. Emily is now back with a new identity and ready to take vengeance on the people that murdered her father and stole her childhood.",
                7.7,
                "Revenge",
                9,
                "Drama | Thriller | Mystery",
                "https://static.tvmaze.com/uploads/images/medium_portrait/82/206879.jpg")
        )
        series.add(
            SeriesResponse(
                "28-10-2011",
                "Grimm is a drama series inspired by the classic Grimm Brothers' Fairy Tales. After Portland homicide detective Nick Burkhardt discovers he's descended from an elite line of criminal profilers known as \"Grimms\", he increasingly finds his responsibilities as a detective at odds with his new responsibilities as a Grimm.",
                8.5,
                "Grimm",
                10,
                "Drama | Crime | Supernatural",
                "https://static.tvmaze.com/uploads/images/medium_portrait/69/174906.jpg")
        )
        series.add(
            SeriesResponse(
                "22-09-2014",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                7.7,
                "Gotham",
                11,
                "Drama | Action | Crime",
                "https://static.tvmaze.com/uploads/images/medium_portrait/189/474715.jpg")
        )

        return series
    }

    fun generateRemoteDummyEpisodes(): ArrayList<EpisodeResponse> {

        val episodes = ArrayList<EpisodeResponse>()

        episodes.add(
            EpisodeResponse(
                "24-06-2013",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                1,
                6.6,
                "Episode 1",
                1)
        )
        episodes.add(
            EpisodeResponse(
                "24-06-2013",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                2,
                6.6,
                "Episode 2",
                2)
        )
        episodes.add(
            EpisodeResponse(
                "24-06-2013",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                3,
                6.6,
                "Episode 3",
                3)
        )
        episodes.add(
            EpisodeResponse(
                "24-06-2013",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                4,
                6.6,
                "Episode 4",
                4)
        )
        episodes.add(
            EpisodeResponse(
                "24-06-2013",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                5,
                6.6,
                "Episode 5",
                5)
        )
        episodes.add(
            EpisodeResponse(
                "24-06-2013",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                6,
                6.6,
                "Episode 6",
                6)
        )
        episodes.add(
            EpisodeResponse(
                "24-06-2013",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                7,
                6.6,
                "Episode 7",
                7)
        )
        episodes.add(
            EpisodeResponse(
                "24-06-2013",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                8,
                6.6,
                "Episode 8",
                8)
        )
        episodes.add(
            EpisodeResponse(
                "24-06-2013",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                9,
                6.6,
                "Episode 9",
                9)
        )
        episodes.add(
            EpisodeResponse(
                "24-06-2013",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                10,
                6.6,
                "Episode 10",
                10)
        )
        episodes.add(
            EpisodeResponse(
                "24-06-2013",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                11,
                6.6,
                "Episode 11",
                11)
        )
        episodes.add(
            EpisodeResponse(
                "24-06-2013",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                12,
                6.6,
                "Episode 12",
                12)
        )
        episodes.add(
            EpisodeResponse(
                "24-06-2013",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                13,
                6.6,
                "Episode 13",
                13)
        )

        return episodes
    }

    fun generateDummySeriesWithEpisodes(series: MovieEntity, favorited: Boolean): SeriesWithEpisode {
        series.favorited = favorited
        return SeriesWithEpisode(series, generateDummyEpisodes(series.id))
    }

}